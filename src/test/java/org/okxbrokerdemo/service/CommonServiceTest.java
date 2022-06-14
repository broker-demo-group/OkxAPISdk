package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.service.Entry.ParamMap;
import org.okxbrokerdemo.service.Entry.Quote;
import org.okxbrokerdemo.utils.APIKeyHolder;

import static org.junit.jupiter.api.Assertions.*;

class CommonServiceTest {
    CommonService commonService;
    {
        String URL = "https://www.okx.com";
        boolean isSimulate = true;
        APIKeyHolder apiKeyHolder = new APIKeyHolder();
        apiKeyHolder.init("","","");
        commonService = new CommonService(URL, isSimulate, apiKeyHolder);
    }


    @Test
    void postCall() {
        ParamMap param = new ParamMap();
        param.add("baseCcy", "ETH");
        param.add("quoteCcy", "USDT");
        param.add("side", "buy");
        param.add("rfqSz", "1");
        param.add("rfqSzCcy", "USDT");
//        param.add("clQReqId", "greedisisgood");

        String path = "/api/v5/asset/convert/estimate-quote";

        // Param -> Open API -> JsonObject ->POJO
        Quote quote = commonService.postCall(param,path,Quote.class);
        System.out.println(quote);


        // Param -> Open API -> JsonObject
        JsonObject jsonObject =  commonService.postCall(param,path);
        System.out.println(jsonObject);
    }

    @Test
    void getCall() {
        ParamMap param = new ParamMap();


        String path = "/api/v5/asset/convert/currencies";

        // Param -> Open API -> JsonObject
        JsonObject jsonObject =  commonService.getCall(param,path);
        System.out.println(jsonObject);
    }

}