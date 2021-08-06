package com.cason.feiePrint.service;


import com.cason.feiePrint.entity.*;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/22
 * Time: 0:13
 */
public interface FeiePrintService {

    FeieResp addPrinter(PrinterAddListFeieReq feieReq) throws Exception;

    FeieResp printMsg(PrintMsgFeieReq feieReq) throws Exception;

    FeieResp printLabelMsg(PrintLabelMsgFeieReq feieReq) throws Exception;

    FeieResp queryOrderState(QueryOrderStateFeieReq feieReq) throws Exception;

    FeieResp queryOrderInfoByDate(QueryOrderInfoByDateFeieReq feieReq) throws Exception;

    FeieResp queryPrinterStatus(QueryPrinterStatusFeieReq feieReq) throws Exception;
}
