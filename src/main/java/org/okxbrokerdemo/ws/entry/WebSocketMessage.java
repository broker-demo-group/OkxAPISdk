package org.okxbrokerdemo.ws.entry;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import org.okxbrokerdemo.service.entry.ParamMap;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/23  6:33 PM
 **/
public class WebSocketMessage {

    String op;
    ParamMap param= new ParamMap();

    public void setOp(String op) {
        this.op = op;
    }

    public String add(String key, String value) {
        return param.add(key, value);
    }



    public JsonObject getMessage(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("op", new JsonPrimitive(op));
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(new Gson().fromJson(param.getPayLoadJson(),JsonObject.class));
        jsonObject.add("args",jsonArray);
        return jsonObject;
    }
}
