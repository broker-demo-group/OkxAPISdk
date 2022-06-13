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
import java.util.Map;

public class Trade {
    /**
     *
     *
     *
     *
     * **/


    private APIKeyHolder apiKeyHolder;

    public Trade(){}
    public String placeOrder(Map<String,Object> orderMap,boolean isSimluate) throws IOException {
        String API_URL = "https://aws.okx.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TradeRequestRetrofit service = retrofit.create(TradeRequestRetrofit.class);
        String payload = new Gson().toJson(orderMap);
        String timeStamp = Instant.now().toString();
        Map<String,String> headers;

        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair)){
            String sign = SignatureGenerator.Generate(timeStamp,"POST",payload,"/api/v5/trade/order",apiKeyHolder.getSecretKey());
            headers = headerMapBuilder.build(apiKeyHolder.getApiKey(),sign,timeStamp, apiKeyHolder.getPassPhrase(),isSimluate);
            Call<HashMap<String,Object>> orderCall = service.placeOrder(headers,orderMap);
            Response<HashMap<String,Object>> response= orderCall.execute();
            Request req= orderCall.request();
            System.out.println(req);
            if(response.isSuccessful()){
                return response.body().toString();
            }
            return response.errorBody().string();
        }
        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.AccessToken)){
            headers =headerMapBuilder.build(apiKeyHolder.getAccessToken(),isSimluate);
            Call<HashMap<String,Object>> orderCall = service.placeOrder(headers,orderMap);
            Request req= orderCall.request();
            System.out.println(req);
            Response<HashMap<String,Object>> response= orderCall.execute();
            if(response.isSuccessful()){
                return response.body().toString();
            }
            return response.errorBody().string();

        }
        return "Err";
    }

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }


}
