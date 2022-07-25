package org.okxbrokerdemo.handler;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.okxbrokerdemo.constant.ApiEnum;
import org.okxbrokerdemo.constant.MethodTypeEnum;
import org.okxbrokerdemo.exception.OkxApiException;
import org.okxbrokerdemo.intercepter.LogInterceptor;
import org.okxbrokerdemo.service.CommonRequestRetrofit;
import org.okxbrokerdemo.utils.APIKeyHolder;
import org.okxbrokerdemo.utils.HeaderMapBuilder;
import org.okxbrokerdemo.utils.SignatureGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class OkApiHandler {

    private static final String BASE_URL = "https://www.okx.com/";
    private static final String SUCCESS_CODE = "0";
    private static final String FIELD_RESPONSE_CODE = "code";
    private static final String FIELD_RESPONSE_DATA = "data";
    private static final String FIELD_RESPONSE_MSG = "msg";
    private static final CommonRequestRetrofit COMMON_REQUEST_RETROFIT = (new Retrofit.Builder()).baseUrl("https://www.okx.com/").client((new OkHttpClient.Builder()).addInterceptor(new LogInterceptor()).build()).addConverterFactory(ScalarsConverterFactory.create()).build().create(CommonRequestRetrofit.class);

    public OkApiHandler() {
    }

    public static Object handle(Request request, APIKeyHolder apiKeyHolder) {
        if (Objects.isNull(request)) {
            throw new OkxApiException("request is null", 10000);
        } else if (Objects.isNull(request.getApiEnum())) {
            throw new OkxApiException("apiEnum is null", 10000);
        } else {
            parseAuthHeaders(request, apiKeyHolder);
            Call<String> call = generateHttpCall(request);
            Response<String> response = null;
            try {
                response = call.execute();
            } catch (Exception var5) {
                throw new OkxApiException(var5);
            }

            return parseResponse(response, request.getApiEnum().getResponseType());
        }
    }

    public static Request generateRequest(Object request, ApiEnum apiEnum) {
        MethodTypeEnum methodType = apiEnum.getMethodType();
        Map<String, String> param;
        Map<String, String> map;
        switch (methodType) {
            case GET:
                param = Optional.ofNullable(BeanUtil.beanToMap(request, false, true)).orElse(new HashMap());
                map = param.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, (entry) -> entry.getValue()));
                return Request.builder().apiEnum(apiEnum).queryParamMap(map).build();
            case POST:
                return Request.builder().apiEnum(apiEnum).requestBody((new Gson()).toJson(request)).build();
            default:
                param = Optional.ofNullable(BeanUtil.beanToMap(request, false, true)).orElse(new HashMap());
                map = param.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, (entry) -> entry.getValue()));
                return Request.builder().apiEnum(apiEnum).queryParamMap(map).build();
        }
    }

    private static void parseAuthHeaders(Request request, APIKeyHolder apiKeyHolder) {
        if (Objects.isNull(request)) {
            throw new OkxApiException("request is null", 10000);
        } else if (!Objects.isNull(apiKeyHolder)) {
            String timeStamp = Instant.now().toString();
            switch (apiKeyHolder.getAutorizationMethod()) {
                case AccessToken:
                    request.getHeaderMap().putAll(HeaderMapBuilder.build(apiKeyHolder.getAccessToken(), apiKeyHolder.getIsSimluate()));
                    return;
                case APIKeyPair:
                    String sign = SignatureGenerator.Generate(timeStamp, request.getApiEnum().getMethodType().getValue(), request.getRequestBody(), joinPath(request.getApiEnum().getPath(), request.getQueryParamMap()), apiKeyHolder.getSecretKey());
                    Map<String, String> headers = HeaderMapBuilder.build(apiKeyHolder.getApiKey(), sign, timeStamp, apiKeyHolder.getPassPhrase(), apiKeyHolder.getIsSimluate());
                    request.getHeaderMap().putAll(headers);
                    return;
                default:
            }

        }
    }

    private static String joinPath(String path, Map<String, String> paramMap) {
        if (CollectionUtil.isEmpty(paramMap)) {
            return path;
        } else {
            List<String> params = paramMap.entrySet().stream().
                    map((entry) -> entry.getKey() + "=" + entry.getValue())
                    .collect(Collectors.toList());
            return path + "?" + StrUtil.join("&", params);
        }
    }

    private static Object parseResponse(Response<String> response, Type responseType) {
        if (Objects.isNull(response)) {
            log.error("ApiHandler parseResponse failed,response or responseType is null");
            throw new OkxApiException("response is null", 10002);
        } else if (!response.isSuccessful()) {
            log.error("ApiHandler parseResponse failed,response:{},responseType:{}", response, responseType);
            throw new OkxApiException("response:" + response.errorBody(), 10002);
        } else {
            JsonObject responseJsonObj = (new JsonParser()).parse(response.body()).getAsJsonObject();
            String code = responseJsonObj.get(FIELD_RESPONSE_CODE).getAsString();
            if (StrUtil.isEmpty(code)) {
                log.error("ApiHandler parseResponse failed,code is empty,response:{},responseType:{}", response, responseType);
                throw new OkxApiException("code is empty:" + response, 10002);
            } else if (!Objects.equals(code, SUCCESS_CODE)) {
                log.error("ApiHandler parseResponse failed,code:{},msg:{}", code, responseJsonObj.get(FIELD_RESPONSE_MSG));
                throw new OkxApiException("code:" + code, 10002);
            } else {
                return (new Gson()).fromJson(responseJsonObj.get(FIELD_RESPONSE_DATA), responseType);
            }
        }
    }

    private static Call<String> generateHttpCall(Request request) {
        ApiEnum apiEnum = request.getApiEnum();
        switch (apiEnum.getMethodType()) {
            case GET:
                return COMMON_REQUEST_RETROFIT.commonGetRequest(apiEnum.getPath(), request.getHeaderMap(), request.getQueryParamMap());
            case POST:
                return COMMON_REQUEST_RETROFIT.commonPostRequest(apiEnum.getPath(), request.getHeaderMap(), request.getRequestBody());
            default:
                throw new OkxApiException("can not resolve method type", 10001);
        }
    }

}
