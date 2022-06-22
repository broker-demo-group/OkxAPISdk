package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.okxbrokerdemo.service.entry.ParamMap;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  4:55 PM
 **/
public class Asset {

    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public Asset(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }

    public <T> List<T> getCurrencies(Class<T> clazz) {
        return commonAPICaller.listExecute(() -> "{}", "GET", "/api/v5/asset/currencies", clazz);
    }

    /**
     * 获取余额
     */


    public <T> List<T> getAssetBalance(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/asset/balances", clazz);
    }

    /**
     * 获取账号持仓
     */
    public <T> T getAccountPosition(Class<T> clazz) {
        return commonAPICaller.execute(() -> "{}", "GET", "/api/v5/account/positions", clazz);
    }

    public <T> T getAssetValuation(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/asset/asset-valuation", clazz);
    }

    public <T> T getAssetValuation(Class<T> clazz) {
        ParamMap param = new ParamMap();
        param.add("ccy", "BTC");
        return commonAPICaller.execute(param, "GET", "/api/v5/asset/asset-valuation", clazz);
    }

    public <T> T assetTransfer(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/asset/transfer", clazz);
    }

    public <T> T getAssetTransferState(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/asset/transfer-state", clazz);
    }

    public <T> List<T> getAssetBills(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/asset/bills", clazz);
    }


}
