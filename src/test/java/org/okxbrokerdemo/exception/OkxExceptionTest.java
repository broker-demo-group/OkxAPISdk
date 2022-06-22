package org.okxbrokerdemo.exception;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;
import org.okxbrokerdemo.service.entry.ParamMap;

class OkxExceptionTest {
    Client client = OkxSDK.getClient("",
            "", "", true);

    @Test
    public void test2(){
        ParamMap param = new ParamMap();
        param.add("transId", "whosyourdaddy"); // 一个明显错误的transId
        try{
            JsonObject json = client.getAsset().getAssetTransferState(param, JsonObject.class);
            System.out.println(json);
        }catch (OkxApiException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test3(){
        ParamMap param = new ParamMap();
        try{
            // normal
            param.add("fromCcy", "BTC");
            param.add("toCcy", "USDT");
            JsonObject convertCurrencyPair = client.getAssetConvert().getConvertCurrencyPair(param, JsonObject.class);
            System.out.println(convertCurrencyPair);

            // error code
            param = new ParamMap();
            param.add("fromCcy", "USDT");
            param.add("toCcy", "USDT");
            convertCurrencyPair = client.getAssetConvert().getConvertCurrencyPair(param, JsonObject.class);
            System.out.println(convertCurrencyPair);
        }catch (OkxApiException e){
            System.out.println(e.getMessage());
        }
    }

}