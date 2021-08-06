package com.cason.feiePrint.entity;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/22
 * Time: 1:31
 */

public class FeieReq {
    //飞鹅云后台注册用户名。
    private String user;
    //当前UNIX时间戳，10位，精确到秒
    private long stime;
//    //对参数 user+UKEY+stime拼接后（+号表示连接符）进行SHA1加密得到签名，加密后签名值为40位小写字符串。
//    private String sig;
    //请求的接口名称
    private String apiname;
    //debug=1返回非json格式的数据。仅测试时候使用。
    private String debug;

    private String uKey;


    public long getStime() {
        return System.currentTimeMillis()/1000;
    }

    public FeieReq() {
    }

    public FeieReq(String user, long stime, String apiname, String sn, String uKey, String content, int times) {
        this.user = user;
        this.stime = stime;
        this.apiname = apiname;
        this.uKey = uKey;
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


    public String getUKey() {
        return uKey;
    }

    public void setUKey(String uKey) {
        this.uKey = uKey;
    }

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }
}
