package org.okxbrokerdemo.security;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.okxbrokerdemo.APIKeyHolder;
import org.okxbrokerdemo.security.imp.OkxHeaderGenerator;

import java.io.IOException;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/18  4:48 PM
 **/
public class AutorizationIntercepter  implements Interceptor {
    HeaderGenerator headerGenerator;
    APIKeyHolder apiKeyHolder;
    boolean isSimulate;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    String baseUrl;
    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }

    public AutorizationIntercepter(HeaderGenerator headerGenerator) {
        this.headerGenerator = headerGenerator;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Headers headers = headerGenerator.generateHeaders(chain.request(),apiKeyHolder,isSimulate,baseUrl);
        builder.headers(headers);
        Request response = builder.build();


//        System.out.println(response.method());
//        System.out.println(response.url());
//        System.out.println("------");
//        System.out.println(response.headers());
//        System.out.println("------");

        System.out.println(OkxHeaderGenerator.getBody(response));
        return chain.proceed(response);
    }

    public void setHeaderGenerator(HeaderGenerator headerGenerator) {
        this.headerGenerator = headerGenerator;
    }

    public void setSimulate(boolean simulate) {
        isSimulate = simulate;
    }
}
