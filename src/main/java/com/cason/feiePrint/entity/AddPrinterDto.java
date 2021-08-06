package com.cason.feiePrint.entity;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2021/8/6
 * Time: 14:49
 */
public class AddPrinterDto {

    //打印机编号SN(必填)
    private String sn;
    //打印机识别码KEY(必填)
    private String key;
    //备注(选填)
    private String remark;
    //流量卡号码(选填)
    private String flowCardNumber;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFlowCardNumber() {
        return flowCardNumber;
    }

    public void setFlowCardNumber(String flowCardNumber) {
        this.flowCardNumber = flowCardNumber;
    }
}
