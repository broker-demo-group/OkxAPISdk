package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: bowen
 * @description: 一个通用的service，支持自定义API接口访问，自定义输入输出类型；
 * @date: 2022/6/14  8:49 AM
 **/
public class CommonService {
    String APIUrl ;
    public boolean isSimulate;
    APIKeyHolder apiKeyHolder;
    CommonAPICaller<APIRequestPayload,JsonObject> commonAPICaller;
    // TODO 这里 ApiKeyHolder应该再Client中
    // TODO Service 和 CommonAPI 应该是1：1 组合的关系；
    public CommonService(String APIUrl, boolean isSimulate, APIKeyHolder apiKeyHolder) {
        this.APIUrl = APIUrl;
        this.isSimulate = isSimulate;
        this.apiKeyHolder = apiKeyHolder;
        commonAPICaller = new CommonAPICaller<>(APIUrl,this.apiKeyHolder );
    }

    public <R> R postExecute(APIRequestPayload param, String path, Class<R> clazz){
        return  execute(param,"POST",path,clazz);
    }


    public <R> R getExecute(APIRequestPayload param, String path, Class<R> clazz){
        return execute(param,"GET",path,clazz);
    }

    public <R> List<R> postListExecute(APIRequestPayload param, String path, Class<R> clazz){
        return  listExecute(param,"POST",path,clazz);
    }


    public <R> List<R> getListExecute(APIRequestPayload param, String path, Class<R> clazz){
        return listExecute(param,"GET",path,clazz);
    }

    private <T> T execute(APIRequestPayload param, String method, String path, Class<T> clazz){

        try{
            JsonObject jsonObject = this.commonAPICaller.requestAPI(method,path,param,isSimulate, JsonObject.class);
            System.out.println("execute:"+jsonObject);
            JsonArray dataList = jsonObject.get("data").getAsJsonArray();
            // TODO 这里本来是考虑list范型的情况，现在此方法不会返回List范型，需要修改
            if(dataList.size() == 0) {
                return clazz.newInstance();
            }else if(dataList.size() == 1){
                JsonElement data = dataList.get(0);
                return new Gson().fromJson(data,clazz);
            }else{

                return new Gson().fromJson(dataList,clazz);
            }
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> List<T> listExecute(APIRequestPayload param, String method, String path, Class<T> clazz) {
        try {
            JsonObject jsonObject = this.commonAPICaller.requestAPI(method, path, param, isSimulate, JsonObject.class);
            System.out.println("listExecute:"+jsonObject);
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
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
