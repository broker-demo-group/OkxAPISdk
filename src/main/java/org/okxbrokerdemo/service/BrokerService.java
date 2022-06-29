package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;

import java.util.List;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/29  3:34 PM
 **/
public class BrokerService {
    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public BrokerService(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }

    public <T> T getInfo(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/broker/nd/info", clazz);
    }

    public <T> T createSubAccount(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/create-subaccount", clazz);
    }

    public <T> T deleteSubAccount(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/delete-subaccount", clazz);
    }

    public <T> T createSubAccountApiKey(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/subaccount/apikey", clazz);
    }

    public <T> T getSubAccountApiKey(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/broker/nd/subaccount/apikey", clazz);
    }

    public <T> T updateSubAccountApiKey(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/subaccount/modify-apikey", clazz);
    }

    public <T> T deleteSubAccountApiKey(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/subaccount/delete-apikey", clazz);
    }

    public <T> T setSubAccountLevel(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/set-subaccount-level", clazz);
    }

    public <T> T setSubAccountFeeRate(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/set-subaccount-fee-rate", clazz);
    }

    public <T> T createSubAccountDepositAddress(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/asset/broker/nd/subaccount-deposit-address", clazz);
    }

    public <T> T updateSubAccountDepositAddress(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/asset/broker/nd/modify-subaccount-deposit-address",
                clazz);
    }

    public <T> T getSubAccountDepositAddress(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/asset/broker/nd/subaccount-deposit-address",
                clazz);
    }

    public <T> T getSubAccountDepositHistory(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/asset/broker/nd/subaccount-deposit-history",
                clazz);
    }

    public <T> List<T> getRebateDaily(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/broker/nd/rebate-daily",
                clazz);
    }



}
