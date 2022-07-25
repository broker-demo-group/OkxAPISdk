package org.okxbrokerdemo;

import cn.hutool.core.lang.Assert;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.constant.ApiEnum;
import org.okxbrokerdemo.handler.account.QueryAccountBalanceRes;
import org.okxbrokerdemo.handler.OkApiHandler;
import org.okxbrokerdemo.handler.Request;
import org.okxbrokerdemo.utils.APIKeyHolder;
import org.okxbrokerdemo.utils.AutorizationMethod;
import java.util.HashMap;
import java.util.List;

class ApiHandlerTest {

    @Test
    void handle() {
        OkApiHandler okApiHandler = new OkApiHandler();
        HashMap<String, String> requestParam = new HashMap<>();
        requestParam.put("ccy", "USDT");
        List<QueryAccountBalanceRes> queryAccountBalanceRes = (List<QueryAccountBalanceRes>) okApiHandler.handle(Request.builder()
                .apiEnum(ApiEnum.GET_CURRENCIES)
                .queryParamMap(new HashMap<>())
                .headerMap(new HashMap<>())
                .isSimluate(true).build(),APIKeyHolder.builder()
                .apiKey("b30c9e1d-2c30-48ec-8c05-6c991b84a288")
                .secretKey("FA66546C776AEF3547E210D56152DFC5")
                .passPhrase("wL!8aDF2tba6iqA@")
                .autorizationMethod(AutorizationMethod.APIKeyPair).build());
        Assert.notEmpty(queryAccountBalanceRes);

    }
}