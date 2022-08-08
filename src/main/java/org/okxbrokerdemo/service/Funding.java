package org.okxbrokerdemo.service;

import org.okxbrokerdemo.constant.ApiEnum;
import org.okxbrokerdemo.handler.OkApiHandler;
import org.okxbrokerdemo.handler.Request;
import org.okxbrokerdemo.handler.funding.QueryBalanceRes;
import org.okxbrokerdemo.handler.funding.TransferReq;
import org.okxbrokerdemo.handler.funding.TransferRes;
import org.okxbrokerdemo.handler.funding.WithdrawalRes;
import org.okxbrokerdemo.handler.funding.WithdrawlReq;
import org.okxbrokerdemo.utils.APIKeyHolder;
import java.util.List;

public class Funding {

    public List<QueryBalanceRes> getBalance(String ccy,APIKeyHolder apiKeyHolder){
        Request request = OkApiHandler.generateRequest(ccy, ApiEnum.GET_BALANCE);
        return (List<QueryBalanceRes>) OkApiHandler.handle(request, apiKeyHolder);
    }

    public List<TransferRes> assetTransfer(TransferReq req, APIKeyHolder apiKeyHolder) {
        Request request = OkApiHandler.generateRequest(req, ApiEnum.FUNDS_TRANSFER);
        return (List<TransferRes>) OkApiHandler.handle(request, apiKeyHolder);
    }

    public List<WithdrawalRes> withdrawal(WithdrawlReq req, APIKeyHolder apiKeyHolder) {
        Request request = OkApiHandler.generateRequest(req, ApiEnum.WITHDRAWAL);
        return (List<WithdrawalRes>) OkApiHandler.handle(request, apiKeyHolder);
    }
}
