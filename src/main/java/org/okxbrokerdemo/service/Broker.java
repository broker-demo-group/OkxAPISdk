package org.okxbrokerdemo.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.okxbrokerdemo.constant.ApiEnum;
import org.okxbrokerdemo.handler.OkApiHandler;
import org.okxbrokerdemo.handler.Request;
import org.okxbrokerdemo.handler.broker.CreatSubAccountDepositAddressRes;
import org.okxbrokerdemo.handler.broker.CreateSubAccountDepositeAddressReq;
import org.okxbrokerdemo.handler.broker.QuerySubAccountDepositAddressReq;
import org.okxbrokerdemo.handler.broker.QuerySubAccountDepositAddressRes;
import org.okxbrokerdemo.handler.broker.QuerySubAccountListReq;
import org.okxbrokerdemo.handler.broker.QuerySubAccountListRes;
import org.okxbrokerdemo.handler.broker.SetTradingFeeRateReq;
import org.okxbrokerdemo.handler.broker.SetTradingFeeRateRes;
import org.okxbrokerdemo.handler.funding.WithdrawalRes;
import org.okxbrokerdemo.handler.funding.WithdrawlReq;
import org.okxbrokerdemo.service.entry.ParamMap;
import org.okxbrokerdemo.utils.APIKeyHolder;
import java.util.List;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/29  3:34 PM
 **/
public class Broker {
    CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller;

    public Broker(CommonAPICaller<APIRequestPayload, JsonObject> commonAPICaller) {
        this.commonAPICaller = commonAPICaller;

    }

    public List<QuerySubAccountDepositAddressRes> getSubAccountDepositAddress(QuerySubAccountDepositAddressReq req, APIKeyHolder apiKeyHolder) {
        Request request = OkApiHandler.generateRequest(req, ApiEnum.GET_ND_BROKER_SUB_ACCOUNT_DEPOSIT_ADDRESS);
        return (List) OkApiHandler.handle(request, apiKeyHolder);
    }

    public List<CreatSubAccountDepositAddressRes> createSubAccountDepositAddress(CreateSubAccountDepositeAddressReq req, APIKeyHolder apiKeyHolder) {
        Request request = OkApiHandler.generateRequest(req, ApiEnum.CREATE_DEPOSIT_ADDRESS_FOR_SUB_ACCOUNT);
        return (List) OkApiHandler.handle(request, apiKeyHolder);
    }

    public <T> T getInfo(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/broker/nd/info", clazz);
    }

    public <T> T createSubAccount(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/create-subaccount", clazz);
    }

    public <T> T deleteSubAccount(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/delete-subaccount", clazz);
    }

    public List<QuerySubAccountListRes> getSubAccountList(QuerySubAccountListReq req, APIKeyHolder apiKeyHolder) {
        Request request = OkApiHandler.generateRequest(req, ApiEnum.GET_SUB_ACCOUNT_LIST);
        return (List<QuerySubAccountListRes>) OkApiHandler.handle(request, apiKeyHolder);
    }

    public <T> List<T> getSubAccountList(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/broker/nd/subaccount-info", clazz);
    }


    public <T> T createSubAccountApiKey(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/subaccount/apikey", clazz);
    }

    public <T> T getSubAccountApiKey(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/broker/nd/subaccount/apikey", clazz);
    }

    public <T> T updateSubAccountApiKey(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/subaccount/modify-apikey", clazz);
    }

    public <T> T deleteSubAccountApiKey(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/subaccount/delete-apikey", clazz);
    }

    public <T> T setSubAccountLevel(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/set-subaccount-level", clazz);
    }


    public List<SetTradingFeeRateRes> setSubAccountFeeRate(SetTradingFeeRateReq req, APIKeyHolder apiKeyHolder) {
        Request request = OkApiHandler.generateRequest(req, ApiEnum.SET_TRADING_FEE_RATE);
        return (List<SetTradingFeeRateRes>) OkApiHandler.handle(request, apiKeyHolder);
    }

    public <T> T setSubAccountFeeRate(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/broker/nd/set-subaccount-fee-rate", clazz);
    }

    public <T> T createSubAccountDepositAddress(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/asset/broker/nd/subaccount-deposit-address", clazz);
    }

    public <T> T updateSubAccountDepositAddress(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "POST", "/api/v5/asset/broker/nd/modify-subaccount-deposit-address",
                clazz);
    }

    public <T> T getSubAccountDepositAddress(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/asset/broker/nd/subaccount-deposit-address",
                clazz);
    }

    public <T> T getSubAccountDepositHistory(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.execute(param, "GET", "/api/v5/asset/broker/nd/subaccount-deposit-history",
                clazz);
    }

    public <T> List<T> getRebateDaily(APIRequestPayload param, Class<T> clazz) {
        return commonAPICaller.listExecute(param, "GET", "/api/v5/broker/nd/rebate-daily",
                clazz);
    }

    /**
     * 子账户的资产通过 broker 账户转出
     * param     type   notNull note
     * ccy     String   yss     币种
     * amt     String   yes
     * dest    String   yes     提币到 3：oxk 4：数字货币地址
     * toAddr  String   yes     提币地址
     * fee     String   yes     提币到数字货币地址所需网络手续费可通过获取币种列表接口查询
     * subAcct  String  yes  子账户名
     * chain	String	no	    币种链信息
     * clientId String	no	    客户自定义ID
     * <p>
     * return:
     * ccy	    String	提币币种
     * chain	String	币种链信息
     * amt	    String	提币数量
     * wdId	    String	提币申请ID
     * clientId	String	客户自定义ID
     */
    public <T> T subAccountWithdrawalByBroker(ParamMap param, Class<T> clazz) {
        //subAccount2mainAccount
        ParamMap param1 = new ParamMap();
        param1.add("ccy", param.get("ccy"));
        param1.add("amt", param.get("amt"));
        param1.add("from", "6");
        param1.add("to", "6");
        param1.add("subAcct", param.get("subAcct"));
        param1.add("type", "2");
        if (param.containsKey("clientId")) {
            param1.add("clientId", param.get("clientId"));
        }
        commonAPICaller.execute(param1, "POST", "/api/v5/asset/transfer", JsonObject.class);

        //mainAccount withdraw
        ParamMap param2 = new ParamMap();
        param2.add("ccy", param.get("ccy"));
        param2.add("amt", param.get("amt"));
        param2.add("dest", param.get("dest"));
        param2.add("toAddr", param.get("toAddr"));
        param2.add("fee", param.get("fee"));
        param2.add("clientId", param.get("clientId"));
        JsonObject reslut = commonAPICaller.execute(param2, "POST", "/api/v5/asset/withdrawal", JsonObject.class);

        return new Gson().fromJson(reslut, clazz);
    }


    /**
     * 通过 Broker 账户，将一个子账户资产转移到另一个子账户中
     * <p>
     * param     type   notNull note
     * ccy     String   yss     币种
     * amt     String   yes     数量
     * fromSubAcct  String  yes 转出子账户名
     * toSubAcct  String  yes   转入子账户名
     * <p>
     * return:
     * transId	String	划转ID（mainAccount2SubAccount）
     * ccy	String	    划转币种
     * from	String	    转出账户
     * amt	String	    划转量
     * to	String	    转入账户
     * clientId	String	客户自定义ID
     */
    public <T> T subAcct2subAcctByBroker(ParamMap param, Class<T> clazz) {
        //subAccount2mainAccount
        ParamMap param1 = new ParamMap();
        param1.add("ccy", param.get("ccy"));
        param1.add("amt", param.get("amt"));
        param1.add("from", "6");
        param1.add("to", "6");
        param1.add("subAcct", param.get("fromSubAcct"));
        param1.add("type", "3");
        if (param.containsKey("clientId")) {
            param1.add("clientId", param.get("clientId"));
        }
        commonAPICaller.execute(param1, "POST", "/api/v5/asset/transfer", JsonObject.class);

        //mainAccount2Subaccount
        ParamMap param2 = new ParamMap();
        param2.add("ccy", param.get("ccy"));
        param2.add("amt", param.get("amt"));
        param2.add("from", "6");
        param2.add("to", "6");
        param2.add("subAcct", param.get("toSubAcct"));
        param2.add("type", "1");
        if (param.containsKey("clientId")) {
            param2.add("clientId", param.get("clientId"));
        }
        JsonObject result = commonAPICaller.execute(param2, "POST", "/api/v5/asset/transfer", JsonObject.class);


        return new Gson().fromJson(result, clazz);
    }


}
