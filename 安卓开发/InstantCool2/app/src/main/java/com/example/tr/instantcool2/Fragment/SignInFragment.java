package com.example.tr.instantcool2.Fragment;

import android.app.Instrumentation;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tr.instantcool2.IndicatorView.TopBarIndicatorView;
import com.example.tr.instantcool2.R;
import com.example.tr.instantcool2.Utils.ShowInfoUtil;


public class SignInFragment extends Fragment implements TopBarIndicatorView.TopBarClickedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private TopBarIndicatorView topBarIndicatorView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        topBarIndicatorView = (TopBarIndicatorView) view.findViewById(R.id.topbar_container_sign_in);
        initTopBar();
        return view;
    }

    private void initTopBar() {
        topBarIndicatorView.setTitle("登陆");
        topBarIndicatorView.setTopBarOnClickedListener(this);
    }


    @Override
    public void OnBackClicked() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                ShowInfoUtil.showInfo(getContext(),"返回执行");
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        Instrumentation inst = new Instrumentation();
                        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    }
                }.start();
            }
        });
    }
}
