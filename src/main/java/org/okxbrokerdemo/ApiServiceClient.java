package org.okxbrokerdemo;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import org.okxbrokerdemo.ApiService.CommonRequest;
import org.okxbrokerdemo.security.AutorizationIntercepter;
import org.okxbrokerdemo.ApiService.entry.APIRequestPayload;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/19  4:25 PM
 **/
public class ApiServiceClient {
    private String baseUrl;
    private APIKeyHolder apiKeyHolder;
    private Retrofit retrofit;
    private CommonRequest commonRequest;
    private  boolean isSimulate = true;



    private ApiServiceClient(String baseUrl, APIKeyHolder apiKeyHolder, Retrofit retrofit) {
        this.baseUrl = baseUrl;
        this.apiKeyHolder = apiKeyHolder;
        this.retrofit = retrofit;
        this.commonRequest = this.retrofit.create(CommonRequest.class);

    }

    public <T> T create(Class<T> service){
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service},
                (proxy, method, args) -> {
                    if (method.getDeclaringClass() == Object.class) {
                        return method.invoke(this, args);
                    }
                    Class<?> returnType = method.getReturnType();

                    if (List.class.isAssignableFrom(returnType)) {
                        return listExecute((APIRequestPayload) args[0], (String) args[1], (String) args[2],
                                (Class) args[3]);
                    } else {
                        return execute((APIRequestPayload) args[0], (String) args[1], (String) args[2],
                                (Class) args[3]);
                    }
                });
    }



    public  <T> T execute(APIRequestPayload param, String method, String path, Class<T> clazz){
        try{
            JsonObject jsonObject = doRequest(param,method,path);
            JsonArray dataList = jsonObject.get("data").getAsJsonArray();
            if(dataList.size() == 0) {
                return clazz.newInstance();
            }else if(dataList.size() == 1){
                JsonElement data = dataList.get(0);
                return new Gson().fromJson(data,clazz);
            }else{
                return new Gson().fromJson(dataList,clazz);
            }
        } catch (  InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public  <T> List<T> listExecute(APIRequestPayload param, String method, String path, Class<T> clazz) {

        JsonObject jsonObject = doRequest(param,method,path);
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
/**
 *
 *
 * */
    }
    private JsonObject doRequest(APIRequestPayload param, String method, String path){
        String payload = param.getPayLoadJson();

        JsonObject jsonPayload = new Gson().fromJson(payload,JsonObject.class);

        Call<JsonObject> requestCall = "GET".equalsIgnoreCase(method)? commonRequest.getRequest(getPath(path,payload)):
                commonRequest.postRequest(path,jsonPayload);
        Response<JsonObject> response = null;
        JsonObject jsonObject;
        try {
            response = requestCall.execute();
            if (response.isSuccessful()) {
                jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
            }else{
                jsonObject = new Gson().fromJson(response.errorBody().string(), JsonObject.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonObject;

    }

    public static String getPath(String path,String payload){
        Map<String,Object> queryMap = new Gson().fromJson(payload,Map.class);
        StringBuilder stringBuilder  = new StringBuilder(path);
        if(queryMap.size()>0){
            stringBuilder.append("?");
            for(String key:queryMap.keySet()){
                stringBuilder.append(key);
                stringBuilder.append("=");
                stringBuilder.append(queryMap.get(key).toString());
                stringBuilder.append("&");
            }
            path = stringBuilder.substring(0,stringBuilder.length()-1);
        }
        return path;
    }

    public boolean isSimulate() {
        return isSimulate;
    }

    public static class  Builder{
        private String baseUrl;
        private AutorizationIntercepter autorizationIntercepter;

        private APIKeyHolder apiKeyHolder;
        private  boolean isSimulate = true;
        public Builder() {

        }
        public  Builder isSimulate(boolean isSimulate){
            this.isSimulate = isSimulate;
            return this;
        }
        public Builder addInterceptor(AutorizationIntercepter interceptor){
            this.autorizationIntercepter = interceptor;
            return this;
        }
        public Builder apiKeyHolder(APIKeyHolder apiKeyHolder){
            this.apiKeyHolder = apiKeyHolder;
            return this;
        }
        public Builder baseUrl(String baseUrl){
            this.baseUrl = baseUrl;
            return this;
        }

        public ApiServiceClient build(){
            if(baseUrl == null){
                System.out.println("baseUrl not define");
                return null;
            }
            if(apiKeyHolder == null){
                System.out.println("apiKey is null");
                return null;
            }

            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

            if (autorizationIntercepter != null){
                autorizationIntercepter.setBaseUrl(baseUrl);
                autorizationIntercepter.setApiKeyHolder(apiKeyHolder);
                autorizationIntercepter.setSimulate(isSimulate);
                clientBuilder.addInterceptor(autorizationIntercepter);
            }
            Retrofit retrofit =
                    new Retrofit.Builder().client(clientBuilder.build()).baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create()).build();

            return new ApiServiceClient(baseUrl,apiKeyHolder,retrofit);
        }
    }
}
