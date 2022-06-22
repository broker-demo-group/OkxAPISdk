package org.okxbrokerdemo;


import org.okxbrokerdemo.service.*;
import org.okxbrokerdemo.utils.APIKeyHolder;

public class Client {

    APIKeyHolder apiKeyHolder;
    Grid grid;



    Trade trade;
    Asset asset;
    Account account;
    SubAccount subAccount;
    AssetConvert assetConvert;
    Market market;
    Status status;
    BulkTrade bulkTrade;
    PublicService publicService;
    CommonService commonService;

    TradingBigData tradingBigData;

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
    public TradingBigData getTradingBigData() {
        return tradingBigData;
    }

    public void setTradingBigData(TradingBigData tradingBigData) {
        this.tradingBigData = tradingBigData;
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public BulkTrade getBulkTrade() {
        return bulkTrade;
    }

    public void setBulkTrade(BulkTrade bulkTrade) {
        this.bulkTrade = bulkTrade;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public PublicService getPublicService() {
        return publicService;
    }

    public void setPublicService(PublicService publicService) {
        this.publicService = publicService;
    }

    public CommonService getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public SubAccount getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
    }


    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public AssetConvert getAssetConvert() {
        return assetConvert;
    }

    public void setAssetConvert(AssetConvert assetConvert) {
        this.assetConvert = assetConvert;
    }


    public Client(){

    }

    public APIKeyHolder getApiKeyHolder() {
        return apiKeyHolder;
    }

    public void setApiKeyHolder(APIKeyHolder apiKeyHolder) {
        this.apiKeyHolder = apiKeyHolder;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }
}
