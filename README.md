# feieprinter-spring-boot-starter

注入FeiePrintService
```java
    @Autowired
    FeiePrintService feiePrintService;
```
调用方法
```java

    @Test
    public void printLabelMsg() throws Exception {
        FeieReq feieReq = new FeieReq();
        feieReq.setContent(<content>);
        feieReq.setUser(<user>);
        feieReq.setUKey(<ukey>);
        feieReq.setSn(<sn>);
        FeieResp feieResp=feiePrintService.printLabelMsg(feieReq);
        Assert.assertEquals(0, feieResp.getRet());
    }

    @Test
    public void queryPrinterStatus() throws Exception {
        FeieReq feieReq = new FeieReq();
        feieReq.setUser(<user>);
        feieReq.setUKey(<ukey>);
        feieReq.setSn(<sn>);
        FeieResp feieResp = feiePrintService.queryPrinterStatus(feieReq);
        Assert.assertEquals(0, feieResp.getRet());
    }
```