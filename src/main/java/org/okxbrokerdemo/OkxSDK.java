package org.okxbrokerdemo;


import com.google.gson.JsonObject;
import org.okxbrokerdemo.service.*;
import org.okxbrokerdemo.utils.APIKeyHolder;

import java.util.Map;

public class OkxSDK {

    public OkxSDK(){
    }
    private static String baseURL = "https://www.okx.com";
    public static Client buildClient(APIKeyHolder apiKeyHolder, Client client){

        CommonAPICaller<APIRequestPayload, Map<String,Object>> commonAPICaller = new CommonAPICaller<>(baseURL,apiKeyHolder);
        CommonAPICaller<APIRequestPayload, JsonObject> commonAPICallerJSON = new CommonAPICaller<>(baseURL,apiKeyHolder);
        client.setApiKeyHolder(apiKeyHolder);
        Trade trade = new Trade();
        trade.setApiKeyHolder(apiKeyHolder);
        trade.setCommonAPICaller(commonAPICaller);

        client.setTrade(trade);
        Asset asset = new Asset(apiKeyHolder,commonAPICallerJSON);
        AssetConvert assetConvert = new AssetConvert(apiKeyHolder,commonAPICallerJSON);


        Account account = new Account();
        account.setApiKeyHolder(apiKeyHolder);
        account.setCommonAPICaller(commonAPICaller);

        SubAccount subAccount = new SubAccount();
        subAccount.setApiKeyHolder(apiKeyHolder);
        subAccount.setCommonAPICaller(commonAPICaller);


        BulkTrade bulkTrade = new BulkTrade();
        bulkTrade.setApiKeyHolder(apiKeyHolder);
        bulkTrade.setCommonAPICaller(commonAPICaller);

        Status status = new Status();
        status.setApiKeyHolder(apiKeyHolder);
        status.setCommonAPICaller(commonAPICaller);

        TradingBigData tradingBigData = new TradingBigData();
        tradingBigData.setApiKeyHolder(apiKeyHolder);
        tradingBigData.setCommonAPICaller(commonAPICaller);

        client.setAsset(asset);
        client.setAssetConvert(assetConvert);
        client.setAccount(account);
        client.setSubAccount(subAccount);
        client.setPublicService(new PublicService(apiKeyHolder,commonAPICallerJSON));
        client.setMarket(new Market(apiKeyHolder,commonAPICallerJSON));
        client.setStatus(status);
        client.setCommonService(new CommonService(apiKeyHolder));
        client.setBulkTrade(bulkTrade);
        client.setTradingBigData(tradingBigData);

        return client;
    }



    public static Client getClient(String apiKey,String secertKey,String passPhrase,boolean isSimluate){
        Client client= new Client();
        APIKeyHolder apiKeyHolder = new APIKeyHolder();
        apiKeyHolder.init(apiKey,secertKey,passPhrase);

        return buildClient(apiKeyHolder,client);
    }
    public static Client getClient(String accessToken,boolean isSimluate){
        Client client= new Client();
        APIKeyHolder apiKeyHolder = new APIKeyHolder();
        apiKeyHolder.init(accessToken);
        return buildClient(apiKeyHolder,client);

    }
}
