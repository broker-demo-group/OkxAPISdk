package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TradingBigData {
    private String baseURL = "https://www.okx.com";


    private CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;
    public String getBaseURL() {
        return baseURL;
    }

    public CommonAPICaller<APIRequestPayload, JsonObject> getCommonAPICaller() {
        return commonAPICaller;
    }

    public void setCommonAPICaller(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }


    public <T> List<T> getSupportCoins(APIRequestPayload apiRequestPayload, Class<T> clazz) throws IOException {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/rubik/stat/trading-data/support-coin",clazz);
        return  result;
    }

    public <T> List<T> getTakerVolume(APIRequestPayload apiRequestPayload, Class<T> clazz) throws IOException {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/rubik/stat/taker-volume",clazz);
        return  result;
    }

    public <T> List<T> getLoanRatio(APIRequestPayload apiRequestPayload, Class<T> clazz) throws IOException {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/rubik/stat/margin/loan-ratio",clazz);
        return  result;
    }

    public <T> List<T> getContractsLongShortAccountRatio(APIRequestPayload apiRequestPayload, Class<T> clazz) throws IOException {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/rubik/stat/contracts/long-short-account-ratio",clazz);
        return  result;
    }

    public <T> List<T> getContractsOpenInterestVolume(APIRequestPayload apiRequestPayload, Class<T> clazz) throws IOException {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/rubik/stat/contracts/open-interest-volume",clazz);
        return  result;
    }

    public <T> List<T> getOptionOpenInterestVolume(APIRequestPayload apiRequestPayload, Class<T> clazz) throws IOException {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/rubik/stat/option/open-interest-volume",clazz);
        return  result;
    }

    public <T> List<T> getOptionOpenInterestVolumeRatio(APIRequestPayload apiRequestPayload, Class<T> clazz) throws IOException {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/rubik/stat/option/open-interest-volume-ratio",clazz);
        return  result;
    }

    public <T> List<T> getOptionOpenInterestVolumeExpiry(APIRequestPayload apiRequestPayload, Class<T> clazz) throws IOException {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/rubik/stat/option/open-interest-volume-expiry",clazz);
        return  result;
    }

    public <T> List<T> getOptionOpenInterestVolumeStrike(APIRequestPayload apiRequestPayload, Class<T> clazz) throws IOException {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/rubik/stat/option/open-interest-volume-strike",clazz);
        return  result;
    }

    public <T> List<T> getOptionTakerBlockVolume(APIRequestPayload apiRequestPayload, Class<T> clazz) throws IOException {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload,"GET","/api/v5/rubik/stat/option/taker-block-volume",clazz);
        return  result;
    }

}
