package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.Map;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  4:55 PM
 **/
public class Asset {
    String APIURL = "https://www.okx.com";
    static String GET = "GET";
    static String POST = "POST";
    public boolean isSimulate = true;
    APIKeyHolder apiKeyHolder;
    public Asset(APIKeyHolder apiKeyHolder){
        this.apiKeyHolder = apiKeyHolder;
    }

    /**
     *
     * 获取账号余额
     */
    public JsonObject getAccountBalance(){
        return  getAccountBalance0();

    }

    public <T> T getAccountBalance(Class<T> clazz){
        JsonObject body = getAccountBalance0();
        JsonElement data = body.get("data").getAsJsonArray().get(0);
        return  new Gson().fromJson(data,clazz);
    }

    public JsonObject getAccountBalance0() {
        APIRequestPayload param = () -> "{}";
        CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);
        JsonObject r;
        try {
            r = commonAPICaller.requestAPI(GET, "/api/v5/account/balance", param, isSimulate,JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return r;
    }

    public JsonObject getAccountPosition(){
        return  getAccountPosition0();

    }

    public <T> T getAccountPosition(Class<T> clazz){
        JsonObject body = getAccountPosition0();
        JsonElement data = body.get("data").getAsJsonArray().get(0);
        return  new Gson().fromJson(data,clazz);
    }
    /**
     *  获取账号持仓
     */
    public JsonObject getAccountPosition0() {
        APIRequestPayload param = () -> "{}";
        CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);
        JsonObject r;
        try {
            r = commonAPICaller.requestAPI(GET, "/api/v5/account/positions", param, isSimulate,JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return r;
    }

    public void setSimulate(boolean simulate) {
        isSimulate = simulate;
    }
}
