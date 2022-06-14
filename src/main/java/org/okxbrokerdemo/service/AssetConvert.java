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
 * @date: 2022/6/13  4:56 PM
 **/
public class AssetConvert {
    String APIURL = "https://www.okx.com";
    public boolean isSimulate = true;
    APIKeyHolder apiKeyHolder;
    public AssetConvert(APIKeyHolder apiKeyHolder){
        this.apiKeyHolder = apiKeyHolder;
    }

    public JsonObject getConvertCurrencies(){
        return  getConvertCurrencies0();

    }

    public <T> T getConvertCurrencies(Class<T> clazz){
        JsonObject body = getConvertCurrencies0();
        JsonElement data = body.get("data").getAsJsonArray().get(0);
        return  new Gson().fromJson(data,clazz);
    }
    // 获取闪兑币种列表
    public JsonObject getConvertCurrencies0() {
        APIRequestPayload e = () -> "{}";
        CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);
        JsonObject r;
        try {
            r = commonAPICaller.requestAPI("GET", "/api/v5/asset/currencies", e, true,JsonObject.class);
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return r;
    }


    public JsonObject getConvertCurrencyPair(APIRequestPayload param){
        return  getConvertCurrencyPair0(param);

    }

    public <T> T getConvertCurrencyPair(APIRequestPayload param,Class<T> clazz){
        JsonObject body = getConvertCurrencyPair0(param);
        JsonElement data = body.get("data").getAsJsonArray().get(0);
        return  new Gson().fromJson(data,clazz);
    }

    //获取闪兑币对信息
    public JsonObject getConvertCurrencyPair0( APIRequestPayload param) {
        CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);
        JsonObject r;

        try {
            r = commonAPICaller.requestAPI("GET",
                    "/api/v5/asset/convert/currency-pair", param, isSimulate,JsonObject.class);
        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return r;
    }
    public JsonObject convertEstimateQuote(APIRequestPayload param){
        return  convertEstimateQuote0(param);

    }

    public <T> T convertEstimateQuote(APIRequestPayload param,Class<T> clazz){
        JsonObject body = convertEstimateQuote0(param);
        JsonElement data = body.get("data").getAsJsonArray().get(0);
        return  new Gson().fromJson(data,clazz);
    }

    //闪兑预估询价
    private  JsonObject convertEstimateQuote0(APIRequestPayload param) {
        CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);

        JsonObject r;

        try {
            r = commonAPICaller.requestAPI("POST",
                    "/api/v5/asset/convert/estimate-quote", param, isSimulate,JsonObject.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return r;
    }


    public JsonObject convertTrade(APIRequestPayload param){
        return  convertTrade0(param);

    }

    public <T> T convertTrade(APIRequestPayload param,Class<T> clazz){
        JsonObject body = this.convertTrade0(param);
        JsonElement data = body.get("data").getAsJsonArray().get(0);
        return  new Gson().fromJson(data,clazz);
    }

    public JsonObject convertTrade0(APIRequestPayload param){
        CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);

        JsonObject r;

        try {
            r = commonAPICaller.requestAPI("POST",
                    "/api/v5/asset/convert/trade", param, isSimulate,JsonObject.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return r;
    }

    public JsonObject convertHistory(APIRequestPayload param){
        return  this.convertHistory0(param);

    }

    public <T> T convertHistory(APIRequestPayload param,Class<T> clazz){
        JsonObject body = this.convertHistory0(param);
        JsonElement data = body.get("data").getAsJsonArray().get(0);
        return  new Gson().fromJson(data,clazz);
    }

    public JsonObject convertHistory0(APIRequestPayload param){
        CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller = new CommonAPICaller<>(APIURL, apiKeyHolder);

        JsonObject r;

        try {
            r = commonAPICaller.requestAPI("GET",
                    "/api/v5/asset/convert/history", param, isSimulate,JsonObject.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return r;


    }
    public void setSimulate(boolean simulate) {
        isSimulate = simulate;
    }



}
