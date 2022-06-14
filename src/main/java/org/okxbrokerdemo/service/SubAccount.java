package org.okxbrokerdemo.service;

import org.okxbrokerdemo.utils.APIKeyHolder;

public class SubAccount {
    private APIKeyHolder apiKeyHolder;
    private String baseURL = "https://www.okx.com";

    public SubAccount(){}

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}
