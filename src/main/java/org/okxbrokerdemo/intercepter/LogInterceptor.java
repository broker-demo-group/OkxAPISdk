package org.okxbrokerdemo.intercepter;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author: bowen
 * @description:
 * @date: 2022/7/5  10:30 AM
 **/
public class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Request response = builder.build();

        System.out.println("------ "+response.method()+"  "+response.url()+" ------");
        System.out.println(response.headers());

        System.out.println(response.body());


        return chain.proceed(response);
    }


}
