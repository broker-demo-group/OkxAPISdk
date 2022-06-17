package org.okxbrokerdemo.service;

import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.Map;

public class Status {
    private String baseURL = "https://www.okx.com";
    private APIKeyHolder apiKeyHolder;
    public Map<String,Object> getStatus(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/system/status",apiRequestPayload,isSimluate);
        return  result;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }
}