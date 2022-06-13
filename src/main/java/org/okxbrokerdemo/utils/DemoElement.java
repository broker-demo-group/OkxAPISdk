package org.okxbrokerdemo.utils;


import org.okxbrokerdemo.service.APIRequestPayload;

public class DemoElement implements APIRequestPayload {
    @Override
    public String getPayLoadJson() {
        return "{instId=BTC-USDT, side=buy, sz=0.005, px=200.00, tdMode=cash}";
    }
}
