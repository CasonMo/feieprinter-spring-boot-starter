package com.cason.feiePrint.entity;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/22
 * Time: 1:31
 */

public class FeieReq {
    private String user;
    private long stime;
    private String apiname;
    private String sn;
    private String uKey;
    private String content;
    private int times;

    public long getStime() {
        return System.currentTimeMillis()/1000;
    }

    public FeieReq() {
    }

    public FeieReq(String user, long stime, String apiname, String sn, String uKey, String content, int times) {
        this.user = user;
        this.stime = stime;
        this.apiname = apiname;
        this.sn = sn;
        this.uKey = uKey;
        this.content = content;
        this.times = times;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setStime(long stime) {
        this.stime = stime;
    }

    public String getApiname() {
        return apiname;
    }

    public void setApiname(String apiname) {
        this.apiname = apiname;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUKey() {
        return uKey;
    }

    public void setUKey(String uKey) {
        this.uKey = uKey;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

}
