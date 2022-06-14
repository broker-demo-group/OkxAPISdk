package org.okxbrokerdemo.service;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.okxbrokerdemo.Client;
import org.okxbrokerdemo.OkxSDK;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  5:16 PM
 **/
class AssetTest {
    Client client = OkxSDK.getClient("",
            "",
            "");
    @BeforeEach
    void setUp() {

    }

    @Test
    void getAccountBalance() {
        JsonObject accountBalance = client.getAsset().getAccountBalance();
        System.out.println(accountBalance);
    }

    @Test
    void getAccountPosition() {
        JsonObject getAccountPosition = client.getAsset().getAccountPosition();
        System.out.println(getAccountPosition);
    }
}