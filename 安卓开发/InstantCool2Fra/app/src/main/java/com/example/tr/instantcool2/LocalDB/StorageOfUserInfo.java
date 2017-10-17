package com.example.tr.instantcool2.LocalDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TR on 2017/10/11.
 */

public class StorageOfUserInfo extends SQLiteOpenHelper {

    public StorageOfUserInfo(Context context) {
        super(context, "UserAccount", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create UserAccount(accountname varchar(20),name varchar(20),accountpassword varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
