package com.cason.feiePrint.entity;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2021/8/6
 * Time: 14:36
 */
public class QueryPrinterStatusFeieReq extends FeieReq{

    //打印机编号
    private String sn;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
