package org.okxbrokerdemo;


import org.okxbrokerdemo.service.*;
import org.okxbrokerdemo.utils.APIKeyHolder;

public class Client {

    APIKeyHolder apiKeyHolder;
    Trade trade;
    Asset asset;

    Account account;

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

    SubAccount subAccount;

    AssetConvert assetConvert;
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
