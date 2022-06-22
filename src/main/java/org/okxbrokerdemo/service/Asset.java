package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.okxbrokerdemo.service.entry.APIRequestPayload;
import org.okxbrokerdemo.service.entry.ParamMap;
import org.okxbrokerdemo.APIKeyHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  4:55 PM
 **/
public class Asset {
    String APIUrl = "https://www.okx.com";

    public boolean isSimulate = true;
    APIKeyHolder apiKeyHolder;
    CommonAPICaller<APIRequestPayload,JsonObject> commonAPICaller;
    public Asset(APIKeyHolder apiKeyHolder){
        this.apiKeyHolder = apiKeyHolder;
        commonAPICaller = new CommonAPICaller<>(APIUrl,this.apiKeyHolder );
    }

    public <T> List<T> getCurrencies(Class<T> clazz) {
        return listExecute(() -> "{}", "GET", "/api/v5/asset/currencies", clazz);
    }


    public <T> List<T> getAssetBalance(APIRequestPayload param, Class<T> clazz) {
        return listExecute(param, "GET", "/api/v5/asset/balances", clazz);
    }
    /**
     *  获取账号持仓
     */
    public <T> T getAccountPosition(Class<T> clazz){
        return execute(()->"{}","GET","/api/v5/account/positions",clazz);
    }
    public <T> T getAssetValuation(APIRequestPayload param,Class<T> clazz){
        return execute(param,"GET","/api/v5/asset/asset-valuation",clazz);
    }

    public <T> T getAssetValuation(Class<T> clazz){
        ParamMap param = new ParamMap();
        param.add("ccy","BTC");
        return execute(param,"GET","/api/v5/asset/asset-valuation",clazz);
    }

    public <T> T assetTransfer(APIRequestPayload param, Class<T> clazz){
        return execute(param,"POST","/api/v5/asset/transfer",clazz);
    }

    public <T> T getAssetTransferState(APIRequestPayload param, Class<T> clazz){
        return execute(param,"GET","/api/v5/asset/transfer-state",clazz);
    }

    public <T> List<T> getAssetBills(APIRequestPayload param, Class<T> clazz){
        return listExecute(param,"GET","/api/v5/asset/bills",clazz);
    }

    public void setSimulate(boolean simulate) {
        isSimulate = simulate;
    }
    /**
     * 这里默认JsonObject 的格式为「"code":"1","data" :"","msg":"" 」
     * todo 后续需要考虑 返回异常码的情况
     * */
    private <T> T execute(APIRequestPayload param, String method, String path, Class<T> clazz){
        try{
            JsonObject jsonObject = this.commonAPICaller.requestAPI(method,path,param,isSimulate, JsonObject.class);
            System.out.println("execute:"+jsonObject);
            JsonElement dataElement = jsonObject.get("data");

            JsonArray dataList = jsonObject.get("data").getAsJsonArray();
            // TODO 这里本来是考虑list范型的情况，现在此方法不会返回List范型，需要修改
            if(dataList.size() == 0) {
                return clazz.newInstance();
            }else if(dataList.size() == 1){
                JsonElement data = dataList.get(0);
                return new Gson().fromJson(data,clazz);
            }else{
                return new Gson().fromJson(dataList,clazz);
            }
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    private <T> List<T> listExecute(APIRequestPayload param, String method, String path, Class<T> clazz) {
        try {
            JsonObject jsonObject = this.commonAPICaller.requestAPI(method, path, param, isSimulate, JsonObject.class);
            System.out.println("listExecute:"+jsonObject);
            JsonArray dataList = jsonObject.get("data").getAsJsonArray();

            if (dataList.size() == 0) {
                return new ArrayList<>();
            } else {
                List<T> list = new ArrayList<>();
                for (final JsonElement element : dataList) {
                    list.add(new Gson().fromJson(element, clazz));
                }
                return list;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
