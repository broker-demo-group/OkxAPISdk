package org.okxbrokerdemo.ws;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/23  6:02 PM
 **/
@FunctionalInterface
public interface OkxWebSocketCallBack<T> {

    void onResponse(T response);

    default void onFailure(Throwable t){
        System.out.println("onFailure"+t.getMessage());
    }

}
