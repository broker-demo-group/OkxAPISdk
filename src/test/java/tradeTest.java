
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

    Client client = OkxSDK.getClient("ccccaschuiasgvuis",true);
    @Test
    public void testTrade(){
        System.out.println(client.getApiKeyHolder().getAutorizationMethod().toString());
    }
    @Test
    public void testPlaceOrder(){



    }


}
