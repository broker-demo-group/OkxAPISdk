package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.okxbrokerdemo.constant.ApiEnum;
import org.okxbrokerdemo.handler.OkApiHandler;
import org.okxbrokerdemo.handler.Request;
import org.okxbrokerdemo.handler.subaccount.SetTransOutReq;
import org.okxbrokerdemo.handler.subaccount.SetTransOutRes;
import org.okxbrokerdemo.utils.APIKeyHolder;
import java.util.List;

public class SubAccount {

    private String baseURL = "https://www.okx.com";

    public SubAccount() {
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    private CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public CommonAPICaller<APIRequestPayload, JsonObject> getCommonAPICaller() {
        return commonAPICaller;
    }

    public void setCommonAPICaller(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }

    public <T> List<T> getSubAccountList(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/users/subaccount/list", clazz);
        return result;
    }

    public <T> T getSubAccountFundingBalance(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "GET", "/api/v5/account/subaccount/balances", clazz);
        return result;
    }

    public <T> T getSubAccountAssetBalance(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "GET", "/api/v5/asset/subaccount/balances", clazz);
        return result;
    }

    public <T> List<T> getSubAccountBills(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/asset/subaccount/bills", clazz);
        return result;
    }

    public <T> T subAccountTransfer(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/asset/subaccount/transfer", clazz);
        return result;
    }

    public <T> T setTransferOut(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/users/subaccount/set-transfer-out", clazz);
        return result;
    }

    public List<SetTransOutRes> setTransferOut(SetTransOutReq req, APIKeyHolder apiKeyHolder) {
        Request request = OkApiHandler.generateRequest(req, ApiEnum.SET_PERMISSION_OF_TRANSFER_OUT);
        return (List<SetTransOutRes>) OkApiHandler.handle(request, apiKeyHolder);
    }

    public <T> List<T> getEntrustSubaccountList(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/users/entrust-subaccount-list", clazz);
        return result;
    }

}
