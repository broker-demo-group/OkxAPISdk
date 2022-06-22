package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;
import org.okxbrokerdemo.service.entry.ParamMap;
import org.okxbrokerdemo.service.entry.Quote;

import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  5:16 PM
 **/
class AssetConvertTest {
    Client client = OkxSDK.getClient("",
            "",
            "",true);
    @BeforeEach
    void setUp() {

    }

    @Test
    void getConvertCurrencies() {
        List<JsonObject> accountBalance = client.getAssetConvert().getConvertCurrencies(()->"{}",JsonObject.class);
        System.out.println(accountBalance);
    }

    @Test
    void getConvertCurrencyPair() {
        ParamMap param = new ParamMap();
        param.add("fromCcy","BTC");
        param.add("toCcy","USDT");
        JsonObject convertCurrencyPair = client.getAssetConvert().getConvertCurrencyPair(param,JsonObject.class);
        System.out.println(convertCurrencyPair);
    }

    @Test
    void convertEstimateQuote() {
        ParamMap param = new ParamMap();
        param.add("baseCcy", "BTC");
        param.add("quoteCcy", "USDT");
        param.add("side", "sell");
        param.add("rfqSz", "0.5");
        param.add("rfqSzCcy", "BTC");
//        param.add("clQReqId", "greedisisgood");

        Quote quote = client.getAssetConvert().convertEstimateQuote(param,Quote.class);
        System.out.println(quote);
//        JsonObject
        JsonObject jsonObject = client.getAssetConvert().convertEstimateQuote(param,JsonObject.class);
        System.out.println(jsonObject);
    }

    Quote getQuote(){
        ParamMap param = new ParamMap();
        param.add("baseCcy", "BTC");
        param.add("quoteCcy", "USDT");
        param.add("side", "sell");
        param.add("rfqSz", "0.01");
        param.add("rfqSzCcy", "BTC");
//        param.add("clQReqId", "whosyourdaddy");
        Quote quote = client.getAssetConvert().convertEstimateQuote(param,Quote.class);
        System.out.println(quote);
        return quote;
    }
    @Test
    void convertTrade(){
        Quote quote = this.getQuote();
        ParamMap param = new ParamMap();
        param.add("quoteId", quote.getQuoteId());
        param.add("baseCcy", quote.getBaseCcy());
        param.add("quoteCcy",quote.getQuoteCcy());
        param.add("side", quote.getSide());
        param.add("sz", quote.getRfqSz());
        param.add("szCcy", quote.getRfqSzCcy());
//        param.add("clQReqId", quote.getClQReqId());

        System.out.println(param.getPayLoadJson());
        JsonObject r = client.getAssetConvert().convertTrade(param,JsonObject.class);
        System.out.println(r);
    }

    @Test
    void convertHistory() {
        List<JsonObject> r = client.getAssetConvert().convertHistory(()->"{}",JsonObject.class);
        System.out.println(r);
    }
}