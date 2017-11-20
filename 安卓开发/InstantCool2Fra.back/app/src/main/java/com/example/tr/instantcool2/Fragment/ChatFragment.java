package com.example.tr.instantcool2.Fragment;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.tr.instantcool2.Activity.ChatActivity;
import com.example.tr.instantcool2.Activity.ConfirmInvitationActivity;
import com.example.tr.instantcool2.IndicatorView.List_Item_ChatFragment_IndicatorView;
import com.example.tr.instantcool2.IndicatorView.TopBarIndicatorView;
import com.example.tr.instantcool2.JavaBean.Conversation;
import com.example.tr.instantcool2.LocalDB.UserInfoSotrage;
import com.example.tr.instantcool2.R;
import com.example.tr.instantcool2.Utils.NetWorkUtil;
import com.example.tr.instantcool2.Utils.ShowInfoUtil;
import com.example.tr.instantcool2.Utils.StreamUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class ChatFragment extends Fragment implements TopBarIndicatorView.TopBarClickedListener{

    private final static int UPDATE_ADAPTER=1;
    private final static int UPDATE_UNREAD_COUNT=2;
    private final static int UPDATA_INVITATION = 3;
    private MyAdapter adapter;
    private Boolean isFirstStart = true;
    private ListView lv_conversation;
    private List<Conversation> list;
    private TopBarIndicatorView topbarview;
    private List_Item_ChatFragment_IndicatorView listItemChatFragmentIndicatorView;
    private TimerTask taskUnread;
    private Timer timer;
    private boolean flag=true;
    private TimerTask taskInvi;
    private Timer timerInvi;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==UPDATE_ADAPTER)lv_conversation.setAdapter(adapter);

            if(msg.what==UPDATE_UNREAD_COUNT){
                //更新listview相对的item未读数量
                Bundle data = msg.getData();
                int position = data.getInt("position");
                String unreadcount = data.getString("unreadcount");
                View child = lv_conversation.getChildAt(position);
                List_Item_ChatFragment_IndicatorView indicatorV = (List_Item_ChatFragment_IndicatorView) child.findViewById(R.id.indicator_list_view_user);
                indicatorV.setIv_unreadCount(Integer.parseInt(unreadcount));
            }

            if(msg.what==UPDATA_INVITATION){
                //在listview里添加一条好友邀请
                Bundle data = msg.getData();
                String[] inviter = data.getStringArray("inviter");
                for(int i=0;i<inviter.length;i++){
                    Conversation conversation = new Conversation();
                    conversation.setUnreadCount(0);
                    conversation.setTargetaccount("有新的好友请求！");
                    conversation.setTargetname(inviter[i]);
                    //并且全局静态变量中保存
                    UserInfoSotrage.inviters.add(inviter[i]);

                    list.add(conversation);
                }
                Log.d("data", "handleMessage: "+list.size());
                adapter.notifyDataSetChanged();
            }
        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化数据
        initConversationList();
        adapter = new MyAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat,container,false);
        topbarview = (TopBarIndicatorView) view.findViewById(R.id.topbar_container_chat_fragment);
        lv_conversation = (ListView) view.findViewById(R.id.lv_conversation_chat_fragment);


        initTopbar();
        //开启检测消息未读数量线程
        initUnreadDetech();
        //开启检测是否有好友请求线程
        initInvitationDetech();


        //listview item点击事件 点击后进入聊天界面并且设置未读数量为0
        lv_conversation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                listItemIndicatorView.setIv_unreadCount(29);
                //点击后修改Conversation list数据源里的unreadCount然后重新绑定后启动ChatActivity

                int firstPosition = lv_conversation.getFirstVisiblePosition();
//                if(position-firstPosition>0){
                    View itemView = lv_conversation.getChildAt(position);
                    List_Item_ChatFragment_IndicatorView view1 = (List_Item_ChatFragment_IndicatorView) itemView.findViewById(R.id.indicator_list_view_user);
                    view1.setIv_unreadCount(0);
//                }
                //TODO 进入交流界面

                //如果acccount是新好友请求 进入请求页面
                Conversation conversation = list.get(position);
                String targetaccount = conversation.getTargetaccount();
                String targetname = conversation.getTargetname();
                if(targetaccount.equals("有新的好友请求！")){
                    //进入请求界面
                    Intent intent = new Intent(getActivity(), ConfirmInvitationActivity.class);
                    intent.putExtra("targetaccount",targetname);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getActivity(), ChatActivity.class);
                    intent.putExtra("friendaccount",targetaccount);
                    intent.putExtra("friendname",targetname);
                    startActivity(intent);
                }


//                Intent intent = new Intent(getActivity(), ChatActivity.class);
//                startActivity(intent);
            }

        });

        return view;
    }


    //检测是否有人发送好友邀请 有则交给主线程处理
    //TODO 存在bug  需要修改
    private void initInvitationDetech() {
        timerInvi = new Timer();
        taskInvi = new TimerTask() {
            @Override
            public void run() {
                try {
                    String path="http://39.108.159.175/phpworkplace/androidLogin/GetInvitation.php?receiver="+ URLEncoder.encode(UserInfoSotrage.Account,"utf-8");
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("GET");
                    int code = connection.getResponseCode();
                    InputStream in= connection.getInputStream();

//                    Log.d("ChatFragmentInvitation", "return info"+StreamUtil.readStream(in));
                    if(200==code){
                        //复制流信息 待会解析两次
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = in.read(buffer)) > -1 ) {
                            baos.write(buffer, 0, len);
                        }
                        baos.flush();
                        //第一次解析用来判断值是否为空
                        InputStream streamJudge = new ByteArrayInputStream(baos.toByteArray());
                        String returnInfo = StreamUtil.readStream(streamJudge);
//                        Log.d("ChatFragmentInvitation", "return info"+returnInfo);
//                        Log.d("ChatFragmentInvitation", "return info"+StreamUtil.readStream(in));

                        if(returnInfo.equals("")){
//                            Log.d("ChatFragmentInvitation", "No Inviter");
                            //没人邀请
                        }else{
                            //有人邀请
                            //解析xml流
                            Log.d("ChatFragmentInvitation", "解析中");
                            InputStream streamInfo = new ByteArrayInputStream(baos.toByteArray());
                            List<String> invitaitonList = StreamUtil.XmlParserInvitation(streamInfo);
                            if(invitaitonList==null){
                                Log.d("ChatFragmentInvitation", "解析失败 返回为空");
                                return;
                            }
                            String[] invitationS = new String[invitaitonList.size()];
                            Log.d("ChatFragmentInvitation", "解析中 大小："+invitationS.length+";");
                            for(int i=0;i<invitaitonList.size();i++){
                                invitationS[i] = invitaitonList.get(i);
                                Log.d("ChatFragmentInvitation", "run: "+invitationS[i]);
                            }
                            Message msg  = new Message();
                            msg.what=3;
                            Bundle data = new Bundle();
                            data.putStringArray("inviter",invitationS);
                            msg.setData(data);
                            handler.sendMessage(msg);
                        }
                    }else{}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timerInvi.schedule(taskInvi,1000,1000);

    }

    //                遍历查看未读数量
    private void initUnreadDetech() {
                initTimerDetechUnreadCount();
//                timer.schedule(taskUnread,0,1000);
    }


    //切换fragment导致丢失绑定 重新绑定
    @Override
    public void onStart() {
        super.onStart();
        if(!isFirstStart)
        lv_conversation.setAdapter(adapter);
        isFirstStart=false;
    }

    //初始化topbar
    private void initTopbar(){
        topbarview.setTitle("会话");
        topbarview.setTopBarOnClickedListener(this);
    }

    //初始化list数据
    private void initConversationList(){
        new Thread(){
            @Override
            public void run() {
                String path = "http://39.108.159.175/phpworkplace/androidLogin/GetConversation.php?owner="+ UserInfoSotrage.Account;
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    int responseCode = connection.getResponseCode();
                    if(responseCode==200){
                        InputStream inputStream = connection.getInputStream();
                        //解析xml流信息
                        list = StreamUtil.XmlParserConversation(inputStream);

                        Log.d("chat", "run: "+list.size());

                        //解析完毕添加适配器 在某些手机会直接因为不能在线程中修改失败 使用handler
//                        lv_conversation.setAdapter(new MyAdapter());
                        Message msg = new Message();
                        msg.what=1;
                        handler.sendMessage(msg);
                    }else{
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ShowInfoUtil.showInfo(getContext(),"初始化会话失败！");
                            }
                        });
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    @Override
    public void onResume() {
        super.onResume();

    }

    //
    private void initTimerDetechUnreadCount(){
        if(taskUnread!=null)taskUnread.cancel();
        if(timer!=null)timer.cancel();

        timer=new Timer();
        taskUnread = new TimerTask() {
            @Override
            public void run() {
                View v;
                List_Item_ChatFragment_IndicatorView indicatorV;
                Log.d("initUnreadDetech", "run: "+lv_conversation.getChildCount());
                for(int i=0;i<lv_conversation.getChildCount();i++) {
                    v = lv_conversation.getChildAt(i);
                    indicatorV = (List_Item_ChatFragment_IndicatorView) v.findViewById(R.id.indicator_list_view_user);
                    String account = indicatorV.getAccount();
                    if (!account.equals("有新的好友请求！")) {
                        String path = "http://39.108.159.175/phpworkplace/androidLogin/GetTheMessageCountSingle.php?owner=" + UserInfoSotrage.Account + "&receiver=" + account;
                        String unreadCount = NetWorkUtil.DetechUnreadCount(path);

                        //通知主线程修改
                        Message msg = new Message();
                        Bundle data = new Bundle();
                        data.putInt("position", i);
                        data.putString("unreadcount", unreadCount);
                        msg.what = 2;
                        msg.setData(data);
                        handler.sendMessage(msg);
//                            indicatorV.setIv_unreadCount(Integer.parseInt(unreadCount));
                    }
                }
            }
        };
        timer.schedule(taskUnread,0,1000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        taskUnread.cancel();
        timer.cancel();
        taskInvi.cancel();
        timerInvi.cancel();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void OnBackClicked() {
        new Thread(){
            @Override
            public void run() {
                Instrumentation inst = new Instrumentation();
                inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
            }
        }.start();
    }

    //适配器
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final View view;
            if(convertView==null){
                view = View.inflate(getContext(),R.layout.item_listview_chat_fragment,null);
            }else{
                view = convertView;
            }
            listItemChatFragmentIndicatorView = (List_Item_ChatFragment_IndicatorView) view.findViewById(R.id.indicator_list_view_user);
//            TextView tv_account = (TextView) view.findViewById(R.id.tv);
//            TextView tv_name = (TextView) view.findViewById(R.id.item_listview_chat_fragment);
//            Conversation conversation = list.get(position);
//            tv_account.setText("好友账户："+conversation.getTargetaccount());
//            tv_name.setText("好友姓名："+conversation.getTargetname());
            Conversation conversation = list.get(position);
            listItemChatFragmentIndicatorView.setTv_account(conversation.getTargetaccount());
            listItemChatFragmentIndicatorView.setTv_name(conversation.getTargetname());
//            listItemChatFragmentIndicatorView.setIv_unreadCount(99);

            return view;
        }
    }
}
