package com.example.tr.instantcool2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.widget.TabHost;

//最后还是决定由HomeActivity实现OnTabChangeListener
// 因为选中时需要把所有人都不选中 内部类无法获取外部的TabindicatorView
public class HomeActivity extends FragmentActivity implements TabHost.OnTabChangeListener {
    private final static String TAG_CHAT = "chat";
    private final static String TAG_FIND = "find";
    private final static String TAG_CONECTER = "connecter";
    private final static String TAG_MY = "my";
    private FragmentTabHost tabHost;
    TabindicatorView chatIndicator;
    TabindicatorView findIndicator;
    TabindicatorView connecotrIndicator;
    TabindicatorView meIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);

        //初始化tabhost
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.activity_home_container);

        chatIndicator = new TabindicatorView(this);
        findIndicator = new TabindicatorView(this);
        connecotrIndicator = new TabindicatorView(this);
        meIndicator = new TabindicatorView(this);

        init("消息", TAG_CHAT, chatIndicator,new ChatFragment());
        init("发现", TAG_FIND, findIndicator,new FindFragment());
        init("通讯录", TAG_CONECTER, connecotrIndicator,new ConnectorFragment());
        init("我", TAG_MY, meIndicator,new MeFragment());
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
            case TAG_CONECTER:
                connecotrIndicator.setTabSelected(true);
                break;
            case TAG_FIND:
                findIndicator.setTabSelected(true);
                break;
            case TAG_MY:
                meIndicator.setTabSelected(true);
                break;
        }
    }

}


