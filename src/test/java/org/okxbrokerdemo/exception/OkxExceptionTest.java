package org.okxbrokerdemo.exception;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;
import org.okxbrokerdemo.service.entry.AssetBalance;
import org.okxbrokerdemo.service.entry.ParamMap;
import org.okxbrokerdemo.service.entry.Quote;

import java.util.List;

class OkxExceptionTest {
    Client client = OkxSDK.getClient("bd98f096-eed5-4dee-949e-a70de57f93ed",
            "1D34C75FA4D8D164DBE3034D91762A71", "Zbw@4455665585", true);

    /**
     * 服务器正常，返回 error code
    * 400 {"code":"50014","data":[],"msg":"Parameter transId cant be empty."}
    * */
    @Test
    public void test2(){
        ParamMap param = new ParamMap();
//        param.add("transId", "whosyourdaddy"); // 一个明显错误的transId
        param.add("transId3", "whosyourdaddy"); // 一个明显错误的transId
        try{
            JsonObject json = client.getAsset().getAssetTransferState(param, JsonObject.class);
            System.out.println(json);
        }catch (OkxApiException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 服务器异常 http response code: 500
     * errorBody:{"code":500,"data":{},"detailMsg":"",
     * "error_code":"500","error_message":"Internal Server Error","msg":"Internal Server Error"}
     * */

    @Test
    public void test2_1(){
        ParamMap param = new ParamMap();
        param.add("transId", "whosyourdaddy"); // 一个明显错误的transId
//        param.add("transId3", "whosyourdaddy"); // 必须的parameter 不存在
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
    @Test
    public  void test4(){
        String path = "/api/v5/asset/balances";
        //Param -> Open API -> List<T>
        ParamMap param = new ParamMap();
        param.add("ccy",",BTC,aBSd,ETH");
        List<AssetBalance> AssetBalanceList = client.getCommonService().getListExecute(param,path, AssetBalance.class);
        System.out.println(AssetBalanceList);
    }

    /**
     * data[null] 很少见，是否可以统一？
     * execute:{"code":"0","msg":"","data":[null]}
     * */
    @Test
    public void test5(){
        System.out.println(client.getMarket().getMarketOpenOracle(new ParamMap(),JsonObject.class));
    }

}