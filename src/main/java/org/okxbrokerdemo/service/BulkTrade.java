package org.okxbrokerdemo.service;

import org.okxbrokerdemo.service.entry.APIRequestPayload;
import org.okxbrokerdemo.APIKeyHolder;

import java.io.IOException;
import java.util.Map;

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

    public Map<String,Object> counterParties(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rfq/counterparties",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> createRfq(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/rfq/create-rfq",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> cancelRfq(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/rfq/cancel-rfq",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> cancelBatchRfq(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/rfq/cancel-batch-rfqs",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> cancelAllRfq(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/rfq/cancel-all-rfqs",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> executeQuote(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/rfq/execute-quote",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> createQuote(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/rfq/create-quote",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> cancelQuote(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/rfq/cancel-quote",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> cancelBatchQuote(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/rfq/cancel-batch-quotes",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> cancelAllQuote(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/rfq/cancel-all-quotes",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getRfqs(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rfq/rfqs",apiRequestPayload,isSimluate);
        return  result;
    }
    public Map<String,Object> getQuotes(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rfq/quotes",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getTrades(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rfq/trades",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getPublicTrades(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rfq/public-trades",apiRequestPayload,isSimluate);
        return  result;
    }
}
