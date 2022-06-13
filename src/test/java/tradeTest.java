
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;
import org.okxbrokerdemo.service.Trade;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class tradeTest {

    Client client = OkxSDK.getClient("ccccaschuiasgvuis");
    @Test
    public void testTrade(){
        System.out.println(client.getApiKeyHolder().getAutorizationMethod().toString());
    }
    @Test
    public void testPlaceOrder(){
        Trade trade = client.getTrade();
        HashMap<String,Object> orderMap = new HashMap<>();
        orderMap.put("instId","BTC-USDT");
        orderMap.put("tdMode","cash");
        orderMap.put("side","buy");
        orderMap.put("sz","0.005");
        orderMap.put("px","200.00");

        try{
            String res = trade.placeOrder(orderMap,false);
            System.out.println(res);
        }catch (Exception e) {
            System.out.println("Feign.RequestException");
            System.out.println(e.toString());
        }


    }


}
