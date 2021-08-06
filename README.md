# feieprinter-spring-boot-starter
引入包依赖
```xml
        <dependency>
            <groupId>com.cason</groupId>
            <artifactId>feieprinter-spring-boot-starter</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
   
```
引用仓库
```xml

    <repositories>
        <repository>
            <id>mvn-repo</id>
            <url>https://raw.github.com/CasonMo/mvn-repo/master</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>
```
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