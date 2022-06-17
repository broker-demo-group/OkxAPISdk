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
 * @date: 2022/6/17  6:21 AM
 **/
public class PublicService {

    String APIUrl ;
    public boolean isSimulate;
    APIKeyHolder apiKeyHolder;
    CommonAPICaller<APIRequestPayload,JsonObject> commonAPICaller;

    public PublicService(APIKeyHolder apiKeyHolder) {
        this.APIUrl = "https://www.okx.com";
        this.isSimulate = true;
        this.apiKeyHolder = apiKeyHolder;
        commonAPICaller = new CommonAPICaller<>(this.APIUrl, this.apiKeyHolder);
    }



    public <T> List<T> getInstruments(APIRequestPayload param, Class<T> clazz){
        return  listExecute(param,"GET","/api/v5/public/instruments",clazz);
    }

    public <T> List<T> getDeliveryExerciseHistory(APIRequestPayload param, Class<T> clazz){
        return  listExecute(param,"GET","/api/v5/public/delivery-exercise-history",clazz);
    }

    public <T> List<T> getOpenInterest(APIRequestPayload param, Class<T> clazz){
        return  listExecute(param,"GET","/api/v5/public/open-interest",clazz);
    }
    public <T> T getFundingRate(APIRequestPayload param, Class<T> clazz){
        return execute(param,"GET","/api/v5/public/funding-rate",clazz);
    }

    public <T> List<T> getFundingRateHistory(APIRequestPayload param, Class<T> clazz){
        return listExecute(param,"GET","/api/v5/public/funding-rate-history",clazz);
    }
    public <T> T getPriceLimit(APIRequestPayload param, Class<T> clazz){
        return execute(param,"GET","/api/v5/public/price-limit",clazz);
    }
    public <T> List<T> getOptSummary(APIRequestPayload param, Class<T> clazz){
        return listExecute(param,"GET","/api/v5/public/opt-summary",clazz);
    }
    public <T> T getEstimatedPrice(APIRequestPayload param, Class<T> clazz){
        return execute(param,"GET","/api/v5/public/estimated-price",clazz);
    }

    public <T> T getSystemTime( Class<T> clazz){
        return execute(()->"{}","GET","/api/v5/public/time",clazz);
    }

    public <T> List<T> getLiquidationOrders(APIRequestPayload param, Class<T> clazz){
        return listExecute(param,"GET","/api/v5/public/liquidation-orders",clazz);
    }
    public <T> List<T> getMarkPrice(APIRequestPayload param, Class<T> clazz){
        return listExecute(param,"GET","/api/v5/public/mark-price",clazz);
    }

    public <T> List<T> getPositionTiers(APIRequestPayload param, Class<T> clazz){
        return listExecute(param,"GET","/api/v5/public/position-tiers",clazz);
    }
    public <T> List<T> getInterestRateLoanQuota(Class<T> clazz){
        return listExecute(()->"{}","GET","/api/v5/public/interest-rate-loan-quota",clazz);
    }
    public <T> List<T> getVIPInterestRateLoanQuota(Class<T> clazz){
        return listExecute(()->"{}","GET","/api/v5/public/vip-interest-rate-loan-quota",clazz);
    }

    public <T> T getUnderlying(APIRequestPayload param,Class<T> clazz){
        return execute(param,"GET","/api/v5/public/underlying",clazz);
    }

    public <T> T getInsuranceFund(APIRequestPayload param,Class<T> clazz){
        return execute(param,"GET","/api/v5/public/insurance-fund",clazz);
    }

    public <T> T convertContractCoin(APIRequestPayload param,Class<T> clazz){
        return execute(param,"GET","/api/v5/public/convert-contract-coin",clazz);
    }




    public void setSimulate(boolean simulate) {
        isSimulate = simulate;
    }

    /**
     * 这里默认JsonObject 的格式为「"code":"1","data" :"","msg":"" 」
     * TODO 后续需要考虑 返回异常码的情况
     * */
    private <T> T execute(APIRequestPayload param, String method, String path, Class<T> clazz){

        try{
            JsonObject jsonObject = this.commonAPICaller.requestAPI(method,path,param,isSimulate, JsonObject.class);
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
