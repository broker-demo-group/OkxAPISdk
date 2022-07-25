package org.okxbrokerdemo.service;


import com.google.gson.JsonObject;
import org.okxbrokerdemo.constant.ApiEnum;
import org.okxbrokerdemo.handler.OkApiHandler;
import org.okxbrokerdemo.handler.Request;
import org.okxbrokerdemo.handler.trade.PlaceOrderReq;
import org.okxbrokerdemo.handler.trade.PlaceOrderRes;
import org.okxbrokerdemo.handler.trade.QueryOrderDetailReq;
import org.okxbrokerdemo.handler.trade.QueryOrderDetailRes;
import org.okxbrokerdemo.utils.APIKeyHolder;
import java.util.List;

public class Trade {
    /**
     *
     **/


    private APIKeyHolder apiKeyHolder;
    private String baseURL = "https://www.okx.com";

    private CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public Trade() {
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public CommonAPICaller<APIRequestPayload, JsonObject> getCommonAPICaller() {
        return commonAPICaller;
    }

    public void setCommonAPICaller(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }

    public <T> T placeOrder(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        //CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/trade/order", clazz);
        return result;
    }

    public List<PlaceOrderRes> placeOrder(PlaceOrderReq req, APIKeyHolder apiKeyHolder) {
        Request request = OkApiHandler.generateRequest(req, ApiEnum.PLACE_ORDER);
        return (List<PlaceOrderRes>) OkApiHandler.handle(request, apiKeyHolder);
    }

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }

    public <T> List<T> batchOrders(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        //CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "POST", "/api/v5/trade/batch-orders", clazz);
        return result;
    }

    public <T> T cancelOrder(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/trade/cancel-order", clazz);

        return result;
    }

    public <T> List<T> cancelBatchOrder(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "POST", "/api/v5/trade/cancel-batch-orders", clazz);
        return result;
    }


    public <T> T amendOrder(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/trade/amend-order", clazz);

        return result;
    }


    public <T> List<T> amendBatchOrder(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "POST", "/api/v5/trade/amend-batch-orders", clazz);

        return result;
    }

    public <T> List<T> closePosition(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "POST", "/api/v5/trade/close-position", clazz);
        return result;
    }


    public <T> List<T> getOrder(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/trade/order", clazz);
        return result;
    }

    public List<QueryOrderDetailRes> getOrder(QueryOrderDetailReq req, APIKeyHolder apiKeyHolder) {
        Request request = OkApiHandler.generateRequest(req, ApiEnum.GET_ORDER_DETAILS);
        return (List<QueryOrderDetailRes>) OkApiHandler.handle(request, apiKeyHolder);
    }

    public <T> List<T> getOrderPending(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/trade/orders-pending", clazz);
        return result;
    }

    public <T> List<T> getOrderHistory(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/trade/orders-history", clazz);

        return result;
    }

    public <T> List<T> getOrderHistoryArchive(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/trade/orders-history-archive", clazz);
        return result;
    }

    public <T> List<T> getFills(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/trade/fills", clazz);
        return result;
    }

    public <T> List<T> getFillsHistory(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/trade/fills-history", clazz);

        return result;
    }

    public <T> T orderAlgo(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/trade/order-algo", clazz);

        return result;
    }

    public <T> List<T> cancelAlgo(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "POST", "/api/v5/trade/cancel-algos", clazz);
        return result;
    }

    public <T> List<T> cancelAdvanceAlgo(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "POST", "/api/v5/trade/cancel-advance-algos", clazz);
        return result;
    }

    public <T> List<T> getOrdersAlgoPending(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/trade/orders-algo-pending", clazz);

        return result;
    }

    public <T> List<T> getOrdersAlgoHistory(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/trade/orders-algo-history", clazz);

        return result;
    }

}
