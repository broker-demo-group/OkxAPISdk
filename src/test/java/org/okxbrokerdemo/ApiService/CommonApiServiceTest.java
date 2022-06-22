package org.okxbrokerdemo.ApiService;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.APIKeyHolder;
import org.okxbrokerdemo.ApiServiceClient;
import org.okxbrokerdemo.security.AutorizationIntercepter;
import org.okxbrokerdemo.security.imp.OkxHeaderGenerator;
import org.okxbrokerdemo.ApiService.entry.AssetBalance;
import org.okxbrokerdemo.ApiService.entry.ParamMap;

import java.util.List;

class CommonApiServiceTest {

    APIKeyHolder apiKeyHolder = new APIKeyHolder("","","");

    ApiServiceClient.Builder builder = new ApiServiceClient.Builder().
            apiKeyHolder(apiKeyHolder).
            baseUrl("https://www.okx.com").
            addInterceptor(new AutorizationIntercepter(new OkxHeaderGenerator()));
    ApiServiceClient apiServiceClient = builder.build();


    @Test
    void postExecute() throws InterruptedException {
        CommonApiService commonApiService = apiServiceClient.create(CommonApiService.class);
        ParamMap param = new ParamMap();
        param.add("ccy","BTC");
        param.add("amt","1");
        param.add("from","18"); // 6:funding account 18: trading account
        param.add("to","6");
        param.add("clientId","whosyourdaddy");
        JsonObject result;
        String path = "/api/v5/asset/transfer";
        result = commonApiService.postExecute(param,"POST",path, JsonObject.class);
        System.out.println(result);
        Thread.sleep(1100);
        param.add("from","6");
        param.add("to","18");
        result = commonApiService.postExecute(param,"POST",path, JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getExecute() {
        CommonApiService commonApiService = apiServiceClient.create(CommonApiService.class);
        String path = "/api/v5/public/time";
        JsonObject result = commonApiService.getExecute(new ParamMap(), "GET",path,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void postListExecute() {

    }

    @Test
    void getListExecute() {
        ParamMap param = new ParamMap();
        CommonApiService commonApiService = apiServiceClient.create(CommonApiService.class);

        String path = "/api/v5/asset/balances";
        //Param -> Open API -> List<T>
        List<AssetBalance> AssetBalanceList = commonApiService.getListExecute(()->"{}","GET",path, AssetBalance.class);
        System.out.println(AssetBalanceList);
    }
}