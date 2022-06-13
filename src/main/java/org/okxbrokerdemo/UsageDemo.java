package org.okxbrokerdemo;

import org.okxbrokerdemo.utils.DemoElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsageDemo {
    public void sdkUsage() throws IOException {
        DemoElement demoElement = new DemoElement();
        Client client = OkxSDK.getClient("my_accessToekn");
        /**
         *
         * Another methods:Using the key pair to authorization
         * client = OkxSDK.getClient(apikey,secret,passPhase)
         *
         *
         * **/
        Map res = client.getTrade().placeOrder(demoElement, false);

    }
}
