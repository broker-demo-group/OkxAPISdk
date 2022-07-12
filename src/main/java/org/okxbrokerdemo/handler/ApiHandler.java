package org.okxbrokerdemo.handler;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.okxbrokerdemo.constant.ApiEnum;
import org.okxbrokerdemo.intercepter.LogInterceptor;
import org.okxbrokerdemo.service.CommonRequestRetrofit;
import org.okxbrokerdemo.utils.HeaderMapBuilder;
import org.okxbrokerdemo.utils.SignatureGenerator;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class ApiHandler {

    private static final String BASE_URL = "https://aws.okx.com";
    private static final String SUCCESS_CODE = "0";
    private static final String FIELD_RESPONSE_CODE = "code";
    private static final String FIELD_RESPONSE_DATA = "data";
    private static final String FIELD_RESPONSE_MSG = "msg";
    private static final CommonRequestRetrofit commonRequestRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(new OkHttpClient.Builder().addInterceptor(new LogInterceptor()).build())
            .addConverterFactory(ScalarsConverterFactory.create()).build()
            .create(CommonRequestRetrofit.class);


    public Object handle(Request request) {
        if (Objects.isNull(request) || Objects.isNull(request.getApiEnum())) {
            throw new IllegalArgumentException();
        }

        parseAuthHeaders(request);

        Call<String> call = generateHttpCall(getPath(request), request);
        if (Objects.isNull(call)) {
            return null;
        }

        Response<String> response = null;
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return parseResponse(response, request.getApiEnum().getResponseType());

    }

    private void parseAuthHeaders(Request request) {
        if (Objects.isNull(request)) {
            return;
        }

        String timeStamp = Instant.now().toString();
        switch (request.getAutorizationMethod()) {
            case AccessToken:
                request.getHeaderMap().putAll(HeaderMapBuilder.build(request.getAccessToken(), request.getIsSimluate()));
                break;
            case APIKeyPair:
                String sign = SignatureGenerator.Generate(
                        timeStamp,
                        request.getApiEnum().getMethodType().getValue(),
                        request.getRequestBody(),
                        request.getApiEnum().getPath(),
                        request.getSecretKey()
                );
                Map<String, String> headers = HeaderMapBuilder.build(request.getApiKey(), sign, timeStamp, request.getPassPhrase(), request.getIsSimluate());
                request.getHeaderMap().putAll(headers);
                break;
            default:
                break;
        }
    }

    private Object parseResponse(Response<String> response, Type responseType) {
        if (Objects.isNull(response) || Objects.isNull(responseType)) {
            return null;
        }

        if (!response.isSuccessful() || StrUtil.isEmpty(response.body())) {
            log.error("ApiHandler parse fail,error:{}", response.errorBody());
            return null;
        }

        JsonObject responseJsonObj = new JsonParser().parse(response.body()).getAsJsonObject();
        String code = responseJsonObj.get(FIELD_RESPONSE_CODE).getAsString();
        if (StrUtil.isEmpty(code)) {
            log.error("ApiHandler parse fail,response:{}", responseJsonObj);
            return null;
        }

        if (!Objects.equals(code, SUCCESS_CODE)) {
            log.error("ApiHandler parse fail,code:{},msg:{}", code, responseJsonObj.get(FIELD_RESPONSE_MSG));
        }

        JsonElement data = responseJsonObj.get(FIELD_RESPONSE_DATA);
        if (Objects.isNull(data)) {
            return null;
        }

        return new Gson().fromJson(responseJsonObj.get(FIELD_RESPONSE_DATA), responseType);
    }


    private Call<String> generateHttpCall(String path, Request request) {
        if (Objects.isNull(path) || Objects.isNull(request)) {
            return null;
        }

        ApiEnum apiEnum = request.getApiEnum();
        switch (apiEnum.getMethodType()) {
            case GET:
                return commonRequestRetrofit.commonGetRequest(path, request.getHeaderMap(),
                        request.getQueryParamMap());
            case POST:
                return commonRequestRetrofit.commonPostRequest(path, request.getHeaderMap(),
                        request.getRequestBody());
            default:
                break;
        }

        return null;
    }

    private String getPath(Request request) {
        if (Objects.isNull(request) || Objects.isNull(request.getApiEnum())) {
            return null;
        }

        ApiEnum apiEnum = request.getApiEnum();


        // TODO pathValue使用%s占位？
        return apiEnum.isHasPathValue() ?
                String.format(apiEnum.getPath(), request.getPathParam()) :
                apiEnum.getPath();
    }

}
