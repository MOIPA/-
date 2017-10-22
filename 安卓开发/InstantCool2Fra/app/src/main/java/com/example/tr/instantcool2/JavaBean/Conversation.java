package com.example.tr.instantcool2.JavaBean;

/**
 * Created by TR on 2017/10/17.
 */

public class Conversation {

    private int unreadCount=0;

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    private String targetaccount;

    private String targetname;

    public String getTargetaccount() {
        return targetaccount;
    }

    public void setTargetaccount(String targetaccount) {
        this.targetaccount = targetaccount;
    }

    public String getTargetname() {
        return targetname;
    }

    public void setTargetname(String targetname) {
        this.targetname = targetname;
    }
}
