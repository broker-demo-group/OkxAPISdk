package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BulkTrade {

    private String baseURL = "https://www.okx.com";

    public BulkTrade() {
    }

    private CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public CommonAPICaller<APIRequestPayload, JsonObject> getCommonAPICaller() {
        return commonAPICaller;
    }

    public void setCommonAPICaller(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }


    public <T> List<T> counterParties(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/rfq/counterparties", clazz);
        return result;
    }

    public <T> T createRfq(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/rfq/create-rfq", clazz);
        return result;
    }

    public <T> T cancelRfq(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/rfq/cancel-rfq", clazz);
        return result;
    }

    public <T> List<T> cancelBatchRfq(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "POST", "/api/v5/rfq/cancel-batch-rfqs", clazz);
        return result;
    }

    public <T> List<T> cancelAllRfq(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "POST", "/api/v5/rfq/cancel-all-rfqs", clazz);
        return result;
    }

    public <T> T executeQuote(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/rfq/execute-quote", clazz);
        return result;
    }

    public <T> T createQuote(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/rfq/create-quote", clazz);
        return result;
    }

    public <T> T cancelQuote(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/rfq/cancel-quote", clazz);
        return result;
    }

    public <T> List<T> cancelBatchQuote(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "POST", "/api/v5/rfq/cancel-batch-quotes", clazz);
        return result;
    }

    public <T> List<T> cancelAllQuote(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "POST", "/api/v5/rfq/cancel-all-quotes", clazz);
        return result;
    }

    public <T> List<T> getRfqs(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/rfq/rfqs", clazz);
        return result;
    }

    public <T> List<T> getQuotes(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/rfq/quotes", clazz);
        return result;
    }

    public <T> List<T> getTrades(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/rfq/trades", clazz);
        return result;
    }

    public <T> List<T> getPublicTrades(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/rfq/public-trades", clazz);
        return result;
    }


}
