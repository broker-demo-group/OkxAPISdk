package org.okxbrokerdemo.utils;

import java.util.HashMap;
import java.util.Map;

public class HeaderMapBuilder {
    /**
     * OK-ACCESS-KEY字符串类型的APIKey。
     *
     * OK-ACCESS-SIGN使用HMAC SHA256哈希函数获得哈希值，再使用Base-64编码（请参阅签名）。
     *
     * OK-ACCESS-TIMESTAMP发起请求的时间（UTC），如：2020-12-08T09:08:57.715Z
     *
     * OK-ACCESS-PASSPHRASE您在创建API密钥时指定的Passphrase。
     *
     *
     */
    public static Map<String,String> build(String accessKey,String sign,String timeStamp,String passPhrase,boolean isSimluate){
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("OK-ACCESS-KEY",accessKey);
        headerMap.put("OK-ACCESS-SIGN",sign);
        headerMap.put("OK-ACCESS-TIMESTAMP",timeStamp);
        headerMap.put("OK-ACCESS-PASSPHRASE",passPhrase);
        headerMap.put("Content-Type", "application/json");
        if(isSimluate){
            headerMap.put("x-simulated-trading","1");
        }

        return headerMap;
    }
    public static Map<String,String> build(String accessToken,boolean isSimluate){
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("Authorization","Bearer "+accessToken);
        if(isSimluate){
            headerMap.put("x-simulated-trading","1");
        }
        return headerMap;
    }
}
