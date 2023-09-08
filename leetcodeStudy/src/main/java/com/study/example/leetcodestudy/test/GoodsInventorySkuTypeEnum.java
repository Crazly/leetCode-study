package com.study.example.leetcodestudy.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public enum GoodsInventorySkuTypeEnum {
    material(1L, Arrays.asList("54","55","67","57","63","53","08"), "辅材"),
    custom(2L, Arrays.asList("Y"), "定制品"),
    other(3L, Collections.emptyList(), "其他");

    private Long index;
    private List<String> codes;
    private String name;

    private GoodsInventorySkuTypeEnum(Long index, List<String> codes, String name) {
        this.index = index;
        this.codes = codes;
        this.name = name;
    }

    public Long getIndex() {
        return index;
    }

    public List<String> getCodes() {
        return codes;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Long index) {
        return null != index && index.equals(this.index);
    }


    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (GoodsInventorySkuTypeEnum item : values()) {
            map.put(item.getIndex().toString(), item.getName());
        }
        return map;
    }

    public static JSONArray getJsonArray() {
        JSONArray array = new JSONArray();
        for (GoodsInventorySkuTypeEnum item : values()) {
            array.add(item.toJSONObject());
        }
        return array;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", index);
        jsonObject.put("name", name);
        return jsonObject;
    }

    public static GoodsInventorySkuTypeEnum getEnum(Long index) {
        for (GoodsInventorySkuTypeEnum item : values()) {
            if (item.getIndex().equals(index)) {
                return item;
            }
        }
        return null;
    }
}
