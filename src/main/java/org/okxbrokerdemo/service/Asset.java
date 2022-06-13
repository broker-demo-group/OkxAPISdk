package org.okxbrokerdemo.service;

import com.google.gson.internal.LinkedTreeMap;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.Map;

public class Asset {
    String APIURL = "https://www.okx.com";
    static String GET = "GET";

    // 获取账号余额
    public Map getAccountBalance(APIKeyHolder apiKeyHolder) {
        APIRequestPayload param = () -> "{}";
        CommonAPICaller<APIRequestPayload, LinkedTreeMap> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);
        LinkedTreeMap r;
        try {
            r = commonAPICaller.requestAPI(GET, "/api/v5/account/balance", param, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return r;
    }

    // 获取账号持仓
    public Map getAccountPosition(APIKeyHolder apiKeyHolder) {
        APIRequestPayload param = () -> "{}";
        CommonAPICaller<APIRequestPayload, LinkedTreeMap> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);
        LinkedTreeMap r;
        try {
            r = commonAPICaller.requestAPI(GET, "/api/v5/account/positions", param, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return r;
    }
}
