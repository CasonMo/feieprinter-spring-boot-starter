package com.cason.feiePrint.utils;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/22
 * Time: 3:16
 */
public abstract class FeieUtils {
    public static String bindFieldToContentByMap(String content, Map<String,String> map){
        for (Map.Entry<String, String> entry :
                map.entrySet()) {
            content = content.
                    replaceAll("#" +
                            entry.getKey() + "#",
                            entry.getValue());
        }
        return content;
    }
}

