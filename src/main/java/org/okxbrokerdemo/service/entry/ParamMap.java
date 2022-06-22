package org.okxbrokerdemo.service.entry;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  11:28 PM
 **/
public class ParamMap implements APIRequestPayload {
    Map<String, String> param = new HashMap<>();

    public String add(String key, String value) {
        return param.put(key, value);
    }

    @Override
    public String getPayLoadJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Map.Entry<String, String> e : param.entrySet()) {
            sb.append("\""+e.getKey() + "\":\"" + e.getValue() + "\",");
        }
        if(sb.length()>1) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        JsonObject jsonString = new Gson().fromJson(sb.toString(), JsonObject.class);
        return jsonString.toString();
    }
}
