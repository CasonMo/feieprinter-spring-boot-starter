package com.cason.feiePrint.service.impl;


import com.alibaba.fastjson.JSON;
import com.cason.feiePrint.entity.FeieReq;
import com.cason.feiePrint.entity.FeieResp;
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
    public FeieResp addPrinter(String snlist) {
        return null;
    }

    @Override
    public FeieResp print(FeieReq feieReq) {
        return null;
    }

    @Override
    public FeieResp printLabelMsg(FeieReq feieReq) throws Exception {
        feieReq.setApiname("Open_printLabelMsg");
        if(feieReq.getTimes()==0){
            feieReq.setTimes(1);
        }
        return getPost(feieReq);
    }

    @Override
    public FeieResp queryOrderState(FeieReq feieReq,String orderid) throws Exception {
        feieReq.setApiname("Open_queryOrderState");
        LinkedMultiValueMap<String, String> exMap = new LinkedMultiValueMap<>();
        exMap.add("orderid",orderid);
        return getPost(feieReq,exMap);
    }

    @Override
    public FeieResp queryOrderInfoByDate(FeieReq feieReq, String strdate) throws Exception {
        feieReq.setApiname("Open_queryOrderInfoByDate");
        LinkedMultiValueMap<String, String> exMap = new LinkedMultiValueMap<>();
        exMap.add("date",strdate);
        return getPost(feieReq,exMap);
    }

    @Override
    public FeieResp queryPrinterStatus(FeieReq feieReq) throws Exception {
        feieReq.setApiname("Open_queryPrinterStatus");
        return getPost(feieReq);
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
        if(!StringUtils.isEmpty(feieReq.getSn())){
            map.add("sn",feieReq.getSn());
        }
        if(!StringUtils.isEmpty(feieReq.getContent())) {
            map.add("content", feieReq.getContent());
        }
        if(feieReq.getTimes()!=0) {
            map.add("times", String.valueOf(feieReq.getTimes()));//打印联数
        }
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
        if(!StringUtils.isEmpty(feieReq.getSn())){
            map.add("sn",feieReq.getSn());
        }
        if(!StringUtils.isEmpty(feieReq.getContent())) {
            map.add("content", feieReq.getContent());
        }
        if(feieReq.getTimes()!=0) {
            map.add("times", String.valueOf(feieReq.getTimes()));//打印联数
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<JSONObject> requestEntity = new HttpEntity(map,headers);
        //发送请求
        ResponseEntity<String> forEntity = restTemplate.postForEntity(URL,requestEntity,String.class);
        return JSON.parseObject(forEntity.getBody(),FeieResp.class);
    }


}
