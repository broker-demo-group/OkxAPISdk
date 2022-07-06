package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Account {
    private String baseURL = "https://www.okx.com";

    public Account(){

    }
    private CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;;

    public CommonAPICaller<APIRequestPayload, JsonObject> getCommonAPICaller() {
        return commonAPICaller;
    }

    public void setCommonAPICaller(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public <T> List<T> getBalance(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/balance", clazz);
        return result;
    }

    public <T> List<T> getPositions(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/positions", clazz);
        return result;
    }

    public <T> List<T> getPositionsHistory(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/positions-history", clazz);
        return result;
    }

    public <T> T getPositionsRisk(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        T result = commonAPICaller.execute(apiRequestPayload, "GET", "/api/v5/account/account-position-risk", clazz);
        return result;
    }

    public <T> List<T> getBills(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/bills", clazz);
        return result;
    }

    public <T> List<T> getBillsArchive(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/bills-archive", clazz);
        return result;
    }

    public <T> T getConfig(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        //CommonAPICaller<APIRequestPayload,<T> List<T>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        T result = commonAPICaller.execute(apiRequestPayload, "GET", "/api/v5/account/config", clazz);
        return result;
    }

    public <T> T setPositionMode(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        //CommonAPICaller<APIRequestPayload,<T> List<T>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/account/set-position-mode", clazz);
        return result;
    }

    public <T> T setLeverage(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/account/set-leverage", clazz);
        return result;
    }

    public <T> List<T> getMaxSize(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        //CommonAPICaller<APIRequestPayload,<T> List<T>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/max-size", clazz);
        return result;
    }

    public <T> List<T> getMaxAvaliableSize(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        //CommonAPICaller<APIRequestPayload,<T> List<T>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/max-avail-size", clazz);
        return result;
    }

    public <T> T marginBalance(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        //CommonAPICaller<APIRequestPayload,<T> List<T>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/account/position/margin-balance", clazz);
        return result;
    }

    public <T> List<T> getleverageInfo(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        //CommonAPICaller<APIRequestPayload,<T> List<T>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/leverage-info", clazz);
        return result;
    }

    public <T> List<T> getMaxLoan(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/max-loan", clazz);
        return result;
    }

    public <T> List<T> getTradeFee(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/trade-fee", clazz);
        return result;
    }

    public <T> List<T> getInterestAccrued(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        //CommonAPICaller<APIRequestPayload,<T> List<T>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/interest-accrued", clazz);
        return result;
    }

    public <T> List<T> getInterestRate(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/interest-rate", clazz);
        return result;
    }

    public <T> T setGreeks(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/account/set-greeks", clazz);
        return result;
    }

    public <T> T setIsolatedMode(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/account/set-isolated-mode", clazz);
        return result;
    }

    public <T> List<T> getMaxWithdrawal(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/max-withdrawal", clazz);
        return result;
    }

    public <T> T getRiskState(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "GET", "/api/v5/account/risk-state", clazz);
        return result;
    }

    public <T> T borrowRepay(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/account/borrow-repay", clazz);
        return result;
    }

    public <T> List<T> getBorrowRepayHistory(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/borrow-repay-history", clazz);
        return result;
    }

    public <T> List<T> getInterestLimits(APIRequestPayload apiRequestPayload, Class<T> clazz) {

        List<T> result = commonAPICaller.listExecute(apiRequestPayload, "GET", "/api/v5/account/interest-limits", clazz);
        return result;
    }

    public <T> T simulatedMargin(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        T result = commonAPICaller.execute(apiRequestPayload, "POST", "/api/v5/account/simulated_margin", clazz);
        return result;
    }

    public <T> T getGreeks(APIRequestPayload apiRequestPayload, Class<T> clazz) {
        //CommonAPICaller<APIRequestPayload,<T> List<T>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        T result = commonAPICaller.execute(apiRequestPayload, "GET", "/api/v5/account/greeks", clazz);
        return result;
    }

}
