package com.cason.feiePrint.entity;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2021/8/6
 * Time: 14:39
 */
public class QueryOrderStateFeieReq extends FeieReq{
    //必须	string	订单ID，由接口Open_printMsg返回。
    private String orderid;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
}
