package com.example.tr.instantcool2.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tr.instantcool2.LocalDB.UserInfoSotrage;
import com.example.tr.instantcool2.R;
import com.example.tr.instantcool2.Utils.ShowInfoUtil;

import java.net.HttpURLConnection;
import java.net.URL;

public class FriendInfoActivity extends Activity {

    private TextView tv_friendName;
    private TextView tv_friendAccount;
    private String willAddFriend;
    private Button btnSend;
    private Button btnAdd;
    private String friendname;
    private String friendaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_info);

        final Intent intent = getIntent();
        friendname = intent.getStringExtra("friendname");
        friendaccount = intent.getStringExtra("friendaccount");
        willAddFriend = intent.getStringExtra("willAddFriend");

        tv_friendAccount = (TextView) findViewById(R.id.tv_friend_info_account);
        tv_friendName = (TextView) findViewById(R.id.tv_friend_info_name);
        btnAdd = (Button) findViewById(R.id.btn_friend_info_add_friend);
        tv_friendAccount.setText(friendaccount);
        tv_friendName.setText(friendname);
        btnSend = (Button) findViewById(R.id.btn_friend_info_send_message);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                //进入交流页面 并且判断是否可以插入Conversation 可以就插入
                //判断逻辑
                InsertConversation();


            }
        });

        if(willAddFriend!=null&&willAddFriend.equals("yes")){
            //如果添加好友不为空则显示按钮并且添加监听
            //并且取消发送信息按钮
            btnSend.setVisibility(View.GONE);
            btnAdd.setVisibility(View.VISIBLE);
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Thread(){
                        @Override
                        public void run() {
                            if(UserInfoSotrage.AName.equals(friendaccount)){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ShowInfoUtil.showInfo(getApplicationContext(),"your self!");
                                    }
                                });
                            }
                            else  {
                                String path = "http://39.108.159.175/phpworkplace/androidLogin/SendInvitation.php?inviter="+UserInfoSotrage.AName+"&targetaccount="+friendaccount+"&isagree=0";

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ShowInfoUtil.showInfo(getApplicationContext(),"请求已发送!");
                                    }
                                });

                            }

                        }
                    }.start();
                }
            });
        }
    }

    //插入会话
    private void InsertConversation(){
        new Thread(){
            @Override
            public void run() {
                try{

                    String path="http://39.108.159.175/phpworkplace/androidLogin/InsertConversation.php?" +
                            "owner="+ UserInfoSotrage.AName+"&targetaccount="+friendaccount+"&targetname="+friendname;
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setRequestMethod("GET");
                    int code=conn.getResponseCode();
                    if(200==code){
                        //没必要  反正插入不成功也没事
                    }else{
                        Log.d("FriendInfo", "链接服务器失败");
                    }


                }catch(Exception e){}
            }
        }.start();
    }
}
