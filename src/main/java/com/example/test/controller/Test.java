package com.example.test.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/test")
@RestController
public class Test {


    @GetMapping("/api")
    public String test() {

       Map<String,String> map = new HashMap()
        {
            @Override
            public Object get(Object key) {
                if (!this.containsKey("key"))
                {
                    this.put("key", "6da15c21a635717ddfcf5b0444617265");
                }
                    JSONObject jsonObject = JSONUtil.parseObj(HttpUtil.get("http://api.tianapi.com/dialogue/index", this));
                    jsonObject = JSONUtil.
                            parseObj(jsonObject.getJSONArray("newslist")
                                    .get(0).toString());
                   this.put("1", jsonObject.getStr("dialogue"));
                return super.get(key);
            }
        };

        return map.get("1");
    }


}
