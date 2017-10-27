package com.example.tr.instantcool2.Fragment;


import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.tr.instantcool2.Activity.AddFriendActivity;
import com.example.tr.instantcool2.Activity.FriendInfoActivity;
import com.example.tr.instantcool2.IndicatorView.List_Item_FriendFragment_indicatorView;
import com.example.tr.instantcool2.IndicatorView.TopBarIndicatorFriendsView;
import com.example.tr.instantcool2.JavaBean.Friend;
import com.example.tr.instantcool2.LocalDB.UserInfoSotrage;
import com.example.tr.instantcool2.R;
import com.example.tr.instantcool2.Utils.ShowInfoUtil;
import com.example.tr.instantcool2.Utils.StreamUtil;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class FriendsFragment extends Fragment implements TopBarIndicatorFriendsView.TopBarClickedListener{

    private List<Friend> friends;
    private ListView lv_friend;
    private List_Item_FriendFragment_indicatorView itemIndicator;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                //add adapter
                lv_friend.setAdapter(new MyAdapter());
            }
        }
    };

    private TopBarIndicatorFriendsView topBarIndicatorView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        lv_friend = (ListView) view.findViewById(R.id.lv_friend_fragment_f);
        topBarIndicatorView = (TopBarIndicatorFriendsView) view.findViewById(R.id.topbar_container_friend_fragment);
        initData();
        initTopBar();

        lv_friend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击进入好友详细信息页面
                Friend friend = friends.get(position);
                Intent intent = new Intent(getActivity(), FriendInfoActivity.class);
                intent.putExtra("friendname",friend.getFriendName());
                intent.putExtra("friendaccount",friend.getFriendAccount());
                startActivity(intent);
            }
        });

        return view;
    }

    private List<Friend> initData() {

        new Thread(){
            @Override
            public void run() {
                try{

                    String path= "http://39.108.159.175/phpworkplace/androidLogin/GetFriend.php?owner="+ UserInfoSotrage.AName;
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    int responseCode = connection.getResponseCode();
                    if(responseCode==200){
                        InputStream inputStream = connection.getInputStream();
                        //解析xml流信息
                        friends = StreamUtil.XmlParserFriend(inputStream);


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


                }catch(Exception e){}
            }
        }.start();

        return friends;
    }

    private void initTopBar(){
        topBarIndicatorView.setTitle("好友列表");
        topBarIndicatorView.setTopBarOnClickedListener(this);
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return friends.size();
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
                view = View.inflate(getContext(),R.layout.iten_listview_friend_fragment,null);
            }else{
                view = convertView;
            }
            itemIndicator = (List_Item_FriendFragment_indicatorView) view.findViewById(R.id.item_friend_fragment_lv);
            Friend friend = friends.get(position);
            itemIndicator.setTv_name(friend.getFriendName());
            itemIndicator.setTv_account(friend.getFriendAccount());

            return view;
        }
    }

    @Override
    public void OnBackClicked() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Thread(){
                    @Override
                    public void run() {
                        Instrumentation inst = new Instrumentation();
                        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    }
                }.start();
            }
        });
    }

    @Override
    public void OnAddClicked() {
        //add friend
        //启动添加好友活动
        Intent intent = new Intent(getActivity(), AddFriendActivity.class);
        startActivity(intent);
    }
}
