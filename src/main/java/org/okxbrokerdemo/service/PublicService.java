package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/17  6:21 AM
 **/
public class PublicService {

    String ApiUrl;
    public boolean isSimulate;
    APIKeyHolder apiKeyHolder;
    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public PublicService(APIKeyHolder apiKeyHolder) {
        this.ApiUrl = "https://www.okx.com";
        this.isSimulate = true;
        this.apiKeyHolder = apiKeyHolder;
        commonAPICaller = new CommonAPICaller<>(this.ApiUrl, this.apiKeyHolder, isSimulate);
    }

    public PublicService(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }


    public <T> List<T> getInstruments(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/public/instruments", clazz);
    }

    public <T> List<T> getDeliveryExerciseHistory(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/public/delivery-exercise-history", clazz);
    }

    public <T> List<T> getOpenInterest(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/public/open-interest", clazz);
    }

    public <T> T getFundingRate(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/public/funding-rate", clazz);
    }

    public <T> List<T> getFundingRateHistory(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/public/funding-rate-history", clazz);
    }

    public <T> T getPriceLimit(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/public/price-limit", clazz);
    }

    public <T> List<T> getOptSummary(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/public/opt-summary", clazz);
    }

    public <T> T getEstimatedPrice(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/public/estimated-price", clazz);
    }

    public <T> T getSystemTime(Class<T> clazz) {
        return commonAPICaller.execute(() -> "{}", "GET", "/api/v5/public/time", clazz);
    }

    public <T> List<T> getLiquidationOrders(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/public/liquidation-orders", clazz);
    }

    public <T> List<T> getMarkPrice(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/public/mark-price", clazz);
    }

    public <T> List<T> getPositionTiers(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/public/position-tiers", clazz);
    }

    public <T> List<T> getInterestRateLoanQuota(Class<T> clazz) {
        return commonAPICaller.listExecute(() -> "{}", "GET", "/api/v5/public/interest-rate-loan-quota", clazz);
    }

    public <T> List<T> getVIPInterestRateLoanQuota(Class<T> clazz) {
        return commonAPICaller.listExecute(() -> "{}", "GET", "/api/v5/public/vip-interest-rate-loan-quota", clazz);
    }

    public <T> T getUnderlying(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/public/underlying", clazz);
    }

    public <T> T getInsuranceFund(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/public/insurance-fund", clazz);
    }

    public <T> T convertContractCoin(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/public/convert-contract-coin", clazz);
    }


}
