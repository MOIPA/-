package com.example.tr.instantcool2.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by TR on 2017/10/11.
 */

public class ShowInfoUtil {
    //系统的太丑 以后修改
    public static void showInfo(Context context,String content){
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
