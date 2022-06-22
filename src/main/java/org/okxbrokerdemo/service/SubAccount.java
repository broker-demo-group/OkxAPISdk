package org.okxbrokerdemo.service;

import org.okxbrokerdemo.service.entry.APIRequestPayload;
import org.okxbrokerdemo.APIKeyHolder;

import java.io.IOException;
import java.util.Map;

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

    public Map<String,Object> getSubAccountList(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/users/subaccount/list",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getSubAccountBalance(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/subaccount/balances",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getSubAccountBills(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/asset/subaccount/bills",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> subAccountTransfer(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/asset/subaccount/transfer",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> setTransferOut(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/users/subaccount/set-transfer-out",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getEntrustSubaccountList(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/users/entrust-subaccount-list",apiRequestPayload,isSimluate);
        return  result;
    }

}
