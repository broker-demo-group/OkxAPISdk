package org.okxbrokerdemo;


import org.okxbrokerdemo.service.*;

public class OkxSDK {

    public OkxSDK(){

    }

    public static Client buildClient(APIKeyHolder apiKeyHolder, Client client){
        client.setApiKeyHolder(apiKeyHolder);
        Trade trade = new Trade();
        client.setTrade(trade);
        Asset asset = new Asset(apiKeyHolder);
        AssetConvert assetConvert = new AssetConvert(apiKeyHolder);
        client.setAsset(asset);
        client.setAssetConvert(assetConvert);
        Account account = new Account();
        account.setApiKeyHolder(apiKeyHolder);
        SubAccount subAccount = new SubAccount();
        subAccount.setApiKeyHolder(apiKeyHolder);
        client.setAccount(account);
        client.setSubAccount(subAccount);

        client.setPublicService(new PublicService(apiKeyHolder));
        client.setMarket(new Market(apiKeyHolder));
        client.setCommonService(new CommonService(apiKeyHolder));
        return client;
    }



    public static Client getClient(String apiKey,String secertKey,String passPhrase){
        Client client= new Client();
        APIKeyHolder apiKeyHolder = new APIKeyHolder();
        apiKeyHolder.init(apiKey,secertKey,passPhrase);

        return buildClient(apiKeyHolder,client);
    }
    public static Client getClient(String accessToken){
        Client client= new Client();
        APIKeyHolder apiKeyHolder = new APIKeyHolder();
        apiKeyHolder.init(accessToken);
        return buildClient(apiKeyHolder,client);

    }
}
