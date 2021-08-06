package com.cason.feiePrint.service.impl;


import com.alibaba.fastjson.JSON;
import com.cason.feiePrint.entity.*;
import com.cason.feiePrint.service.FeiePrintService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/22
 * Time: 0:03
 */
@Service
public class FeiePrintServiceImpl implements FeiePrintService {

    @Autowired
    RestTemplate restTemplate;

    public static final String URL = "http://api.feieyun.cn/Api/Open/";//不需要修改

    @Override
    public FeieResp addPrinter(PrinterAddListFeieReq feieReq) throws Exception {
        if (feieReq == null) {
            throw new Exception("PrinterAddListFeieReq不能为空");
        }
        List<AddPrinterDto> addPrinterDtoList = feieReq.getAddPrinterDtoList();

        if (addPrinterDtoList.isEmpty()) {
            throw new Exception("addPrinterDtoList不能为空");
        }
        feieReq.setApiname("Open_printerAddlist");
        StringBuffer printerContentStringBuffer = new StringBuffer();
        //打印机编号SN(必填) # 打印机识别码KEY(必填) # 备注名称(选填) # 流量卡号码(选填)，多台打印机请换行（\n）添加新打印机信息，
        //316500010 # abcdefgh # 快餐前台 # 13688889999
        Iterator<AddPrinterDto> iterator = addPrinterDtoList.iterator();
        while (iterator.hasNext()) {
            AddPrinterDto item = iterator.next();
            printerContentStringBuffer.append(item.getSn()).append(" # ");
            printerContentStringBuffer.append(item.getKey()).append(" # ");
            printerContentStringBuffer.append(StringUtils.isEmpty(item.getRemark())?"":item.getRemark()).append(" # ");
            printerContentStringBuffer.append(StringUtils.isEmpty(item.getFlowCardNumber())?"":item.getFlowCardNumber()).append(iterator.hasNext()?" \n ":"");
        }
        LinkedMultiValueMap<String, String> exMap = new LinkedMultiValueMap<>();
        exMap.add("printerContent",printerContentStringBuffer.toString());
        return getPost(feieReq,exMap);
    }

    @Override
    public FeieResp printMsg(PrintMsgFeieReq feieReq) throws Exception {
        feieReq.setApiname("Open_printMsg");
        LinkedMultiValueMap<String, String> exMap = new LinkedMultiValueMap<>();
        exMap.add("sn",feieReq.getSn());
        exMap.add("content", feieReq.getContent());
        if(feieReq.getTimes()!=0) {
            exMap.add("times", String.valueOf(feieReq.getTimes()));//打印联数
        }
        return getPost(feieReq,exMap);
    }

    @Override
    public FeieResp printLabelMsg(PrintLabelMsgFeieReq feieReq) throws Exception {
        feieReq.setApiname("Open_printLabelMsg");
        LinkedMultiValueMap<String, String> exMap = new LinkedMultiValueMap<>();
        exMap.add("sn",feieReq.getSn());
        exMap.add("content", feieReq.getContent());
        if(feieReq.getTimes()!=0) {
            exMap.add("times", String.valueOf(feieReq.getTimes()));//打印联数
        }
        return getPost(feieReq,exMap);
    }

    @Override
    public FeieResp queryOrderState(QueryOrderStateFeieReq feieReq) throws Exception {
        feieReq.setApiname("Open_queryOrderState");
        LinkedMultiValueMap<String, String> exMap = new LinkedMultiValueMap<>();
        exMap.add("orderid",feieReq.getOrderid());
        return getPost(feieReq,exMap);
    }

    @Override
    public FeieResp queryOrderInfoByDate(QueryOrderInfoByDateFeieReq feieReq) throws Exception {
        feieReq.setApiname("Open_queryOrderInfoByDate");
        LinkedMultiValueMap<String, String> exMap = new LinkedMultiValueMap<>();
        exMap.add("date", feieReq.getStrdate());
        exMap.add("sn",feieReq.getSn());
        return getPost(feieReq,exMap);
    }

    @Override
    public FeieResp queryPrinterStatus(QueryPrinterStatusFeieReq feieReq) throws Exception {
        feieReq.setApiname("Open_queryPrinterStatus");
        LinkedMultiValueMap<String, String> exMap = new LinkedMultiValueMap<>();
        exMap.add("sn",feieReq.getSn());
        return getPost(feieReq,exMap);
    }

    /**
     * 发送post 请求
     * @param feieReq
     * @return
     */
    private FeieResp getPost(FeieReq feieReq,MultiValueMap<String, String> exMap) throws Exception {

        MultiValueMap<String, String>  map = new LinkedMultiValueMap<String, String>();
        String sTime = String.valueOf(feieReq.getStime());
        if(StringUtils.isEmpty(feieReq.getUser())) {
            throw new Exception("配置user不能为空");
        }
        if(StringUtils.isEmpty(feieReq.getUKey())) {
            throw new Exception("配置ukey不能为空");
        }
        map.add("user", feieReq.getUser());
        map.add("stime",sTime);
        map.add("sig",DigestUtils.sha1Hex(feieReq.getUser()+feieReq.getUKey()+sTime));
        map.add("apiname",feieReq.getApiname());//固定值,不需要修改

        if(exMap!=null){
            map.putAll(exMap);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<JSONObject> requestEntity = new HttpEntity(map,headers);
        //发送请求
        ResponseEntity<String> forEntity = restTemplate.postForEntity(URL,requestEntity,String.class);
        return JSON.parseObject(forEntity.getBody(),FeieResp.class);
    }
    /**
     * 发送post 请求
     * @param feieReq
     * @return
     */
    private FeieResp getPost(FeieReq feieReq) throws Exception {
        if(StringUtils.isEmpty(feieReq.getUser())) {
            throw new Exception("配置user不能为空");
        }
        if(StringUtils.isEmpty(feieReq.getUKey())) {
            throw new Exception("配置ukey不能为空");
        }
        MultiValueMap<String, String>  map = new LinkedMultiValueMap<String, String>();

        String sTime = String.valueOf(feieReq.getStime());

        map.add("user",feieReq.getUser());
        map.add("stime",sTime);
        map.add("sig",DigestUtils.sha1Hex(feieReq.getUser()+feieReq.getUKey()+sTime));
        map.add("apiname",feieReq.getApiname());//固定值,不需要修改

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<JSONObject> requestEntity = new HttpEntity(map,headers);
        //发送请求
        ResponseEntity<String> forEntity = restTemplate.postForEntity(URL,requestEntity,String.class);
        return JSON.parseObject(forEntity.getBody(),FeieResp.class);
    }


}
