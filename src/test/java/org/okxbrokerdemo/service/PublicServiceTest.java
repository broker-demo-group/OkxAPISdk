package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;
import org.okxbrokerdemo.service.entry.ParamMap;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/17  6:31 AM
 **/
class PublicServiceTest {


    Client client = OkxSDK.getClient("","","", true);

    @Test
    void getInstruments() {
        ParamMap param = new ParamMap();
        param.add("instType","SPOT");
        List<JsonObject> result = client.getPublicService().getInstruments(param, JsonObject.class);
        System.out.println(result);
    }

    @Test
    void setSimulate() {
    }

    @Test
    void getDeliveryExerciseHistory() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("uly","BTC-USD");
        List<JsonObject> result = client.getPublicService().getDeliveryExerciseHistory(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getOpenInterest() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("uly","BTC-USD");
        List<JsonObject> result = client.getPublicService().getOpenInterest(param,JsonObject.class);
        System.out.println(result);
    }


    @Test
    void getFundingRate() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USD-SWAP");
        JsonObject result = client.getPublicService().getFundingRate(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getFundingRateHistory() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USD-SWAP");
        param.add("limit","3");
        List<JsonObject> result = client.getPublicService().getFundingRateHistory(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getPriceLimit() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USD-SWAP");
        JsonObject result = client.getPublicService().getPriceLimit(param,JsonObject.class);
        System.out.println(result);
    }


    @Test
    void getOptSummary() {
        ParamMap param = new ParamMap();
        param.add("uly","BTC-USD");
        List<JsonObject> result = client.getPublicService().getOptSummary(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getEstimatedPrice() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USD-220729-33000-P");
        JsonObject result = client.getPublicService().getEstimatedPrice(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getSystemTime() {
        System.out.println(client.getPublicService().getSystemTime(JsonObject.class));
    }

    @Test
    void getLiquidationOrders() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("uly","BTC-USDT");
        param.add("alias","this_week");
        param.add("state","filled");
        List<JsonObject> result = client.getPublicService().getLiquidationOrders(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getMarkPrice() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("uly","BTC-USDT");
        List<JsonObject> result = client.getPublicService().getMarkPrice(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getPositionTiers() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("tdMode","cross");
        param.add("uly","BTC-USDT");
        List<JsonObject> result = client.getPublicService().getPositionTiers(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getInterestRateLoanQuota() {
        System.out.println(client.getPublicService().getInterestRateLoanQuota(JsonObject.class));
    }

    @Test
    void getVIPInterestRateLoanQuota() {
        System.out.println(client.getPublicService().getVIPInterestRateLoanQuota(JsonObject.class));
    }

    @Test
    void getUnderlying() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        //todo 响应的body为 list(list()) 这样的格式
        System.out.println(client.getPublicService().getUnderlying(param, LinkedList.class));
    }

    @Test
    void getInsuranceFund() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("uly","BTC-USDT");
        JsonObject result = client.getPublicService().getInsuranceFund(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void convertContractCoin() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USD-SWAP");
        param.add("sz","10");
        param.add("px","33");
        JsonObject result = client.getPublicService().convertContractCoin(param,JsonObject.class);
        System.out.println(result);
    }
}