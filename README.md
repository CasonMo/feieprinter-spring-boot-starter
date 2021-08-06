# feieprinter-spring-boot-starter
官方文档
http://www.feieyun.com/open/index.html

因为公司开发需要，刚好自己又想捣鼓做一点简单的开源项目，所以就把飞鹅云的一些接口做成了依赖，只需要简单调用，即可操作飞鹅云打印机
在开发之前建议先阅读官方文档
了解以下概念
```
user	必须	string	飞鹅云后台注册用户名。
stime	必须	string	当前UNIX时间戳，10位，精确到秒。
sig	必须	string	对参数 user+UKEY+stime拼接后（+号表示连接符）进行SHA1加密得到签名，加密后签名值为40位小写字符串。
apiname	必须	string	请求的接口名称：Open_printLabelMsg
sn	必须	string	打印机编号
```

### 教程
引入包依赖
```xml
        <dependency>
            <groupId>com.cason</groupId>
            <artifactId>feieprinter-spring-boot-starter</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```

指定引用仓库
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