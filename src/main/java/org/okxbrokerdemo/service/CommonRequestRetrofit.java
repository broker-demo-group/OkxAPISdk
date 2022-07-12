package org.okxbrokerdemo.service;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface CommonRequestRetrofit {
    @POST
    Call<String> commonPostRequest(@Url String endpoint, @HeaderMap Map<String, String> headers, @Body String payload);

    @GET
    Call<String> commonGetRequest(@Url String endpoint, @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> queryMap);

}
