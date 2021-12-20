package com.study.example.leetcodestudy.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class test {


    public static void main(String[] args) {


        String str = "[{status:200,urls:['1','2','6']},{status:300,urls:['3','4']}]";
//        String str2="[{200:'1',300:'3'},{200:'2',300:'4'},{200:'6',300:''}]";
        Map<String,List<Map<Integer,String>>> statusMap = new HashMap<>();

        List<Status> statuses = JSONObject.parseArray(str, Status.class);
        Map<String,List<JSONObject>> resMap = new HashMap<>();
        for (Status status : statuses) {
            String status1 = status.getStatus();
            int[] urls = status.getUrls();
            List<JSONObject> objectList = new ArrayList<>();
            for (int url : urls) {
                JSONObject object = new JSONObject();
                object.put(status1,url);
                objectList.add(object);
            }
            System.out.println(JSONObject.toJSONString(objectList));
            resMap.put(status1,objectList);
        }

        System.out.println(JSONObject.toJSONString(resMap));

    }


    public static class Status{

        String status;
        int[] urls;
        String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int[] getUrls() {
            return urls;
        }

        public void setUrls(int[] urls) {
            this.urls = urls;
        }
    }



}
