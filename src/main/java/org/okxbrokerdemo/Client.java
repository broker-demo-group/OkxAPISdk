package org.okxbrokerdemo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.okxbrokerdemo.service.Account;
import org.okxbrokerdemo.service.Asset;
import org.okxbrokerdemo.service.AssetConvert;
import org.okxbrokerdemo.service.Broker;
import org.okxbrokerdemo.service.BulkTrade;
import org.okxbrokerdemo.service.CommonService;
import org.okxbrokerdemo.service.Funding;
import org.okxbrokerdemo.service.Grid;
import org.okxbrokerdemo.service.Market;
import org.okxbrokerdemo.service.PublicService;
import org.okxbrokerdemo.service.Status;
import org.okxbrokerdemo.service.SubAccount;
import org.okxbrokerdemo.service.Trade;
import org.okxbrokerdemo.service.TradingBigData;
import org.okxbrokerdemo.utils.APIKeyHolder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    APIKeyHolder apiKeyHolder;
    Grid grid;
    Trade trade;
    Asset asset;
    Account account;
    SubAccount subAccount;
    AssetConvert assetConvert;
    Market market;
    Status status;
    BulkTrade bulkTrade;
    PublicService publicService;
    CommonService commonService;
    TradingBigData tradingBigData;
    Broker broker;
    private Funding funding;

}
