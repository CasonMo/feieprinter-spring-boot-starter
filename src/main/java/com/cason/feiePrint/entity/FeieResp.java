package com.cason.feiePrint.entity;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/22
 * Time: 0:05
 */

public class FeieResp {
    private String msg;

    private int ret;

    private String data;

    private int serverExecutedTime;

    public FeieResp() {
    }

    public FeieResp(String msg, int ret, String data, int serverExecutedTime) {
        this.msg = msg;
        this.ret = ret;
        this.data = data;
        this.serverExecutedTime = serverExecutedTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getServerExecutedTime() {
        return serverExecutedTime;
    }

    public void setServerExecutedTime(int serverExecutedTime) {
        this.serverExecutedTime = serverExecutedTime;
    }
}
