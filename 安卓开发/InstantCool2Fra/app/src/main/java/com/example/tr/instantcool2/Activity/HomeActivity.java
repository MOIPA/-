package com.example.tr.instantcool2.Activity;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TabHost;

import com.example.tr.instantcool2.Fragment.ChatFragment;
import com.example.tr.instantcool2.Fragment.FunctionFragment;
import com.example.tr.instantcool2.Fragment.FriendsFragment;
import com.example.tr.instantcool2.Fragment.MeFragment;
import com.example.tr.instantcool2.LocalDB.UserInfoSotrage;
import com.example.tr.instantcool2.R;
import com.example.tr.instantcool2.IndicatorView.TabindicatorView;
import com.example.tr.instantcool2.Utils.NetWorkUtil;
import com.example.tr.instantcool2.Utils.ShowInfoUtil;
import com.example.tr.instantcool2.Utils.StreamUtil;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//最后还是决定由HomeActivity实现OnTabChangeListener
// 因为选中时需要把所有人都不选中 内部类无法获取外部的TabindicatorView
public class HomeActivity extends FragmentActivity implements TabHost.OnTabChangeListener,ViewPager.OnPageChangeListener {
    private final static String TAG_CHAT = "chat";
    private final static String TAG_Friends = "friends";
    private final static String TAG_Functions = "functions";
    private final static String TAG_MY = "my";
    private FragmentTabHost tabHost;
    private ViewPager viewPager;
    private static final String[] IDS = {"chat", "friends", "functions", "my"};
    private List<String> ids = Arrays.asList(IDS);
    List<Fragment> fragments = new ArrayList<Fragment>(IDS.length);
    private TimerTask task;
    private Timer timer;
    TabindicatorView chatIndicator;
    TabindicatorView findIndicator;
    TabindicatorView connecotrIndicator;
    TabindicatorView meIndicator;
    private final int REFRESH_CHAT_INDICATOR = 1;
    private final int CLEAR_CHAT_INDICATOR= 2;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==REFRESH_CHAT_INDICATOR&&!chatIndicator.isSelected()){
                Bundle data = msg.getData();
                int number = data.getInt("number");
                chatIndicator.setTabUnreadCount(number);
            }

            if(chatIndicator.isSelected()){
                chatIndicator.setTabUnreadCount(0);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //初始化tabhost
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.main_viewpager);
        chatIndicator = new TabindicatorView(this);
        findIndicator = new TabindicatorView(this);
        connecotrIndicator = new TabindicatorView(this);
        meIndicator = new TabindicatorView(this);

        init("消息", TAG_CHAT, chatIndicator,new ChatFragment());
        init("好友", TAG_Friends, findIndicator,new FriendsFragment());
        init("功能", TAG_Functions, connecotrIndicator,new FunctionFragment());
        init("我", TAG_MY, meIndicator,new MeFragment());

        //初始化viewpager
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        viewPager.setAdapter(new TabsFragmentPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.setOnPageChangeListener(this);

        //初始化topbar

        //开启自动检测消息线程
        detectUnreadMessageCount();
    }


    private void detectUnreadMessageCount(){
        //每隔一秒检测是否有新消息 查询消息未读总数量设置chatIndicator未读数
        new Thread(){
            @Override
            public void run() {
                timer = new Timer();
                //初始化task
                initTask();
                timer.schedule(task,500,500);
                Log.d("detect", "run: detect thread!");
            }
        }.start();
    }

    //初始化task方法 用于得知未读消息通知主线程刷新
    private void initTask(){
        task = new TimerTask() {
            @Override
            public void run() {
                Bundle bundle = NetWorkUtil.getSingleInfoFromServer("http://39.108.159.175/phpworkplace/androidLogin/GetTheMessageCount.php?receiver=" + UserInfoSotrage.Account);
                String result = bundle.getString("result");
                Log.d("detect", "run: detect thread!"+result+":"+UserInfoSotrage.Account);
//                        chatIndicator.setTabUnreadCount(1);
                //通知主线程刷新tab
                Bundle bud = new Bundle();
                bud.putInt("number",Integer.parseInt(result));
                Message msg = new Message();
                msg.what=REFRESH_CHAT_INDICATOR;
                msg.setData(bud);
                handler.sendMessage(msg);
            }
        };
    }

    private void init(String title, String TAG, TabindicatorView indicator, Fragment fragment) {
        //新建tabspec
        TabHost.TabSpec spec = tabHost.newTabSpec(TAG);
//        TabindicatorView indicator = new TabindicatorView(this);
        indicator.setTabUnreadCount(0);
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

        fragments.add(Fragment.instantiate(this, fragment.getClass().getName()));
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

        viewPager.setCurrentItem(ids.indexOf(tabId));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if(task!=null)
        //结束时取消线程
        task.cancel();
        ChangeUserLoginStatus();
    }

    /**
     * 在honmeactivity  pause时或者stop时结束task节省资源
     * 恢复时重新初始化task
     */

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        if(task==null){
//            detectUnreadMessageCount();
//        }
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if(task!=null)task.cancel();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if(task!=null)task.cancel();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if(task==null){
//            detectUnreadMessageCount();
//        }
//    }

    private void ChangeUserLoginStatus(){
        //改变用户登陆状态为未登陆
        new Thread(){
            @Override
            public void run() {
                try {
                    String statusPath = "http://39.108.159.175/phpworkplace/androidLogin/SetUserStatus.php?name="+ URLEncoder.encode(UserInfoSotrage.Account,"utf-8")+"&status="+0;
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
                            @RequiresApi(api = Build.VERSION_CODES.M)
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



    //重写viewpager方法
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class TabsFragmentPagerAdapter extends FragmentPagerAdapter{

        List<Fragment> mfragments;

        public TabsFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            this.mfragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mfragments.get(position);
        }

        @Override
        public int getCount() {
            return mfragments.size();
        }
    }
}


