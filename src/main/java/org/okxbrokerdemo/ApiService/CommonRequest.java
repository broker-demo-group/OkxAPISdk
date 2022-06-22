package org.okxbrokerdemo.ApiService;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/20  11:21 AM
 **/
public interface CommonRequest {
    @POST
    Call<JsonObject> postRequest(@Url String endpoint, @Body JsonObject payload);

    @GET
    Call<JsonObject> getRequest(@Url String endpoint);
}
