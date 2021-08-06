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
        PrintLabelMsgFeieReq feieReq = new PrintLabelMsgFeieReq();
        feieReq.setContent(<content>);
        feieReq.setUser(<user>);
        feieReq.setUKey(<ukey>);
        feieReq.setSn(<sn>);
        FeieResp feieResp=feiePrintService.printLabelMsg(feieReq);
        Assert.assertEquals(0, feieResp.getRet());
    }

    @Test
    public void queryPrinterStatus() throws Exception {
        QueryPrinterStatusFeieReq feieReq = new QueryPrinterStatusFeieReq();
        feieReq.setUser(<user>);
        feieReq.setUKey(<ukey>);
        feieReq.setSn(<sn>);
        FeieResp feieResp = feiePrintService.queryPrinterStatus(feieReq);
        Assert.assertEquals(0, feieResp.getRet());
    }
    
    @Test
    public void testBindFieldToContentByMap() {
            Map<String, String> map = new HashMap<>();
            map.put("ORDER_SEQ", "test");
            map.put("DISH_CURRENT", "test");
            map.put("DISH_TOTAL", "test");
            map.put("DELIVERY_ADDRESS", "test");
            map.put("DISH_NAME", "test");
            map.put("DISH_COUNT", "test");
            map.put("CUSTOMER_NAME", "test");
            map.put("CUSTOMER_PHONE", "test");
            String content = "<DIRECTION>1</DIRECTION><TEXT x=\"9\" y=\"10\" font=\"12\" w=\"1\" h=\"2\" r=\"0\">##ORDER_SEQ#                                            #DISH_CURRENT#/#DISH_TOTAL#</TEXT><TEXT x='9' y='45' font='9' w='2' h='2' r='0'>#DELIVERY_ADDRESS#</TEXT><TEXT x='80' y='80' font='12' w='2' h='2' r='0'>#DISH_NAME#  #DISH_COUNT#</TEXT><TEXT x='9' y='180' font='12' w='1' h='1' r='0'>#CUSTOMER_NAME#       #CUSTOMER_PHONE#</TEXT>";
            String contentWithBindData = FeieUtils.bindFieldToContentByMap(content, map);
            System.out.println(contentWithBindData);
    }
```