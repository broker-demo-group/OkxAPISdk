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
    String APIUrl ;
    public boolean isSimulate;
    // TODO 这里 [ApiKeyHolder]==>Client->service->commonAPICaller
    APIKeyHolder apiKeyHolder;

    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public Market(String APIUrl, boolean isSimulate, APIKeyHolder apiKeyHolder) {
        this.APIUrl = APIUrl;
        this.isSimulate = isSimulate;
        this.apiKeyHolder = apiKeyHolder;
        commonAPICaller = new CommonAPICaller<>(APIUrl,this.apiKeyHolder );
    }

    public Market(APIKeyHolder apiKeyHolder) {
        this.APIUrl = "http://www.okx.com";
        this.isSimulate = true;
        this.apiKeyHolder = apiKeyHolder;
        commonAPICaller = new CommonAPICaller<>(APIUrl,this.apiKeyHolder );
    }

    public Market(APIKeyHolder apiKeyHolder,CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.APIUrl = "http://www.okx.com";
        this.isSimulate = true;
        this.apiKeyHolder = apiKeyHolder;
        this.commonAPICaller = commonAPICaller;
    }

    public <R> List<R> getMarketTickers(APIRequestPayload param, Class<R> clazz){
        return  listExecute(param,"GET","/api/v5/market/tickers",clazz);
    }

    public <R> R getMarketTicker(APIRequestPayload param, Class<R> clazz){
        return  execute(param,"GET","/api/v5/market/ticker",clazz);
    }
    public <R> List<R> getMarketIndexTickers(APIRequestPayload param, Class<R> clazz){
        return  listExecute(param,"GET","/api/v5/market/index-tickers",clazz);
    }
    public <R> List<R> getBooks(APIRequestPayload param, Class<R> clazz){
        return  listExecute(param,"GET","/api/v5/market/books",clazz);
    }
    public <R> List<R> getMarketCandles(APIRequestPayload param, Class<R> clazz){
        return  listExecute(param,"GET","/api/v5/market/candles",clazz);
    }
    public <R> List<R> getMarketHistoryCandles(APIRequestPayload param, Class<R> clazz){
        return  listExecute(param,"GET","/api/v5/market/history-candles",clazz);
    }
    public <R> List<R> getMarketIndexCandles(APIRequestPayload param, Class<R> clazz){
        return  listExecute(param,"GET","/api/v5/market/index-candles",clazz);
    }
    public <R> List<R> getMarketMarkPriceCandles(APIRequestPayload param, Class<R> clazz){
        return  listExecute(param,"GET","/api/v5/market/mark-price-candles",clazz);
    }
    public <R> List<R> getMarketTrades(APIRequestPayload param, Class<R> clazz){
        return  listExecute(param,"GET","/api/v5/market/trades",clazz);
    }
    public <R> List<R> getMarketHistoryTrades(APIRequestPayload param, Class<R> clazz){
        return  listExecute(param,"GET","/api/v5/market/history-trades",clazz);
    }
    public <R> R getMarketPlatform24Volume(APIRequestPayload param, Class<R> clazz){
        return  execute(param,"GET","/api/v5/market/platform-24-volume",clazz);
    }
    public <R> R getMarketOpenOracle(APIRequestPayload param, Class<R> clazz){
        return  execute(param,"GET","/api/v5/market/open-oracle",clazz);
    }
    public <R> R getMarketExchangeRate(APIRequestPayload param, Class<R> clazz){
        return  execute(param,"GET","/api/v5/market/exchange-rate",clazz);
    }

    public <R> R getMarketIndexComponents(APIRequestPayload param, Class<R> clazz){
        return  execute(param,"GET","/api/v5/market/index-components",clazz);
    }

    public <R> List<R> getMarketBlockTickers(APIRequestPayload param, Class<R> clazz){
        return  listExecute(param,"GET","/api/v5/market/block-tickers",clazz);
    }
    public <R> R getMarketBlockTicker(APIRequestPayload param, Class<R> clazz){
        return  execute(param,"GET","/api/v5/market/block-ticker",clazz);
    }



    private <T> T execute(APIRequestPayload param, String method, String path, Class<T> clazz){
        try{
            JsonObject jsonObject = this.commonAPICaller.requestAPI(method,path,param,isSimulate, JsonObject.class);
            System.out.println("execute:"+jsonObject);
            JsonElement dataElement = jsonObject.get("data");

            if(!dataElement.isJsonArray()) {
                //为了一个getMarketIndexComponents case 添加这个判断
                return new Gson().fromJson(dataElement,clazz);
            }
            JsonArray dataList = jsonObject.get("data").getAsJsonArray();
            // TODO 这里本来是考虑list范型的情况，现在此方法不会返回List范型，需要修改
            if(dataList.size() == 0) {
                return clazz.newInstance();
            }else if(dataList.size() == 1){
                JsonElement data = dataList.get(0);
                return new Gson().fromJson(data,clazz);
            }else{
                return new Gson().fromJson(dataList,clazz);
            }
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> List<T> listExecute(APIRequestPayload param, String method, String path, Class<T> clazz) {
        try {
            JsonObject jsonObject = this.commonAPICaller.requestAPI(method, path, param, isSimulate, JsonObject.class);
            System.out.println("listExecute:"+jsonObject);
            JsonArray dataList = jsonObject.get("data").getAsJsonArray();

            if (dataList.size() == 0) {
                return new ArrayList<>();
            } else {
                List<T> list = new ArrayList<>();
                for (final JsonElement element : dataList) {
                    list.add(new Gson().fromJson(element, clazz));
                }
                return list;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
