package org.okxbrokerdemo.service;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.okxbrokerdemo.service.entry.APIRequestPayload;
import org.okxbrokerdemo.APIKeyHolder;
import org.okxbrokerdemo.security.entry.AutorizationMethod;
import org.okxbrokerdemo.security.utils.SignatureGenerator;
import org.okxbrokerdemo.security.HeaderMapBuilder;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Map;

public class CommonAPICaller<E extends APIRequestPayload,R>  {
    private Retrofit retrofit;
    private CommonRequestRetrofit requestHandler;

    private Class<R> myType;
    private APIKeyHolder apiKeyHolder;


    public CommonAPICaller(String baseUrl,APIKeyHolder apiKeyHolder){
        retrofit =
                new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(ScalarsConverterFactory.create()).build();
        
        requestHandler = retrofit.create(CommonRequestRetrofit.class);
        this.apiKeyHolder = apiKeyHolder;
    }


    public R requestAPI(String method,String path,E element,boolean isSimluate) throws IOException {
        String payload = element.getPayLoadJson();
        String timeStamp = Instant.now().toString();
        Map<String,String> headers;
        Type retTyp = new TypeToken<R>() { }.getType();
        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair) && method.equals("POST")){
            String sign = SignatureGenerator.Generate(timeStamp,method,payload,path,apiKeyHolder.getSecretKey());
            headers = HeaderMapBuilder.build(apiKeyHolder.getApiKey(),sign,timeStamp, apiKeyHolder.getPassPhrase(),isSimluate);
            Call<String> requestCall = requestHandler.commonPostRequest(path,headers,payload);
            Response<String> response= requestCall.execute();

            if(response.isSuccessful()){
                return new Gson().fromJson(response.body(),retTyp);
            }

            return new Gson().fromJson(response.errorBody().string(),retTyp);


        }

        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.AccessToken) && method.equals("POST")){
            headers = HeaderMapBuilder.build(apiKeyHolder.getAccessToken(),isSimluate);
            Call<String> requestCall = requestHandler.commonPostRequest(path,headers,payload);
            Response<String> response= requestCall.execute();
            if(response.isSuccessful()){

                return new Gson().fromJson(response.body(),retTyp);
            }
            return new Gson().fromJson(response.errorBody().string(),retTyp);

        }
        //handleGetRequest
        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair) && method.equals("GET")){
            /**
             * Example path = "/api/v5/trade"
             * After loop the payload => /api/v5/trade?sz=5&px=10
             *
             *
             * **/
            Map<String,Object> queryMap = new Gson().fromJson(payload,Map.class);
            if(queryMap.size()>0){
                path =path + "?";
                for(String key:queryMap.keySet()){
                    path = path + key + "=" + queryMap.get(key).toString() + "&";
                }
                path = path.substring(0,path.length() - 1);
            }

            String sign = SignatureGenerator.Generate(timeStamp,method,"",path,apiKeyHolder.getSecretKey());
            headers = HeaderMapBuilder.build(apiKeyHolder.getApiKey(),sign,timeStamp, apiKeyHolder.getPassPhrase(),isSimluate);
            Call<String> requestCall = requestHandler.commonGetRequest(path,headers);
            Response<String> response= requestCall.execute();
            if(response.isSuccessful()){
                return new Gson().fromJson(response.body(),retTyp);
            }
            return new Gson().fromJson(response.errorBody().string(),retTyp);
        }

        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.AccessToken) && method.equals("GET")){
            headers = HeaderMapBuilder.build(apiKeyHolder.getAccessToken(),isSimluate);
            Map<String,Object> queryMap = new Gson().fromJson(payload,Map.class);
            if(queryMap.size()>0){
                path =path + "?";
                for(String key:queryMap.keySet()){
                    path = path + key + "=" + queryMap.get(key).toString() + "&";
                }
                path = path.substring(0,path.length() - 1);
            }

            Call<String> requestCall = requestHandler.commonGetRequest(path,headers);
            Response<String> response= requestCall.execute();
            if(response.isSuccessful()){
                return new Gson().fromJson(response.body(),retTyp);
            }

            return new Gson().fromJson(response.errorBody().string(),retTyp);
        }


        return null;
    }

    public R requestAPI(String method,String path,E element,boolean isSimulate, Class<R> clazz) throws IOException {
        String payload = element.getPayLoadJson();
        String timeStamp = Instant.now().toString();
        Map<String, String> headers;
        if (apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair) && "POST".equals(method)) {
            String sign = SignatureGenerator.Generate(timeStamp, method, payload, path, apiKeyHolder.getSecretKey());
            headers = HeaderMapBuilder.build(apiKeyHolder.getApiKey(), sign, timeStamp, apiKeyHolder.getPassPhrase(), isSimulate);
            Call<String> requestCall = requestHandler.commonPostRequest(path, headers, payload);
            Response<String> response = requestCall.execute();

            if (response.isSuccessful()) {
                return new Gson().fromJson(response.body(), clazz);
            }

            return new Gson().fromJson(response.errorBody().string(), clazz);
        }

        //handleGetRequest
        if(apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair) && "GET".equals(method)){
            Map<String,Object> queryMap = new Gson().fromJson(payload,Map.class);
            if(queryMap.size()>0){
                // TODO 使用StringBuilder append 实现字符串扩展
                path =path + "?";
                for(String key:queryMap.keySet()){
                    path = path + key + "=" + queryMap.get(key).toString() + "&";
                }
                path = path.substring(0,path.length() - 1);
            }
            String sign = SignatureGenerator.Generate(timeStamp,method,"",path,apiKeyHolder.getSecretKey());
            headers = HeaderMapBuilder.build(apiKeyHolder.getApiKey(),sign,timeStamp, apiKeyHolder.getPassPhrase(),isSimulate);
            Call<String> requestCall = requestHandler.commonGetRequest(path,headers);
            Response<String> response= requestCall.execute();
            if(response.isSuccessful()){
                return new Gson().fromJson(response.body(),clazz);
            }
            return new Gson().fromJson(response.errorBody().string(),clazz);
        }
        return null;
    }

}
