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
import android.widget.TextView;

import com.example.tr.instantcool2.Activity.ChatActivity;
import com.example.tr.instantcool2.IndicatorView.ListItemIndicatorView;
import com.example.tr.instantcool2.IndicatorView.TopBarIndicatorView;
import com.example.tr.instantcool2.JavaBean.Conversation;
import com.example.tr.instantcool2.JavaBean.MyAccount;
import com.example.tr.instantcool2.LocalDB.UserInfoSotrage;
import com.example.tr.instantcool2.R;
import com.example.tr.instantcool2.Utils.ShowInfoUtil;
import com.example.tr.instantcool2.Utils.StreamUtil;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ChatFragment extends Fragment implements TopBarIndicatorView.TopBarClickedListener{

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1)lv_conversation.setAdapter(new MyAdapter());
        }
    };
    private ListView lv_conversation;
    private List<Conversation> list;
    private TopBarIndicatorView topbarview;
    private ListItemIndicatorView listItemIndicatorView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat,container,false);
        topbarview = (TopBarIndicatorView) view.findViewById(R.id.topbar_container_chat_fragment);
        lv_conversation = (ListView) view.findViewById(R.id.lv_conversation_chat_fragment);

        initConversationList();
        initTopbar();
        //开启后台服务检测用户消息，若有消息则计算未读消息数并且传递到homeActivity 调用indicator的unread


        //listview item点击事件
        lv_conversation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                listItemIndicatorView.setIv_unreadCount(29);
                //点击后修改Conversation list数据源里的unreadCount然后重新绑定后启动ChatActivity

                int firstPosition = lv_conversation.getFirstVisiblePosition();
//                if(position-firstPosition>0){
                    View itemView = lv_conversation.getChildAt(position);
                    ListItemIndicatorView view1 = (ListItemIndicatorView) itemView.findViewById(R.id.indicator_list_view_user);
                    view1.setIv_unreadCount(0);
//                }


//                Intent intent = new Intent(getActivity(), ChatActivity.class);
//                startActivity(intent);
            }

        });

        return view;
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
                String path = "http://39.108.159.175/phpworkplace/androidLogin/GetConversation.php?owner="+ UserInfoSotrage.AName;
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
            listItemIndicatorView = (ListItemIndicatorView) view.findViewById(R.id.indicator_list_view_user);
//            TextView tv_account = (TextView) view.findViewById(R.id.tv);
//            TextView tv_name = (TextView) view.findViewById(R.id.item_listview_chat_fragment);
//            Conversation conversation = list.get(position);
//            tv_account.setText("好友账户："+conversation.getTargetaccount());
//            tv_name.setText("好友姓名："+conversation.getTargetname());
            Conversation conversation = list.get(position);
            listItemIndicatorView.setTv_account(conversation.getTargetaccount());
            listItemIndicatorView.setTv_name(conversation.getTargetname());
            listItemIndicatorView.setIv_unreadCount(99);

            return view;
        }
    }
}
