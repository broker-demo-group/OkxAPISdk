package org.okxbrokerdemo.service;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;

public class OAuth {
    String baseUrl = "https://aws.okx.com";
    /**
     *     "grant_type":"authorization_code",
     *     "code":"f8d24cf76b5d41ccafeb646be65e383965TtKv",
     *     "client_id":"YOUR_CLIENT_ID",
     *     "client_secret": "YOUR_CLIENT_SECRET"
     *
     *
     * **/
    public String getAccessToken(String code,String clientId,String clientSecret) throws IOException {
        String path = "/v5/users/oauth/token";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        TradeRequestRetrofit requestHandler = retrofit.create(TradeRequestRetrofit.class);
        HashMap<String,Object> body = new HashMap<>();
        body.put("grant_type","authorization_code");
        body.put("code",code);
        body.put("client_id",clientId);
        body.put("client_secret",clientSecret);
        Call<HashMap<String,Object>> call = requestHandler.commonPostRequestMap(path,new HashMap<String,String>(),new HashMap<String,Object>());
        Response<HashMap<String,Object>> res = call.execute();
        if(res.isSuccessful()){
            return res.body().toString();
        }
        return res.errorBody().string();
    }
}
