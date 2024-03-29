package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;
import org.okxbrokerdemo.service.entry.AssetBalance;
import org.okxbrokerdemo.service.entry.ParamMap;
import org.okxbrokerdemo.service.entry.Quote;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.util.List;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/14  9:40 AM
 **/
class CommonServiceTest {
    Client client;
    {
        this.client = OkxSDK.getClient("","","", true);
    }


    @Test
    void postExecute() {
        ParamMap param = new ParamMap();
        param.add("baseCcy", "ETH");
        param.add("quoteCcy", "USDT");
        param.add("side", "buy");
        param.add("rfqSz", "1");
        param.add("rfqSzCcy", "USDT");
//        param.add("clQReqId", "greedisisgood");

        String path = "/api/v5/asset/convert/estimate-quote";

        // Param -> Open API -> JsonObject ->POJO
        Quote quote = client.getCommonService().postExecute(param,path,Quote.class);
        System.out.println(quote);


        // Param -> Open API -> JsonObject
        JsonObject jsonObject =  client.getCommonService().postExecute(param,path,JsonObject.class);
        System.out.println(jsonObject);
    }

    @Test
    void getExecute(){
        String path = "/api/v5/public/time";
        JsonObject result = client.getCommonService().getExecute(new ParamMap(), path,JsonObject.class);
    }

    @Test
    void postListExecute() {
    }

    @Test
    void getListExecute() {
        ParamMap param = new ParamMap();


        String path = "/api/v5/asset/convert/currencies";
        // Param -> Open API -> List<JsonObject>
        List<JsonObject> result =  client.getCommonService().getListExecute(param,path,JsonObject.class);
        System.out.println(result);


        path = "/api/v5/asset/balances";
        //Param -> Open API -> List<T>
        List<AssetBalance> AssetBalanceList = client.getCommonService().getListExecute(()->"{}",path, AssetBalance.class);
        System.out.println(AssetBalanceList);
    }
}