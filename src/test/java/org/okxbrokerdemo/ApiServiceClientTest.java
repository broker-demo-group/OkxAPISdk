package org.okxbrokerdemo;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.security.AutorizationIntercepter;
import org.okxbrokerdemo.security.imp.OkxHeaderGenerator;
import org.okxbrokerdemo.ApiService.CommonApiService;
import org.okxbrokerdemo.ApiService.entry.AssetBalance;
import org.okxbrokerdemo.ApiService.entry.ParamMap;

import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/19  8:20 PM
 **/
class ApiServiceClientTest {

    ApiServiceClient buildServiceClient(){
        APIKeyHolder apiKeyHolder = new APIKeyHolder("","","");

        ApiServiceClient.Builder builder = new ApiServiceClient.Builder().
                apiKeyHolder(apiKeyHolder).
                baseUrl("https://www.okx.com").
                addInterceptor(new AutorizationIntercepter(new OkxHeaderGenerator()));

        ApiServiceClient apiServiceClient = builder.build();
        return apiServiceClient;
    }

    @Test
    void build(){

        System.out.println(buildServiceClient());
    }
    @Test
    void proxyBuild(){
        // 拿到客户端
        ApiServiceClient apiServiceClient = buildServiceClient();
        // 通过动态代理获得接口的代理对象
        CommonApiService commonApiService = apiServiceClient.create(CommonApiService.class);

        //代理对象可以直接拿来用
        String path = "/api/v5/public/time";
        JsonObject result = commonApiService.getExecute(new ParamMap(), "GET",path,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void proxy(){
        ParamMap param = new ParamMap();

        ApiServiceClient apiServiceClient = buildServiceClient();
        CommonApiService commonApiService = apiServiceClient.create(CommonApiService.class);


        String path = "/api/v5/asset/convert/currencies";
        // Param -> Open API -> List<JsonObject>
        List<JsonObject> result =  commonApiService.getListExecute(param,"GET",path,JsonObject.class);
        System.out.println(result);


        path = "/api/v5/asset/balances";
        //Param -> Open API -> List<T>
        List<AssetBalance> AssetBalanceList = commonApiService.getListExecute(()->"{}","GET",path, AssetBalance.class);
        System.out.println(AssetBalanceList);
    }

}