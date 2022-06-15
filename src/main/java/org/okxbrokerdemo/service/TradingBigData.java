package org.okxbrokerdemo.service;

import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.Map;

public class TradingBigData {
    private String baseURL = "https://www.okx.com";
    private APIKeyHolder apiKeyHolder;

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }

    public Map<String,Object> getSupportCoins(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rubik/stat/trading-data/support-coin",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getTakerVolume(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rubik/stat/taker-volume",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getLoanRatio(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rubik/stat/margin/loan-ratio",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getContractsLongShortAccountRatio(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rubik/stat/contracts/long-short-account-ratio",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getContractsOpenInterestVolume(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rubik/stat/contracts/open-interest-volume",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getOptionOpenInterestVolume(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rubik/stat/option/open-interest-volume",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getOptionOpenInterestVolumeRatio(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rubik/stat/option/open-interest-volume-ratio",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getOptionOpenInterestVolumeExpiry(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rubik/stat/option/open-interest-volume-expiry",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getOptionOpenInterestVolumeStrike(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rubik/stat/option/open-interest-volume-strike",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getOptionTakerBlockVolume(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/rubik/stat/option/taker-block-volume",apiRequestPayload,isSimluate);
        return  result;
    }

}
