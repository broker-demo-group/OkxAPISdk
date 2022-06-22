package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;
import org.okxbrokerdemo.service.entry.ParamMap;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/17  11:03 AM
 **/
class MarketTest {
    Client client = OkxSDK.getClient("","","", true);

    @Test
    void getMarketTickers() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        List<JsonObject> json = client.getMarket().getMarketTickers(param,JsonObject.class);
        System.out.println(json);
    }



    @Test
    void getMarketTicker() {
        ParamMap param = new ParamMap();
//        param.add("quoteCcy","USDT");
        param.add("instId","BTC-USDT");

        JsonObject result = client.getMarket().getMarketTicker(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getMarketIndexTickers() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");

        List<JsonObject> result = client.getMarket().getMarketIndexTickers(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getBooks() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");

        List<JsonObject> result = client.getMarket().getBooks(param,JsonObject.class);
        System.out.println(result);
    }



    @Test
    void getMarketCandles() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        // k线图 List<List<>> 内层的一个list 代表一个柱子
        List<ArrayList> result = client.getMarket().getMarketCandles(param, ArrayList.class);
        System.out.println(result);
    }

    @Test
    void getMarketHistoryCandles() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        // k线图 List<List<>> 内层的一个list 代表一个柱子
        List<ArrayList> result = client.getMarket().getMarketHistoryCandles(param, ArrayList.class);
        System.out.println(result);
    }

    @Test
    void getMarketIndexCandles() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        param.add("bar","1D"); // 日线
        // k线图 List<List<>> 内层的一个list 代表一个柱子 [开盘，最高，最低，收盘]，一个时间单位画一个柱子；
        List<ArrayList> result = client.getMarket().getMarketIndexCandles(param, ArrayList.class);
        System.out.println(result);
    }

    @Test
    void getMarketMarkPriceCandles() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT-SWAP");
        param.add("bar","1D"); // 日线
        // k线图 List<List<>> 内层的一个list 代表一个柱子 [开盘，最高，最低，收盘]，一个时间单位画一个柱子；
        List<ArrayList> result = client.getMarket().getMarketMarkPriceCandles(param, ArrayList.class);
        System.out.println(result);
    }

    @Test
    void getMarketTrades() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        param.add("limit","10");
        // 获取最近10个，BTC-USDT 交易成功的交易记录
        List<JsonObject> result = client.getMarket().getMarketTrades(param, JsonObject.class);
        System.out.println(result);
    }


    @Test
    void getMarketHistoryTrades() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        param.add("limit","10");
        // 获取最近10个，BTC-USDT 交易成功的交易记录
        List<JsonObject> result = client.getMarket().getMarketHistoryTrades(param, JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getMarketPlatform24Volume() {
        // 平台24小时成交额
        System.out.println(client.getMarket().getMarketPlatform24Volume(new ParamMap(),JsonObject.class));
    }


    @Test
    void getMarketOpenOracle() {
        // 返回{"code":"0","msg":"","data":[null]} 这里会不会是一bad case?
        System.out.println(client.getMarket().getMarketOpenOracle(new ParamMap(),JsonObject.class));
    }

    @Test
    void getMarketExchangeRate() {
        System.out.println(client.getMarket().getMarketExchangeRate(new ParamMap(), JsonObject.class));
    }

    @Test
    void getMarketIndexComponents() {
        ParamMap param = new ParamMap();
        param.add("index","BTC-USDT");
        // todo 这里返回的Json 结构复杂，是后续需要解决的问题
        JsonObject jsonObject = client.getMarket().getMarketIndexComponents(param,JsonObject.class);
        System.out.println(jsonObject);
    }

    @Test
    void getMarketBlockTickers() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        List<JsonObject> result = client.getMarket().getMarketBlockTickers(param, JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getMarketBlockTicker() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        JsonObject result = client.getMarket().getMarketBlockTicker(param, JsonObject.class);
        System.out.println(result);
    }
}