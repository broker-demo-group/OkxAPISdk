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

    public String placeOrderBatch(List<Map<String,Object>> ordersList,boolean isSimluate){
        return  "";
    }

}
