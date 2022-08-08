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
    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public CommonService(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }


    public <R> R postExecute(APIRequestPayload param, String path, Class<R> clazz) {
        return commonAPICaller.execute(param, "POST", path, clazz);
    }


    public <R> R getExecute(APIRequestPayload param, String path, Class<R> clazz) {
        return commonAPICaller.execute(param, "GET", path, clazz);
    }

    public <R> List<R> postListExecute(APIRequestPayload param, String path, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "POST", path, clazz);
    }


    public <R> List<R> getListExecute(APIRequestPayload param, String path, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", path, clazz);
    }


}
