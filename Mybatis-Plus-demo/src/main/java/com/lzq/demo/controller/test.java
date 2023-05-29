package com.lzq.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzq.demo.mapper.PlReleaseRangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class test {

    @Autowired
    private PlReleaseRangeMapper mapper;

    @PostMapping("/test")
    @ResponseBody
    public List<Map<String, Object>> test(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("orgs", new String[]{"组织1","组织2"});
        List<Map<String, Object>> select = mapper.selectALL(map);
        return select;
    }

    @PostMapping("/test2")
    @ResponseBody
    public String test2(){
        List<Map<String, Object>> select = mapper.select();
        return "select";
    }

    @PostMapping("/test3")
    @ResponseBody
    public String test3(@RequestBody String json){
        JSONObject parse = (JSONObject) JSONObject.parse(json);
        System.out.println(parse);
        return "select";
    }
}
