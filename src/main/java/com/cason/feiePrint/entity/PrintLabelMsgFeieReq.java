package com.cason.feiePrint.entity;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2021/8/6
 * Time: 14:31
 */
public class PrintLabelMsgFeieReq extends FeieReq{
    //打印内容,不能超过5000字节
    private String content;
    //打印次数，默认为1。
    private int times;
    //打印机编号
    private String sn;

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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
