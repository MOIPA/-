package com.example.tr.instantcool2.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

import com.example.tr.instantcool2.Fragment.ChatFragment;
import com.example.tr.instantcool2.Fragment.FunctionFragment;
import com.example.tr.instantcool2.Fragment.FriendsFragment;
import com.example.tr.instantcool2.Fragment.MeFragment;
import com.example.tr.instantcool2.IndicatorView.TopBarIndicatorView;
import com.example.tr.instantcool2.LocalDB.UserInfoSotrage;
import com.example.tr.instantcool2.R;
import com.example.tr.instantcool2.IndicatorView.TabindicatorView;
import com.example.tr.instantcool2.Utils.ShowInfoUtil;
import com.example.tr.instantcool2.Utils.StreamUtil;

import java.net.HttpURLConnection;
import java.net.URL;

//最后还是决定由HomeActivity实现OnTabChangeListener
// 因为选中时需要把所有人都不选中 内部类无法获取外部的TabindicatorView
public class HomeActivity extends FragmentActivity implements TabHost.OnTabChangeListener{
    private final static String TAG_CHAT = "chat";
    private final static String TAG_Friends = "friends";
    private final static String TAG_Functions = "functions";
    private final static String TAG_MY = "my";
    private FragmentTabHost tabHost;
    TabindicatorView chatIndicator;
    TabindicatorView findIndicator;
    TabindicatorView connecotrIndicator;
    TabindicatorView meIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //初始化tabhost
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.activity_home_container);
        chatIndicator = new TabindicatorView(this);
        findIndicator = new TabindicatorView(this);
        connecotrIndicator = new TabindicatorView(this);
        meIndicator = new TabindicatorView(this);

        init("消息", TAG_CHAT, chatIndicator,new ChatFragment());
        init("好友", TAG_Friends, findIndicator,new FriendsFragment());
        init("功能", TAG_Functions, connecotrIndicator,new FunctionFragment());
        init("我", TAG_MY, meIndicator,new MeFragment());

        //初始化topbar

    }



    private void init(String title, String TAG, TabindicatorView indicator, Fragment fragment) {
        //新建tabspec
        TabHost.TabSpec spec = tabHost.newTabSpec(TAG);
//        TabindicatorView indicator = new TabindicatorView(this);
        indicator.setTableTitle(title);
        indicator.setTableIcon(R.mipmap.ic_launcher, R.mipmap.ic_launcher_round);
        spec.setIndicator(indicator);
//        spec.setIndicator(view)
        //添加tabspec
        tabHost.addTab(spec, fragment.getClass(), null);
        //消去分割线
        tabHost.getTabWidget().setDividerDrawable(android.R.color.white);
        //默认第一个为选中
        tabHost.setCurrentTabByTag(TAG_CHAT);
        chatIndicator.setTabSelected(true);
        //监听选中事件
        tabHost.setOnTabChangedListener(this);
    }

    //设置tabhost选中事件
    @Override
    public void onTabChanged(String tabId) {
        //要让某个选中得先全部不选中
        chatIndicator.setTabSelected(false);
        meIndicator.setTabSelected(false);
        connecotrIndicator.setTabSelected(false);
        findIndicator.setTabSelected(false);

        switch (tabId) {
            case TAG_CHAT:
                chatIndicator.setTabSelected(true);
                break;
            case TAG_Functions:
                connecotrIndicator.setTabSelected(true);
                break;
            case TAG_Friends:
                findIndicator.setTabSelected(true);
                break;
            case TAG_MY:
                meIndicator.setTabSelected(true);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //改变用户登陆状态为未登陆
        new Thread(){
            @Override
            public void run() {
                try {
                    String statusPath = "http://39.108.159.175/phpworkplace/androidLogin/SetUserStatus.php?name="+ UserInfoSotrage.AName+"&status="+0;
                    URL url = new URL(statusPath);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    int code1 = conn.getResponseCode();
                    if(200==code1){
                        final String satus = StreamUtil.readStream(conn.getInputStream()).trim();
                        Log.d("Login", "status is: "+satus);
                    }else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ShowInfoUtil.showInfo(getApplicationContext(),"链接服务器失败");
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
    public void onBackPressed() {
        super.onBackPressed();
    }
}


