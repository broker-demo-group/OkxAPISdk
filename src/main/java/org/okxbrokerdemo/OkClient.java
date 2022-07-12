package org.okxbrokerdemo;

import okhttp3.OkHttpClient;
import org.okxbrokerdemo.intercepter.LogInterceptor;
import org.okxbrokerdemo.service.CommonRequestRetrofit;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class OkClient {

    private OkClient() {
    }

    private static final String BASE_URL = "https://www.okx.com";

    private static CommonRequestRetrofit commonRequestRetrofit;


    public static OkClient initOkClient() {
        OkClient okClient = new OkClient();
        LogInterceptor logInterceptor = new LogInterceptor();
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logInterceptor).build();
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl(BASE_URL).client(httpClient).addConverterFactory(ScalarsConverterFactory.create()).build();
        commonRequestRetrofit = retrofit.create(CommonRequestRetrofit.class);
        return okClient;
    }
}
