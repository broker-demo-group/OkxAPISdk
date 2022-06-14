package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;

/**
 * @author: bowen
 * @description: 一个通用的service，支持自定义API接口访问，自定义输入输出类型；
 * @date: 2022/6/14  8:49 AM
 **/
public class CommonService {
    String APIUrl ;
    public boolean isSimulate;
    APIKeyHolder apiKeyHolder;

    public CommonService(String APIUrl, boolean isSimulate, APIKeyHolder apiKeyHolder) {
        this.APIUrl = APIUrl;
        this.isSimulate = isSimulate;
        this.apiKeyHolder = apiKeyHolder;
    }

    public JsonObject postCall(APIRequestPayload param, String path){
        return doCall(param,"POST",path);
    }
    public <T> T postCall(APIRequestPayload param,String path,Class<T> clazz){
        JsonObject body = doCall(param,"POST",path);
        JsonElement data = body.get("data").getAsJsonArray().get(0);
        return  new Gson().fromJson(data,clazz);
    }

    public JsonObject getCall(APIRequestPayload param, String path){
        return doCall(param,"GET",path);
    }
    public <T> T getCall(APIRequestPayload param,String path,Class<T> clazz){
        JsonObject body = doCall(param,"GET",path);
        JsonElement data = body.get("data").getAsJsonArray().get(0);
        return  new Gson().fromJson(data,clazz);
    }

    public JsonObject doCall(APIRequestPayload param,String method,String path){
        CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller = new CommonAPICaller<>(APIUrl, apiKeyHolder);
        JsonObject r;

        try {
            r = commonAPICaller.requestAPI(method,
                    path, param, isSimulate,JsonObject.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return r;
    }


}
