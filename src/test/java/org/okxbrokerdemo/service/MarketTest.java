package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
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
    Market market;
    {
        APIKeyHolder apiKeyHolder = new APIKeyHolder();
        apiKeyHolder.init("","","");
        market = new Market( apiKeyHolder);
    }
    @Test
    void getMarketTickers() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        List<JsonObject> json = market.getMarketTickers(param,JsonObject.class);
        System.out.println(json);
    }



    @Test
    void getMarketTicker() {
        ParamMap param = new ParamMap();
//        param.add("quoteCcy","USDT");
        param.add("instId","BTC-USDT");

        JsonObject result = market.getMarketTicker(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getMarketIndexTickers() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");

        List<JsonObject> result = market.getMarketIndexTickers(param,JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getBooks() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");

        List<JsonObject> result = market.getBooks(param,JsonObject.class);
        System.out.println(result);
    }



    @Test
    void getMarketCandles() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        // k线图 List<List<>> 内层的一个list 代表一个柱子
        List<ArrayList> result = market.getMarketCandles(param, ArrayList.class);
        System.out.println(result);
    }

    @Test
    void getMarketHistoryCandles() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        // k线图 List<List<>> 内层的一个list 代表一个柱子
        List<ArrayList> result = market.getMarketHistoryCandles(param, ArrayList.class);
        System.out.println(result);
    }

    @Test
    void getMarketIndexCandles() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        param.add("bar","1D"); // 日线
        // k线图 List<List<>> 内层的一个list 代表一个柱子 [开盘，最高，最低，收盘]，一个时间单位画一个柱子；
        List<ArrayList> result = market.getMarketIndexCandles(param, ArrayList.class);
        System.out.println(result);
    }

    @Test
    void getMarketMarkPriceCandles() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT-SWAP");
        param.add("bar","1D"); // 日线
        // k线图 List<List<>> 内层的一个list 代表一个柱子 [开盘，最高，最低，收盘]，一个时间单位画一个柱子；
        List<ArrayList> result = market.getMarketMarkPriceCandles(param, ArrayList.class);
        System.out.println(result);
    }

    @Test
    void getMarketTrades() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        param.add("limit","10");
        // 获取最近10个，BTC-USDT 交易成功的交易记录
        List<JsonObject> result = market.getMarketTrades(param, JsonObject.class);
        System.out.println(result);
    }


    @Test
    void getMarketHistoryTrades() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        param.add("limit","10");
        // 获取最近10个，BTC-USDT 交易成功的交易记录
        List<JsonObject> result = market.getMarketHistoryTrades(param, JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getMarketPlatform24Volume() {
        // 平台24小时成交额
        System.out.println(market.getMarketPlatform24Volume(new ParamMap(),JsonObject.class));
    }


    @Test
    void getMarketOpenOracle() {
        // 返回{"code":"0","msg":"","data":[null]} 这里会不会是一bad case?
        System.out.println(market.getMarketOpenOracle(new ParamMap(),JsonObject.class));
    }

    @Test
    void getMarketExchangeRate() {
        System.out.println(market.getMarketExchangeRate(new ParamMap(), JsonObject.class));
    }

    @Test
    void getMarketIndexComponents() {
        ParamMap param = new ParamMap();
        param.add("index","BTC-USDT");
        // todo 这里返回的Json 结构复杂，是后续需要解决的问题
        JsonObject jsonObject = market.getMarketIndexComponents(param,JsonObject.class);
        System.out.println(jsonObject);
    }

    @Test
    void getMarketBlockTickers() {
        ParamMap param = new ParamMap();
        param.add("instType","FUTURES");
        List<JsonObject> result = market.getMarketBlockTickers(param, JsonObject.class);
        System.out.println(result);
    }

    @Test
    void getMarketBlockTicker() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        JsonObject result = market.getMarketBlockTicker(param, JsonObject.class);
        System.out.println(result);
    }
}