package org.okxbrokerdemo.service.entry;

import org.junit.jupiter.api.Test;
/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  11:28 PM
 **/
class ParamMapTest {
    /**
    * 无参数 to Json
    * */
    @Test
    public void getPayLoadJson() {
        String r = new ParamMap().getPayLoadJson();
        assert "{}".equals(r);
    }
    /**
     * 纯字符串 to Json
     * */
    @Test
    public void getPayLoadJson2() {
        ParamMap param = new ParamMap();
        param.add("name","zhou");
        String r = param.getPayLoadJson();
        assert "{\"name\":\"zhou\"}".equals(r);

    }
    /*
    * 数字字符串 to Json （这里之前有Bug）
    * */
    @Test
    public void getPayLoadJson3() {
        ParamMap paramMap = new ParamMap();
        paramMap.add("age","1");
        String r = paramMap.getPayLoadJson();
        assert "{\"age\":\"1\"}".equals(r);
    }

}