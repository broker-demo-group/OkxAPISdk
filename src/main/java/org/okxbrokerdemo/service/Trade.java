package org.okxbrokerdemo.service;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.Request;
import org.okxbrokerdemo.utils.APIKeyHolder;
import org.okxbrokerdemo.utils.AutorizationMethod;
import org.okxbrokerdemo.utils.SignatureGenerator;
import org.okxbrokerdemo.utils.HeaderMapBuilder;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trade {
    /**
     *
     *
     *
     *
     * **/


    private APIKeyHolder apiKeyHolder;
    private String baseURL = "https://www.okx.com";

    private CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;
    public Trade(){}

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

    public <T> T placeOrder(APIRequestPayload apiRequestPayload,Class<T> clazz)  {
        //CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        T result = commonAPICaller.execute(apiRequestPayload,"POST","/api/v5/trade/order",clazz);
        return  result;
    }

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }

    public <T> List<T> batchOrders(APIRequestPayload apiRequestPayload,Class<T> clazz)  {
        //CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"POST","/api/v5/trade/batch-orders",clazz);
        return  result;
    }

    public <T> T cancelOrder(APIRequestPayload apiRequestPayload,Class<T> clazz)  {
        T result = commonAPICaller.execute(apiRequestPayload,"POST","/api/v5/trade/cancel-order",clazz);

        return result;
    }

    public <T> List<T> cancelBatchOrder(APIRequestPayload apiRequestPayload,Class<T> clazz){
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"POST","/api/v5/trade/cancel-batch-orders",clazz);
        return result;
    }


    public <T> T amendOrder(APIRequestPayload apiRequestPayload,Class<T> clazz){

        T result = commonAPICaller.execute(apiRequestPayload,"POST","/api/v5/trade/amend-order",clazz);

        return result;
    }


    public <T> List<T> amendBatchOrder(APIRequestPayload apiRequestPayload,Class<T> clazz){
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"POST","/api/v5/trade/amend-batch-orders",clazz);

        return result;
    }

    public <T> List<T> closePosition(APIRequestPayload apiRequestPayload,Class<T> clazz){
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"POST","/api/v5/trade/close-position",clazz);
        return result;
    }


    public <T> List<T> getOrder(APIRequestPayload apiRequestPayload,Class<T> clazz){

        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/trade/order",clazz);
        return result;
    }


    public <T> List<T> getOrderPending(APIRequestPayload apiRequestPayload,Class<T> clazz){
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/trade/orders-pending",clazz);
        return result;
    }
    public <T> List<T> getOrderHistory(APIRequestPayload apiRequestPayload,Class<T> clazz){

        List<T> result  = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/trade/orders-history",clazz);

        return result;
    }

    public <T> List<T> getOrderHistoryArchive(APIRequestPayload apiRequestPayload,Class<T> clazz){
        List<T>  result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/trade/orders-history-archive",clazz);
        return result;
    }

    public <T> List<T> getFills(APIRequestPayload apiRequestPayload,Class<T> clazz){
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/trade/fills",clazz);
        return result;
    }

    public <T> List<T> getFillsHistory(APIRequestPayload apiRequestPayload,Class<T> clazz){

        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/trade/fills-history",clazz);

        return result;
    }

    public <T> T orderAlgo(APIRequestPayload apiRequestPayload,Class<T> clazz){

        T result = commonAPICaller.execute(apiRequestPayload,"POST","/api/v5/trade/order-algo",clazz);

        return result;
    }

    public <T> List<T> cancelAlgo(APIRequestPayload apiRequestPayload,Class<T> clazz){
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"POST","/api/v5/trade/cancel-algos",clazz);
        return result;
    }

    public <T> List<T> cancelAdvanceAlgo(APIRequestPayload apiRequestPayload,Class<T> clazz){
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"POST","/api/v5/trade/cancel-advance-algos",clazz);
        return result;
    }

    public <T> List<T> getOrdersAlgoPending(APIRequestPayload apiRequestPayload,Class<T> clazz){

        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/trade/orders-algo-pending",clazz);

        return result;
    }

    public <T> List<T> getOrdersAlgoHistory(APIRequestPayload apiRequestPayload,Class<T> clazz){

        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/trade/orders-algo-history",clazz);

        return result;
    }

}
