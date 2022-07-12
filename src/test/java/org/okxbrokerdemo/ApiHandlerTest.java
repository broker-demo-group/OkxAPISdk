package org.okxbrokerdemo;

import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.constant.ApiEnum;
import org.okxbrokerdemo.handler.account.AccountBalance;
import org.okxbrokerdemo.handler.ApiHandler;
import org.okxbrokerdemo.handler.Request;
import org.okxbrokerdemo.utils.AutorizationMethod;
import java.util.HashMap;
import java.util.List;

class ApiHandlerTest {

    @Test
    void handle() {
        ApiHandler apiHandler = new ApiHandler();
        HashMap<String, String> requestParam = new HashMap<>();
        requestParam.put("ccy", "BTC");
        List<AccountBalance> accountBalances = (List<AccountBalance>) apiHandler.handle(Request.builder()
                .apiEnum(ApiEnum.QUERY_BALANCE)
                .queryParamMap(new HashMap<>())
                .headerMap(new HashMap<>())
                .isSimluate(true)
                .apiKey("b30c9e1d-2c30-48ec-8c05-6c991b84a288")
                .secretKey("FA66546C776AEF3547E210D56152DFC5")
                .passPhrase("wL!8aDF2tba6iqA@")
                .autorizationMethod(AutorizationMethod.APIKeyPair).build());
        System.out.println(accountBalances);

    }
}