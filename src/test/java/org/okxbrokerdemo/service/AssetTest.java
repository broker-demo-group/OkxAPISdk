package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;
import org.okxbrokerdemo.service.entry.AssetBalance;
import org.okxbrokerdemo.service.entry.ParamMap;

import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  5:16 PM
 **/
class AssetTest {
    Client client = OkxSDK.getClient("",
            "",
            "",true);
    @BeforeEach
    void setUp() {

    }




    @Test
    void getAccountPosition() {
        JsonObject getAccountPosition = client.getAsset().getAccountPosition(JsonObject.class);
        System.out.println(getAccountPosition);
    }

    @Test
    void getAssetValuation() {
        JsonObject  result= client.getAsset().getAssetValuation(JsonObject.class);
        System.out.println(result);

    }

    @Test
    void testGetAssetValuation() {
        ParamMap param = new ParamMap();
        param.add("cyy","BTC");
        JsonObject  result= client.getAsset().getAssetValuation(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void assetTransfer() throws InterruptedException {
        ParamMap param = new ParamMap();
        param.add("ccy","BTC");
        param.add("amt","1");
        param.add("from","18"); // 6:funding account 18: trading account
        param.add("to","6");
        param.add("clientId","whosyourdaddy");
        JsonObject result;
        result = client.getAsset().assetTransfer(param, JsonObject.class);
        System.out.println(result);
        this.testGetAssetValuation();
        Thread.sleep(1100);
        param.add("from","6");
        param.add("to","18");
        result = client.getAsset().assetTransfer(param, JsonObject.class);
        System.out.println(result);
        this.testGetAssetValuation();
    }


    @Test
    void setSimulate() {
    }

    @Test
    void getCurrencies() {
        List<JsonObject> currencies = client.getAsset().getCurrencies(JsonObject.class);
        System.out.println(currencies);
    }

    @Test
    void getAssetBalanceListWithParam() {
        ParamMap param = new ParamMap();
        param.add("ccy","BTC,ETH");
        List<JsonObject> AssetBalance = client.getAsset().getAssetBalance(param, JsonObject.class);
        System.out.println(AssetBalance);
    }

    @Test
    void getAssetBalanceList() {
        List<AssetBalance> AssetBalance = client.getAsset().getAssetBalance(()->"{}", AssetBalance.class);
        System.out.println(AssetBalance);

    }

    @Test
    void getAssetTransferState() {
        ParamMap param = new ParamMap();
        param.add("transId","248128445");
        JsonObject json = client.getAsset().getAssetTransferState(param,JsonObject.class);
        System.out.println(json);
    }

    @Test
    void getAssetBills() {
        List<JsonObject> result = client.getAsset().getAssetBills(()->"{}", JsonObject.class);
        System.out.println(result);
    }
}