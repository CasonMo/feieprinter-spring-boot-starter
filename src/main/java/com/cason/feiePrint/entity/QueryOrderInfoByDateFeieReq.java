package com.cason.feiePrint.entity;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2021/8/6
 * Time: 14:37
 */
public class QueryOrderInfoByDateFeieReq extends FeieReq{
    //打印机编号
    private String sn;

    //	查询日期，格式YY-MM-DD，如：2016-09-20
    private String strdate;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getStrdate() {
        return strdate;
    }

    public void setStrdate(String strdate) {
        this.strdate = strdate;
    }
}
