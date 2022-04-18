package com.study.example.leetcodestudy.test;


import com.alibaba.fastjson.JSONObject;
import com.study.example.leetcodestudy.bean.Study;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class addTest {

    @GetMapping("/index")
    public String studyController(){

        Map<String,String> map = new HashMap<>();
        map.put("test","test01");
        return "addTest";
    }



    public static void main(String[] args) {

//        BigDecimal s = new BigDecimal(10.01);
//        BigDecimal bigDecimal = s.setScale(2, RoundingMode.HALF_DOWN);
//        BigDecimal priceStr = getPriceStr(bigDecimal);
        List<Integer> integers = Arrays.asList(1, 2, 3);
        System.out.println(JSONObject.toJSONString(integers));

        BigDecimal sum = BigDecimal.valueOf(10000).add(BigDecimal.valueOf(1000));
        if (BigDecimal.valueOf(9999).compareTo(sum)<0) {
            System.out.println(1111);
        }
    }



    private static BigDecimal getPriceStr(BigDecimal reward) {
        if (null==reward) {
            return null;
        }
        BigDecimal newReward = reward.setScale(2, RoundingMode.HALF_DOWN);
        int i = newReward.toString().indexOf(".");
        if ('0'== newReward.toString().charAt(i+2)) {
            if ('0'== newReward.toString().charAt(i+1)) {
                return newReward.setScale(0, RoundingMode.HALF_DOWN);
            }else {
                return newReward.setScale(1,RoundingMode.HALF_DOWN);
            }
        } else {
            return newReward;
        }
    }

}
