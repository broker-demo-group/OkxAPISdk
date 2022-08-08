package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;
import org.okxbrokerdemo.service.entry.ParamMap;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    Client client = OkxSDK.getClient("","","", true);

    String algoId;
    @Test
    void getOrderAlgo() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        param.add("algoOrdType","grid");
        param.add("maxPx","20000");
        param.add("minPx","10000");
        param.add("gridNum","10");
        param.add("quoteSz","10");


        JsonObject jsonObject= client.getGrid().getOrderAlgo(param,JsonObject.class);
        System.out.println(jsonObject);
        algoId = jsonObject.get("algoId").getAsString();
        System.out.println(algoId);
    }


    String getOrderAlgoId() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        param.add("algoOrdType","grid");
        param.add("maxPx","20000");
        param.add("minPx","10000");
        param.add("gridNum","10");
        param.add("quoteSz","10");


        JsonObject jsonObject= client.getGrid().getOrderAlgo(param,JsonObject.class);
        System.out.println(jsonObject);
        return  jsonObject.get("algoId").getAsString();

    }

    @Test
    void amendOrderAlgo() {
        ParamMap param = new ParamMap();
        param.add("algoId",getOrderAlgoId());
        param.add("instId","BTC-USDT");
        param.add("slTriggerPx","9000");
        param.add("tpTriggerPx","21000");

        JsonObject jsonObject= client.getGrid().amendOrderAlgo(param,JsonObject.class);
        algoId = jsonObject.get("algoId").getAsString();
        System.out.println(algoId);
    }

    @Test
    void stopOrderAlgo() {
        ParamMap param = new ParamMap();
        param.add("instId","BTC-USDT");
        param.add("algoId",getOrderAlgoId());
        param.add("algoOrdType","grid");
        param.add("stopType","1");

        JsonObject jsonObject= client.getGrid().amendOrderAlgo(param,JsonObject.class);
        System.out.println(jsonObject);
    }

    @Test
    void getOrdersAlgoPending() {
        ParamMap param = new ParamMap();
        param.add("algoOrdType","grid");
        List<JsonObject> list = client.getGrid().getOrdersAlgoPending(param,JsonObject.class);
        System.out.println(list);
    }

    @Test
    void getOrdersAlgoHistory() {
        ParamMap param = new ParamMap();
        param.add("algoOrdType","grid");
        List<JsonObject> list = client.getGrid().getOrdersAlgoHistory(param,JsonObject.class);
        System.out.println(list);
    }

    @Test
    void getOrdersAlgoDetails() {
    }

    @Test
    void getSubOrders() {
    }

    @Test
    void getPositions() {
    }

    @Test
    void getWithdrawIncome() {
    }
}