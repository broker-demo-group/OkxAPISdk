package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
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

//    String URL = "https://www.okx.com";
//    boolean isSimulate = true;
    APIKeyHolder apiKeyHolder = new APIKeyHolder();
    {
        apiKeyHolder.init("","","");
    }

    PublicService publicService = new PublicService(apiKeyHolder);

    @Test
    void getInstruments() {
        ParamMap param = new ParamMap();
        param.add("instType","SPOT");
        List<JsonObject> result = this.publicService.getInstruments(param, JsonObject.class);
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
        List<JsonObject> result = this.publicService.getDeliveryExerciseHistory(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getOpenInterest() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("uly","BTC-USD");
        List<JsonObject> result = this.publicService.getOpenInterest(param,JsonObject.class);
        System.out.println(result);
    }


    @Test
    void getFundingRate() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USD-SWAP");
        JsonObject result = this.publicService.getFundingRate(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getFundingRateHistory() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USD-SWAP");
        param.add("limit","3");
        List<JsonObject> result = this.publicService.getFundingRateHistory(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getPriceLimit() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USD-SWAP");
        JsonObject result = this.publicService.getPriceLimit(param,JsonObject.class);
        System.out.println(result);
    }


    @Test
    void getOptSummary() {
        ParamMap param = new ParamMap();
        param.add("uly","BTC-USD");
        List<JsonObject> result = this.publicService.getOptSummary(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getEstimatedPrice() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USD-220729-33000-P");
        JsonObject result = this.publicService.getEstimatedPrice(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getSystemTime() {
        System.out.println(this.publicService.getSystemTime(JsonObject.class));
    }

    @Test
    void getLiquidationOrders() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("uly","BTC-USDT");
        param.add("alias","this_week");
        param.add("state","filled");
        List<JsonObject> result = this.publicService.getLiquidationOrders(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getMarkPrice() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("uly","BTC-USDT");
        List<JsonObject> result = this.publicService.getMarkPrice(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getPositionTiers() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("tdMode","cross");
        param.add("uly","BTC-USDT");
        List<JsonObject> result = this.publicService.getPositionTiers(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getInterestRateLoanQuota() {
        System.out.println(this.publicService.getInterestRateLoanQuota(JsonObject.class));
    }

    @Test
    void getVIPInterestRateLoanQuota() {
        System.out.println(this.publicService.getVIPInterestRateLoanQuota(JsonObject.class));
    }

    @Test
    void getUnderlying() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        //todo 响应的body为 list(list()) 这样的格式
        System.out.println(this.publicService.getUnderlying(param, LinkedList.class));
    }

    @Test
    void getInsuranceFund() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        param.add("uly","BTC-USDT");
        JsonObject result = this.publicService.getInsuranceFund(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void convertContractCoin() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USD-SWAP");
        param.add("sz","10");
        param.add("px","33");
        JsonObject result = this.publicService.convertContractCoin(param,JsonObject.class);
        System.out.println(result);
    }
}