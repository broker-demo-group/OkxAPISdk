package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Status {
    private String baseURL = "https://www.okx.com";
    private APIKeyHolder apiKeyHolder;

    private CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;
    public <T> List<T> getStatus(APIRequestPayload apiRequestPayload,Class<T> clazz)  {
        //CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/system/status",clazz);
        return  result;
    }

    public CommonAPICaller<APIRequestPayload, JsonObject> getCommonAPICaller() {
        return commonAPICaller;
    }

    public void setCommonAPICaller(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
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
