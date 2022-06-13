package org.okxbrokerdemo.service;


import com.google.gson.Gson;
import okhttp3.Request;
import org.okxbrokerdemo.utils.APIKeyHolder;
import org.okxbrokerdemo.utils.AutorizationMethod;
import org.okxbrokerdemo.utils.SignatureGenerator;
import org.okxbrokerdemo.utils.headerMapBuilder;
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
    public Trade(){}
    public Map<String,Object> placeOrder(APIRequestPayload apiRequestPayload,boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/trade/order",apiRequestPayload,isSimluate);
        return  result;
    }

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }

    public Map<String,Object> batchOrders(APIRequestPayload apiRequestPayload,boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/trade/batch-orders",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> cancelOrder(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("POST","/api/v5/trade/cancel-order",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String,Object> cancelBatchOrder(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("POST","/api/v5/trade/cancel-batch-orders",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public Map<String,Object> amendOrder(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("POST","/api/v5/trade/amend-order",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public Map<String,Object> amendBatchOrder(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("POST","/api/v5/trade/amend-batch-orders",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String,Object> closePosition(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("POST","/api/v5/trade/close-position",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public Map<String,Object> getOrder(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("GET","/api/v5/trade/order",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public Map<String,Object> getOrderPending(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("GET","/api/v5/trade/orders-pending",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public Map<String,Object> getOrderHistory(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("GET","/api/v5/trade/orders-history",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String,Object> getOrderHistoryArchive(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("GET","/api/v5/trade/orders-history-archive",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String,Object> getFills(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("GET","/api/v5/trade/fills",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String,Object> getFillsHistory(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("GET","/api/v5/trade/fills-history",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String,Object> orderAlgo(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("POST","/api/v5/trade/order-algo",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String,Object> cancelAlgo(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("POST","/api/v5/trade/cancel-algos",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String,Object> cancelAdvanceAlgo(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("POST","/api/v5/trade/cancel-advance-algos",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String,Object> getOrdersAlgoPending(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("GET","/api/v5/trade/orders-algo-pending",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String,Object> getOrdersAlgoHistory(APIRequestPayload apiRequestPayload,boolean isSimluate){
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = null;
        try {
            result = commonAPICaller.requestAPI("GET","/api/v5/trade/orders-algo-history",apiRequestPayload,isSimluate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }







}
