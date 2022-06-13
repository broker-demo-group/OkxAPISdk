
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;
import org.okxbrokerdemo.service.CommonAPICaller;
import org.okxbrokerdemo.service.OAuth;
import org.okxbrokerdemo.utils.APIKeyHolder;
import org.okxbrokerdemo.utils.DemoElement;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class testCommonAPICaller {
    Client client = OkxSDK.getClient("sssssssssw");
    APIKeyHolder apiKeyHolder;
    String API_URL = "https://aws.okx.com";
    @Test
    public void testCallerPost(){
        apiKeyHolder = client.getApiKeyHolder();
        CommonAPICaller<DemoElement, Map<String,String>> commonAPICaller = new CommonAPICaller<>(API_URL,apiKeyHolder);


        DemoElement demoElement = new DemoElement();
        try {
            Map<String,String> r = commonAPICaller.requestAPI("POST","/api/v5/trade/order",demoElement,false);
            System.out.println(r);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            Map<String,String> r = commonAPICaller.requestAPI("POST","/api/v5/trade/order",demoElement,false);
            System.out.println(r);
            r = commonAPICaller.requestAPI("GET","/api/v5/trade/order",demoElement,false);

            System.out.println(r);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testOauth(){
        OAuth oAuth = new OAuth();
        try {
            String r = oAuth.getAccessToken("dfisovhdsoihiocasoiubcuiysagofewgfo","csuaihcsahc","hsuiaisa");
            System.out.println(r);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
