package org.okxbrokerdemo.service;

import org.okxbrokerdemo.service.entry.APIRequestPayload;
import org.okxbrokerdemo.APIKeyHolder;

import java.io.IOException;
import java.util.Map;

public class Account {
    private APIKeyHolder apiKeyHolder;
    private String baseURL = "https://www.okx.com";

    public Account(){

    }

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public Map<String,Object> getBalance(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/balance",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getPositions(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/positions",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getPositionsHistory(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/positions-history",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getPositionsRisk(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/account-position-risk",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getBills(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/bills",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getBillsArchive(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/bills-archive",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getConfig(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/config",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> setPositionMode(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/account/set-position-mode",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> setLeverage(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/account/set-leverage",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getMaxSize(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/max-size",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getMaxAvaliableSize(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/max-avail-size",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> marginBalance(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/account/position/margin-balance",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getleverageInfo(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/leverage-info",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getMaxLoan(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/max-loan",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getTradeFee(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/trade-fee",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getInterestAccrued(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/interest-accrued",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getInterestRate(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/interest-rate",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> setGreeks(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/account/set-greeks",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> setIsolatedMode(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/account/set-isolated-mode",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getMaxWithdrawal(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/max-withdrawal",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getRiskState(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/risk-state",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> borrowRepay(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/account/borrow-repay",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getBorrowRepayHistory(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/borrow-repay-history",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getInterestLimits(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/interest-limits",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> simulatedMargin(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("POST","/api/v5/account/simulated_margin",apiRequestPayload,isSimluate);
        return  result;
    }

    public Map<String,Object> getGreeks(APIRequestPayload apiRequestPayload, boolean isSimluate) throws IOException {
        CommonAPICaller<APIRequestPayload,Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        Map<String,Object> result = commonAPICaller.requestAPI("GET","/api/v5/account/greeks",apiRequestPayload,isSimluate);
        return  result;
    }

}
