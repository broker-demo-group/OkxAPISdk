package org.okxbrokerdemo;


import com.google.gson.JsonObject;
import org.okxbrokerdemo.service.*;
import org.okxbrokerdemo.utils.APIKeyHolder;

public class OkxSDK {

    public OkxSDK() {
    }


    private static String baseURL = "https://www.okx.com";

    public static Client buildClient(APIKeyHolder apiKeyHolder, Client client, boolean isSimulate) {
        CommonAPICaller<APIRequestPayload, JsonObject> commonAPICallerJSON = new CommonAPICaller<>(baseURL,
                apiKeyHolder, isSimulate);
        // TODO Trade Account 等这些service 不传 apiKeyholder
        client.setApiKeyHolder(apiKeyHolder);
        Trade trade = new Trade();
        trade.setApiKeyHolder(apiKeyHolder);
        trade.setCommonAPICaller(commonAPICallerJSON);
        client.setTrade(trade);


        Account account = new Account();
        account.setCommonAPICaller(commonAPICallerJSON);

        SubAccount subAccount = new SubAccount();
        subAccount.setCommonAPICaller(commonAPICallerJSON);

        BulkTrade bulkTrade = new BulkTrade();
        bulkTrade.setCommonAPICaller(commonAPICallerJSON);

        Status status = new Status();
        status.setApiKeyHolder(apiKeyHolder);
        status.setCommonAPICaller(commonAPICallerJSON);

        TradingBigData tradingBigData = new TradingBigData();
        tradingBigData.setCommonAPICaller(commonAPICallerJSON);

        client.setAccount(account);
        client.setSubAccount(subAccount);
        client.setStatus(status);
        client.setBulkTrade(bulkTrade);
        client.setTradingBigData(tradingBigData);

        client.setAsset(new Asset(commonAPICallerJSON));
        client.setAssetConvert(new AssetConvert(commonAPICallerJSON));
        client.setPublicService(new PublicService(commonAPICallerJSON));
        client.setMarket(new Market(commonAPICallerJSON));
        client.setCommonService(new CommonService(commonAPICallerJSON));
        client.setGrid(new Grid(commonAPICallerJSON));
        client.setBrokerService(new BrokerService(commonAPICallerJSON));


        return client;
    }


    public static Client getClient(String apiKey, String secertKey, String passPhrase, boolean isSimluate) {
        Client client = new Client();
        APIKeyHolder apiKeyHolder = new APIKeyHolder();
        apiKeyHolder.init(apiKey, secertKey, passPhrase);
        return buildClient(apiKeyHolder, client, isSimluate);
    }

    public static Client getClient(String accessToken, boolean isSimluate) {
        Client client = new Client();
        APIKeyHolder apiKeyHolder = new APIKeyHolder();
        apiKeyHolder.init(accessToken);
        return buildClient(apiKeyHolder, client, isSimluate);
    }

    public static String getBaseURL() {
        return baseURL;
    }

    public static void setBaseURL(String baseURL) {
        OkxSDK.baseURL = baseURL;
    }
}
