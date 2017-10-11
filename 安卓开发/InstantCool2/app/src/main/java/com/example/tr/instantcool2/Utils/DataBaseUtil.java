package com.example.tr.instantcool2.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.tr.instantcool2.JavaBean.MyAccount;
import com.example.tr.instantcool2.LocalDB.StorageOfUserInfo;

/**
 * Created by TR on 2017/10/11.
 */

public class DataBaseUtil {

    private static StorageOfUserInfo dbmanger;

    public static boolean CreateAccount(Context context, MyAccount account){
        dbmanger = new StorageOfUserInfo(context);
        SQLiteDatabase database = dbmanger.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("accountname",account.getAccountName());
        values.put("accountpwd",account.getAccountPwd());
        values.put("name",account.getName());
        long insert = database.insert("UserAccount",null,values);
        if(insert>0){
            return true;
        }
        return false;
    }

    public static void DeleteAllAccounts(Context context){
        dbmanger = new StorageOfUserInfo(context);
        SQLiteDatabase database = dbmanger.getWritableDatabase();
        database.delete("UserAccount",null,null);
    }
    public static void UpdataAccount(Context context,String where,String content){
        dbmanger = new StorageOfUserInfo(context);
        SQLiteDatabase database = dbmanger.getWritableDatabase();

    }

}
