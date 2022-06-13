package org.okxbrokerdemo.service;

import org.okxbrokerdemo.utils.APIKeyHolder;

public class BulkTrade {
    private APIKeyHolder apiKeyHolder;
    private String baseURL = "https://www.okx.com";
    public BulkTrade(){}

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }


}
