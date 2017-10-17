package com.example.tr.instantcool2.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class StoreDataService extends Service {

    private String accountName;
    private String name;
    private String accountPwd;

    public StoreDataService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        MyBinder binder = new MyBinder();
        return binder;
    }

    private class MyBinder extends Binder implements InterfaceStoreData{

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getAccountPwd() {
            return accountPwd;
        }

        @Override
        public String getAccountName() {
            return accountName;
        }

        @Override
        public void setName(String named) {
            name=named;
        }

        @Override
        public void setAccountname(String accountNamed) {
            accountName=accountNamed;
        }

        @Override
        public void setAccountpwd(String pwdd) {
            accountPwd = pwdd;
        }
    }

}
