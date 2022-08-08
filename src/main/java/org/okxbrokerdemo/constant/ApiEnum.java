package org.okxbrokerdemo.constant;

import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.okxbrokerdemo.handler.account.AccountPosition;
import org.okxbrokerdemo.handler.account.QueryAccountBalanceRes;
import org.okxbrokerdemo.handler.account.QueryAccountPositionHistoryRes;
import org.okxbrokerdemo.handler.asset.QueryCurrencyRes;
import org.okxbrokerdemo.handler.broker.CreatSubAccountDepositAddressRes;
import org.okxbrokerdemo.handler.broker.QuerySubAccountDepositAddressRes;
import org.okxbrokerdemo.handler.broker.QuerySubAccountListReq;
import org.okxbrokerdemo.handler.broker.SetTradingFeeRateReq;
import org.okxbrokerdemo.handler.funding.QueryBalanceRes;
import org.okxbrokerdemo.handler.funding.TransferRes;
import org.okxbrokerdemo.handler.funding.WithdrawalRes;
import org.okxbrokerdemo.handler.subaccount.SetTransOutRes;
import org.okxbrokerdemo.handler.subaccount.SubAccountTransferRes;
import org.okxbrokerdemo.handler.trade.PlaceOrderRes;
import org.okxbrokerdemo.handler.trade.QueryOrderDetailRes;
import java.lang.reflect.Type;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ApiEnum {

    /**
     * api
     */
    GET_BALANCE("/api/v5/asset/balances",MethodTypeEnum.GET,new TypeToken<List<QueryBalanceRes>>(){}.getType()),
    GET_ACCOUNT_BALANCES("/api/v5/account/balance", MethodTypeEnum.GET, (new TypeToken<List<QueryAccountBalanceRes>>() {
    }).getType()),
    GET_ACCOUNT_POSITIONS("/api/v5/account/positions", MethodTypeEnum.GET, (new TypeToken<List<AccountPosition>>() {
    }).getType()),
    GET_ACCOUNT_POSITION_HISTORY("/api/v5/account/positions-history", MethodTypeEnum.GET, (new TypeToken<List<QueryAccountPositionHistoryRes>>() {
    }).getType()),
    FUNDS_TRANSFER("/api/v5/asset/transfer", MethodTypeEnum.GET, (new TypeToken<List<TransferRes>>() {
    }).getType()),
    WITHDRAWAL("/api/v5/asset/withdrawal", MethodTypeEnum.POST, (new TypeToken<List<WithdrawalRes>>() {
    }).getType()),
    GET_CURRENCIES("/api/v5/asset/currencies", MethodTypeEnum.GET, (new TypeToken<List<QueryCurrencyRes>>() {
    }).getType()),
    GET_ND_BROKER_SUB_ACCOUNT_DEPOSIT_ADDRESS("/api/v5/asset/broker/nd/subaccount-deposit-address", MethodTypeEnum.GET, (new TypeToken<List<QuerySubAccountDepositAddressRes>>() {
    }).getType()),
    CREATE_DEPOSIT_ADDRESS_FOR_SUB_ACCOUNT("/api/v5/asset/broker/nd/subaccount-deposit-address", MethodTypeEnum.POST, (new TypeToken<List<CreatSubAccountDepositAddressRes>>() {
    }).getType()),
    SET_PERMISSION_OF_TRANSFER_OUT("/api/v5/users/subaccount/set-transfer-out", MethodTypeEnum.GET, (new TypeToken<List<SetTransOutRes>>() {
    }).getType()),
    GET_ORDER_DETAILS("/api/v5/trade/order", MethodTypeEnum.GET, new TypeToken<List<QueryOrderDetailRes>>() {
    }.getType()),
    PLACE_ORDER("/api/v5/trade/order", MethodTypeEnum.POST, new TypeToken<List<PlaceOrderRes>>() {
    }.getType()),
    SET_TRADING_FEE_RATE("/api/v5/broker/nd/set-subaccount-fee-rate", MethodTypeEnum.POST, new TypeToken<SetTradingFeeRateReq>() {
    }.getType()),
    GET_SUB_ACCOUNT_LIST("/api/v5/broker/nd/subaccount-info", MethodTypeEnum.GET, new TypeToken<QuerySubAccountListReq>() {
    }.getType()),
    MASTER_ACCOUNTS_MANAGE_THE_TRANSFERS_BETWEEN_SUB_ACCOUNTS("/api/v5/asset/subaccount/transfer", MethodTypeEnum.GET, new TypeToken<List<SubAccountTransferRes>>() {
    }.getType()),
    ;

    private String path;
    private MethodTypeEnum methodType;
    private Type responseType;

}
