package org.okxbrokerdemo.service;

import cn.hutool.core.util.StrUtil;
import com.google.gson.JsonObject;
import org.okxbrokerdemo.constant.ApiEnum;
import org.okxbrokerdemo.handler.OkApiHandler;
import org.okxbrokerdemo.handler.Request;
import org.okxbrokerdemo.handler.asset.QueryCurrencyRes;
import org.okxbrokerdemo.handler.funding.TransferReq;
import org.okxbrokerdemo.handler.funding.TransferRes;
import org.okxbrokerdemo.utils.APIKeyHolder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  4:55 PM
 **/
public class Asset {

    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public Asset(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;
    }

    public <T> List<T> getCurrencies(APIRequestPayload param,Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/asset/currencies", clazz);
    }

    public List<QueryCurrencyRes> getCurrencies(String ccy, APIKeyHolder apiKeyHolder) {
        Map<String, String> params = new HashMap();
        if (StrUtil.isNotEmpty(ccy)) {
            params.put("ccy", ccy);
        }

        Request request = Request.builder().apiEnum(ApiEnum.GET_CURRENCIES).build();
        return (List)OkApiHandler.handle(request, apiKeyHolder);
    }

    /**
     * 获取余额
     */


    public <T> List<T> getAssetBalance(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/asset/balances", clazz);
    }

    /**
     * 获取账号持仓
     */
    public <T> T getAccountPosition(Class<T> clazz) {
        return commonAPICaller.execute(() -> "{}", "GET", "/api/v5/account/positions", clazz);
    }

    public <T> T getAssetValuation(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/asset/asset-valuation", clazz);
    }

    public <T> T assetTransfer(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/asset/transfer", clazz);
    }

    public List<TransferRes> assetTransfer(TransferReq req, APIKeyHolder apiKeyHolder) {
        Request request = OkApiHandler.generateRequest(req, ApiEnum.FUNDS_TRANSFER);
        return (List<TransferRes>) OkApiHandler.handle(request, apiKeyHolder);
    }

    public <T> T getAssetTransferState(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/asset/transfer-state", clazz);
    }

    public <T> List<T> getAssetBills(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/asset/bills", clazz);
    }


}
