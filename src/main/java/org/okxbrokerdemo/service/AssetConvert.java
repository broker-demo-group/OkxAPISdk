package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.okxbrokerdemo.service.entry.APIRequestPayload;
import org.okxbrokerdemo.service.entry.ParamMap;
import org.okxbrokerdemo.APIKeyHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  4:56 PM
 **/
public class AssetConvert {
    String APIUrl = "https://www.okx.com";
    public boolean isSimulate = true;
    APIKeyHolder apiKeyHolder;
    CommonAPICaller<APIRequestPayload,JsonObject> commonAPICaller;

    public AssetConvert(APIKeyHolder apiKeyHolder){
        this.apiKeyHolder = apiKeyHolder;
        commonAPICaller = new CommonAPICaller<>(APIUrl,this.apiKeyHolder );
    }

    public AssetConvert(String APIUrl, boolean isSimulate, APIKeyHolder apiKeyHolder) {
        this.APIUrl = APIUrl;
        this.isSimulate = isSimulate;
        this.apiKeyHolder = apiKeyHolder;
        commonAPICaller = new CommonAPICaller<>(APIUrl,this.apiKeyHolder);
    }

    // 获取闪兑币种列表
    public <T> List<T> getConvertCurrencies(APIRequestPayload param,Class<T> clazz){
        ParamMap paramMap = new ParamMap();
        return listExecute(paramMap,"GET","/api/v5/asset/convert/currencies",clazz);
    }

    public <T> T getConvertCurrencyPair(APIRequestPayload param, Class<T> clazz){
        return execute(param,"GET","/api/v5/asset/convert/currency-pair",clazz);
    }

    //闪兑预估询价
    public <T> T convertEstimateQuote(APIRequestPayload param,Class<T> clazz){
        return execute(param,"POST","/api/v5/asset/convert/estimate-quote",clazz);
    }


    public <T> T convertTrade(APIRequestPayload param,Class<T> clazz){
        return execute(param,"POST","/api/v5/asset/convert/trade",clazz);
    }

    public <T> List<T> convertHistory(APIRequestPayload param,Class<T> clazz){
        return listExecute(param,"GET","/api/v5/asset/convert/history",clazz);
    }

    public void setSimulate(boolean simulate) {
        isSimulate = simulate;
    }





    private <R> R execute(APIRequestPayload param, String method,String path, Class<R> clazz){
        /**
         * 这里默认JsonObject 的格式为「"code":"1","data" :"","msg":"" 」
         * todo 后续需要考虑 返回异常码的情况
         * */
        try{
            JsonObject jsonObject = this.commonAPICaller.requestAPI(method,path,param,isSimulate, JsonObject.class);
            System.out.println(jsonObject);
            JsonArray dataList = jsonObject.get("data").getAsJsonArray();

            if(dataList.size() == 0) {
                return clazz.newInstance();
            }else if(dataList.size() == 1){
                JsonElement data = List.class.isAssignableFrom(clazz)? dataList:dataList.get(0);
                return new Gson().fromJson(data,clazz);
            }else{
                return new Gson().fromJson(dataList,clazz);
            }
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> List<T> listExecute(APIRequestPayload param, String method, String path, Class<T> clazz) {
        try {
            JsonObject jsonObject = this.commonAPICaller.requestAPI(method, path, param, isSimulate, JsonObject.class);
            JsonArray dataList = jsonObject.get("data").getAsJsonArray();

            if (dataList.size() == 0) {
                return new ArrayList<>();
            } else {
                List<T> list = new ArrayList<>();
                for (final JsonElement element : dataList) {
                    list.add(new Gson().fromJson(element, clazz));
                }
                return list;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
