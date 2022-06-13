package org.okxbrokerdemo;


import org.okxbrokerdemo.service.Trade;
import org.okxbrokerdemo.utils.APIKeyHolder;

public class Client {

    APIKeyHolder apiKeyHolder;
    Trade trade;
    public Client(){

    }

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }
}
