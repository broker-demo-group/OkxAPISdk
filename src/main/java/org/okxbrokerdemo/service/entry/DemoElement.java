package org.okxbrokerdemo.service.entry;


import org.okxbrokerdemo.service.entry.APIRequestPayload;

public class DemoElement implements APIRequestPayload {
    @Override
    public String getPayLoadJson() {
        return "{instId=BTC-USDT, side=buy, sz=0.005, px=200.00, tdMode=cash}";
    }
}
