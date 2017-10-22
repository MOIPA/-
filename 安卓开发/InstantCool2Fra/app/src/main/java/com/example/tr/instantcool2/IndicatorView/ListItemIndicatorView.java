package com.example.tr.instantcool2.IndicatorView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tr.instantcool2.R;

/**
 * Created by TR on 2017/10/22.
 */

public class ListItemIndicatorView extends RelativeLayout {

    private ImageView iv_userImage;
    private TextView iv_unreadCount;
    private TextView tv_name;
    private TextView tv_account;

    public ListItemIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.indicator_item_chat_fragment,this);
        iv_unreadCount = (TextView) view.findViewById(R.id.iv_unread_count);
        iv_userImage = (ImageView) view.findViewById(R.id.iv_user_image);
        tv_account = (TextView) view.findViewById(R.id.tv_user_account);
        tv_name = (TextView) view.findViewById(R.id.tv_user_name);
    }

    public void setIv_userImage(int resourceID){
        iv_userImage.setImageResource(resourceID);
    }

    public void setIv_unreadCount(int count){
        if(count<=0){
            iv_unreadCount.setVisibility(View.GONE);
        }else if(count<=99){
            iv_unreadCount.setText(count+"");
        }else if(count>=100){
            iv_unreadCount.setText("99+");
        }
    }

    public void setTv_name(String name){
        tv_name.setText(name);
    }

    public void setTv_account(String account){
        tv_account.setText(account);
    }


}
