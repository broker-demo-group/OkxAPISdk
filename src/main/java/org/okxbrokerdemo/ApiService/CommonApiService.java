package org.okxbrokerdemo.ApiService;

import org.okxbrokerdemo.ApiService.entry.APIRequestPayload;

import java.util.List;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/20  11:21 AM
 **/
public interface CommonApiService {
    /**
     * @param param request param
     * @param method http method : GET POST
     * @param path endpoint
     * @param clazz the return Class
     * @return return new Gson().formJson
     * */
    public <T> T postExecute(APIRequestPayload param,String method, String path, Class<T> clazz);


    public <T> T getExecute(APIRequestPayload param,String method, String path, Class<T> clazz);

    public <T> List<T> postListExecute(APIRequestPayload param,String method, String path, Class<T> clazz);


    public <T> List<T> getListExecute(APIRequestPayload param,String method, String path, Class<T> clazz);
}
