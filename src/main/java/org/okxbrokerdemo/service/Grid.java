package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/21  6:33 PM
 **/
public class Grid {

    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public Grid(CommonAPICaller<APIRequestPayload, JsonObject> commonApiCaller) {
        this.commonAPICaller = commonApiCaller;
    }

    public <T> T getOrderAlgo(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/tradingBot/grid/order-algo", clazz);
    }

    /**
     * 获取余额
     */
    public <T> T amendOrderAlgo(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/tradingBot/grid/amend-order-algo", clazz);
    }

    public <T> T stopOrderAlgo(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/tradingBot/grid/stop-order-algo", clazz);
    }

    public <T> List<T> getOrdersAlgoPending(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/tradingBot/grid/orders-algo-pending", clazz);
    }

    public <T> List<T> getOrdersAlgoHistory(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/tradingBot/grid/orders-algo-history", clazz);
    }

    public <T> T getOrdersAlgoDetails(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/tradingBot/grid/orders-algo-details", clazz);
    }

    public <T> T getSubOrders(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/tradingBot/grid/sub-orders", clazz);
    }

    public <T> T getPositions(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/tradingBot/grid/positions", clazz);
    }

    public <T> T getWithdrawIncome(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/tradingBot/grid/withdraw-income", clazz);
    }


}
