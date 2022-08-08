package org.okxbrokerdemo.service;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import org.okxbrokerdemo.exception.OkxApiException;
import org.okxbrokerdemo.intercepter.LogInterceptor;
import org.okxbrokerdemo.utils.APIKeyHolder;
import org.okxbrokerdemo.utils.AutorizationMethod;
import org.okxbrokerdemo.utils.SignatureGenerator;
import org.okxbrokerdemo.utils.HeaderMapBuilder;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommonAPICaller<E extends APIRequestPayload, R> {
    private Retrofit retrofit;
    private CommonRequestRetrofit requestHandler;

    private APIKeyHolder apiKeyHolder;
    private boolean isSimulate;

    public CommonAPICaller(String baseUrl, APIKeyHolder apiKeyHolder, boolean isSimulate) {

        LogInterceptor logInterceptor = new LogInterceptor();
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logInterceptor).build();
        retrofit =
                new Retrofit.Builder().baseUrl(baseUrl).client(httpClient).addConverterFactory(ScalarsConverterFactory.create()).build();
        this.isSimulate = isSimulate;
        requestHandler = retrofit.create(CommonRequestRetrofit.class);
        this.apiKeyHolder = apiKeyHolder;
    }



    public R requestAPI(String method, String path, E element, boolean isSimluate) throws IOException {
        String payload = element.getPayLoadJson();
        String timeStamp = Instant.now().toString();
        Map<String, String> headers;
        Type retTyp = new TypeToken<R>() {
        }.getType();
        if (apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair) && "POST".equals(method)) {
            String sign = SignatureGenerator.Generate(timeStamp, method, payload, path, apiKeyHolder.getSecretKey());
            headers = HeaderMapBuilder.build(apiKeyHolder.getApiKey(), sign, timeStamp, apiKeyHolder.getPassPhrase(), isSimluate);
            Call<String> requestCall = requestHandler.commonPostRequest(path, headers, payload);
            Response<String> response = requestCall.execute();

            if (response.isSuccessful()) {
                return new Gson().fromJson(response.body(), retTyp);
            }

            return new Gson().fromJson(response.errorBody().string(), retTyp);


        }

        if (apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.AccessToken) && method.equals("POST")) {
            headers = HeaderMapBuilder.build(apiKeyHolder.getAccessToken(), isSimluate);
            Call<String> requestCall = requestHandler.commonPostRequest(path, headers, payload);
            Response<String> response = requestCall.execute();
            if (response.isSuccessful()) {

                return new Gson().fromJson(response.body(), retTyp);
            }
            return new Gson().fromJson(response.errorBody().string(), retTyp);

        }
        //handleGetRequest
        if (apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair) && method.equals("GET")) {
            /**
             * Example path = "/api/v5/trade"
             * After loop the payload => /api/v5/trade?sz=5&px=10
             *
             *
             * **/
            Map<String, Object> queryMap = new Gson().fromJson(payload, Map.class);
            if (queryMap.size() > 0) {
                path = path + "?";
                for (String key : queryMap.keySet()) {
                    path = path + key + "=" + queryMap.get(key).toString() + "&";
                }
                path = path.substring(0, path.length() - 1);
            }

            String sign = SignatureGenerator.Generate(timeStamp, method, "", path, apiKeyHolder.getSecretKey());
            headers = HeaderMapBuilder.build(apiKeyHolder.getApiKey(), sign, timeStamp, apiKeyHolder.getPassPhrase(), isSimluate);
            Call<String> requestCall = requestHandler.commonGetRequest(path, headers);
            Response<String> response = requestCall.execute();
            if (response.isSuccessful()) {
                return new Gson().fromJson(response.body(), retTyp);
            }
            return new Gson().fromJson(response.errorBody().string(), retTyp);
        }

        if (apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.AccessToken) && method.equals("GET")) {
            headers = HeaderMapBuilder.build(apiKeyHolder.getAccessToken(), isSimluate);
            Map<String, Object> queryMap = new Gson().fromJson(payload, Map.class);
            if (queryMap.size() > 0) {
                path = path + "?";
                for (String key : queryMap.keySet()) {
                    path = path + key + "=" + queryMap.get(key).toString() + "&";
                }
                path = path.substring(0, path.length() - 1);
            }

            Call<String> requestCall = requestHandler.commonGetRequest(path, headers);
            Response<String> response = requestCall.execute();
            if (response.isSuccessful()) {
                return new Gson().fromJson(response.body(), retTyp);
            }

            return new Gson().fromJson(response.errorBody().string(), retTyp);
        }


        return null;
    }

    public <R> R requestAPI(String method, String path, E element, boolean isSimluate, Class<R> clazz) throws IOException {
        String payload = element.getPayLoadJson();
        String timeStamp = Instant.now().toString();
        Map<String, String> headers;
        if (apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair) && "POST".equals(method)) {
            String sign = SignatureGenerator.Generate(timeStamp, method, payload, path, apiKeyHolder.getSecretKey());
            headers = HeaderMapBuilder.build(apiKeyHolder.getApiKey(), sign, timeStamp, apiKeyHolder.getPassPhrase(), isSimluate);
            Call<String> requestCall = requestHandler.commonPostRequest(path, headers, payload);
            Response<String> response = requestCall.execute();

            if (response.isSuccessful()) {
                return new Gson().fromJson(response.body(), clazz);
            }

            return new Gson().fromJson(response.errorBody().string(), clazz);
        }

        //handleGetRequest
        if (apiKeyHolder.getAutorizationMethod().equals(AutorizationMethod.APIKeyPair) && "GET".equals(method)) {
            Map<String, Object> queryMap = new Gson().fromJson(payload, Map.class);
            if (queryMap.size() > 0) {
                // TODO 使用StringBuilder append 实现字符串扩展
                path = path + "?";
                for (String key : queryMap.keySet()) {
                    path = path + key + "=" + queryMap.get(key).toString() + "&";
                }
                path = path.substring(0, path.length() - 1);
            }
            String sign = SignatureGenerator.Generate(timeStamp, method, "", path, apiKeyHolder.getSecretKey());
            headers = HeaderMapBuilder.build(apiKeyHolder.getApiKey(), sign, timeStamp, apiKeyHolder.getPassPhrase(), isSimluate);
            Call<String> requestCall = requestHandler.commonGetRequest(path, headers);
            Response<String> response = requestCall.execute();
            if (response.isSuccessful()) {
                return new Gson().fromJson(response.body(), clazz);
            }
            return new Gson().fromJson(response.errorBody().string(), clazz);
        }
        return null;
    }

    public <T> T execute(E param, String method, String path, Class<T> clazz)throws OkxApiException{
        try {
            JsonObject jsonObject = this.requestAPI(method, path, param, isSimulate, JsonObject.class);
            System.out.println("execute:"+jsonObject);
            if (!"0".equals(jsonObject.get("code").getAsString())){
                throw new OkxApiException(jsonObject.get("msg").getAsString(),jsonObject.get("code").getAsInt());
            }
            JsonElement dataElement = jsonObject.get("data");

            if (!dataElement.isJsonArray()) {
                //为了一个getMarketIndexComponents case 添加这个判断

                return new Gson().fromJson(dataElement, clazz);
            }
            JsonArray dataList = jsonObject.get("data").getAsJsonArray();
            if (dataList.size() == 0) {
                return clazz.newInstance();
            } else if (dataList.size() == 1) {
                JsonElement data = dataList.get(0);
                return new Gson().fromJson(data, clazz);
            } else {
                return new Gson().fromJson(dataList, clazz);
            }
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public <T> List<T> listExecute(E param, String method, String path, Class<T> clazz) {
        try {


            JsonObject jsonObject = this.requestAPI(method, path, param, isSimulate, JsonObject.class);
            System.out.println("listExecute:"+jsonObject);

            JsonArray dataList = jsonObject.get("data").getAsJsonArray();
            if (!"0".equals(jsonObject.get("code").getAsString())){
                throw new OkxApiException(jsonObject.get("msg").getAsString(),jsonObject.get("code").getAsInt());
            }
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
