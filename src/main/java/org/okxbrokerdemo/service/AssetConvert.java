package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.okxbrokerdemo.service.entry.ParamMap;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  4:56 PM
 **/
public class AssetConvert {
    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public AssetConvert(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }

    // 获取闪兑币种列表
    public <T> List<T> getConvertCurrencies(APIRequestPayload param, Class<T> clazz) {
        ParamMap paramMap = new ParamMap();
        return commonAPICaller.listExecute(paramMap, "GET", "/api/v5/asset/convert/currencies", clazz);
    }

    public <T> T getConvertCurrencyPair(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/asset/convert/currency-pair", clazz);
    }

    //闪兑预估询价
    public <T> T convertEstimateQuote(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/asset/convert/estimate-quote", clazz);
    }


    public <T> T convertTrade(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/asset/convert/trade", clazz);
    }

    public <T> List<T> convertHistory(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/asset/convert/history", clazz);
    }


}
