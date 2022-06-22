package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.okxbrokerdemo.APIKeyHolder;
import org.okxbrokerdemo.service.entry.APIRequestPayload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    String APIUrl = "https://www.okx.com";

    public boolean isSimulate = true;
    APIKeyHolder apiKeyHolder;
    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;
    public Grid(APIKeyHolder apiKeyHolder){
        this.apiKeyHolder = apiKeyHolder;
        commonAPICaller = new CommonAPICaller<>(APIUrl,this.apiKeyHolder );
    }
    public <T> T getOrderAlgo(APIRequestPayload param,Class<T> clazz) {
        return execute(param, "POST", "/api/v5/tradingBot/grid/order-algo", clazz);
    }
    /**
     * 获取余额
     */
    public <T> T amendOrderAlgo(APIRequestPayload param, Class<T> clazz) {
        return execute(param, "POST", "/api/v5/tradingBot/grid/amend-order-algo", clazz);
    }

    public <T> T stopOrderAlgo(APIRequestPayload param, Class<T> clazz){
        return execute(param,"POST","/api/v5/tradingBot/grid/stop-order-algo",clazz);
    }
    public <T> List<T> getOrdersAlgoPending(APIRequestPayload param,Class<T> clazz){
        return listExecute(param,"GET","/api/v5/tradingBot/grid/orders-algo-pending",clazz);
    }

    public <T> List<T> getOrdersAlgoHistory(APIRequestPayload param,Class<T> clazz){
        return listExecute(param,"GET","/api/v5/tradingBot/grid/orders-algo-history",clazz);
    }

    public <T> T getOrdersAlgoDetails(APIRequestPayload param,Class<T> clazz){
        return execute(param,"GET","/api/v5/tradingBot/grid/orders-algo-details",clazz);
    }

    public <T> T getSubOrders(APIRequestPayload param,Class<T> clazz){
        return execute(param,"GET","/api/v5/tradingBot/grid/sub-orders",clazz);
    }

    public <T> T getPositions(APIRequestPayload param,Class<T> clazz){
        return execute(param,"GET","/api/v5/tradingBot/grid/positions",clazz);
    }

    public <T> T getWithdrawIncome(APIRequestPayload param,Class<T> clazz){
        return execute(param,"POST","/api/v5/tradingBot/grid/withdraw-income",clazz);
    }


    private <T> T execute(APIRequestPayload param, String method, String path, Class<T> clazz){
        try{
            JsonObject jsonObject = this.commonAPICaller.requestAPI(method,path,param,isSimulate, JsonObject.class);
            System.out.println("execute:"+jsonObject);
            JsonElement dataElement = jsonObject.get("data");

            JsonArray dataList = jsonObject.get("data").getAsJsonArray();
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
