package com.cason.feiePrint.service;


import com.cason.feiePrint.entity.FeieReq;
import com.cason.feiePrint.entity.FeieResp;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/22
 * Time: 0:13
 */
public interface FeiePrintService {
    FeieResp addPrinter(String snlist);
    FeieResp print(FeieReq feieReq);
    FeieResp printLabelMsg(FeieReq feieReq) throws Exception;

    FeieResp queryOrderState(FeieReq feieReq, String orderid) throws Exception;
    FeieResp queryOrderInfoByDate(FeieReq feieReq, String strdate) throws Exception;
    FeieResp queryPrinterStatus(FeieReq feieReq) throws Exception;
}
