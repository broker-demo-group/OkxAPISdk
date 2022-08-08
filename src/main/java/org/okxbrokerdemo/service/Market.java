package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/17  11:26 AM
 **/
public class Market {

    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public Market(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }

    public <R> List<R> getMarketTickers(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/market/tickers", clazz);
    }

    public <R> R getMarketTicker(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/market/ticker", clazz);
    }

    public <R> List<R> getMarketIndexTickers(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/market/index-tickers", clazz);
    }

    public <R> List<R> getBooks(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/market/books", clazz);
    }

    public <R> List<R> getMarketCandles(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/market/candles", clazz);
    }

    public <R> List<R> getMarketHistoryCandles(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/market/history-candles", clazz);
    }

    public <R> List<R> getMarketIndexCandles(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/market/index-candles", clazz);
    }

    public <R> List<R> getMarketMarkPriceCandles(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/market/mark-price-candles", clazz);
    }

    public <R> List<R> getMarketTrades(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/market/trades", clazz);
    }

    public <R> List<R> getMarketHistoryTrades(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/market/history-trades", clazz);
    }

    public <R> R getMarketPlatform24Volume(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/market/platform-24-volume", clazz);
    }

    public <R> R getMarketOpenOracle(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/market/open-oracle", clazz);
    }

    public <R> R getMarketExchangeRate(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/market/exchange-rate", clazz);
    }

    public <R> R getMarketIndexComponents(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/market/index-components", clazz);
    }

    public <R> List<R> getMarketBlockTickers(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/market/block-tickers", clazz);
    }


    public <R> R getMarketBlockTicker(APIRequestPayload param, Class<R> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/market/block-ticker", clazz);
    }


}
