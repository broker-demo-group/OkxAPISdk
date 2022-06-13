package org.okxbrokerdemo.service;

import com.google.gson.internal.LinkedTreeMap;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.Map;

public class AssetConvert {
    String APIURL = "https://www.okx.com";

    // 获取闪兑币种列表
    public Map getConvertCurrencies(APIKeyHolder apiKeyHolder) {
        APIRequestPayload e = () -> "{}";
        CommonAPICaller<APIRequestPayload, LinkedTreeMap> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);
        LinkedTreeMap r;
        try {
            r = commonAPICaller.requestAPI("GET", "/api/v5/asset/currencies", e, true);
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return r;
    }

    //获取闪兑币对信息
    public Map getConvertCurrencyPair(APIKeyHolder apiKeyHolder, APIRequestPayload param) {
        CommonAPICaller<APIRequestPayload, LinkedTreeMap> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);
        LinkedTreeMap r;

        try {
            r = commonAPICaller.requestAPI("GET",
                    "/api/v5/asset/convert/currency-pair", param, true);
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return r;
    }

    //闪兑预估询价
    public Map convertEstimateQuote(APIKeyHolder apiKeyHolder, APIRequestPayload param) {
        CommonAPICaller<APIRequestPayload, LinkedTreeMap> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);

        LinkedTreeMap<String, String> r;

        try {
            r = commonAPICaller.requestAPI("POST",
                    "/api/v5/asset/convert/estimate-quote", param, true);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        //TODO LinkedTreeMap<String,String> 存储了Entry<String,ArrayList>
//        for (Map.Entry e : r.entrySet()) {
//            System.out.println(e.getKey().getClass());
//            System.out.println(e.getValue().getClass());
//        }
        return r;
    }
}
