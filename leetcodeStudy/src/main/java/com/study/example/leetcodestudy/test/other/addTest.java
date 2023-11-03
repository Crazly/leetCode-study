package com.study.example.leetcodestudy.test.other;


import antlr.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.study.example.leetcodestudy.bean.Study;
import com.study.example.leetcodestudy.util.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class addTest {

    @GetMapping("/index")
    public String studyController(String url){
        try {

//            https%253A%252F%252Fbim-bnq.bthome.com%252Fapi%252Fcart%252F93861
            String decode = URLDecoder.decode(url, "utf-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }

        Map<String,String> map = new HashMap<>();
        map.put("test","test01");
        return "addTest";
    }

    public static void main(String[] args) {

        List<Object> objects = Collections.emptyList();
        Set<String> categoryCodes = new HashSet<>();
        categoryCodes.add("s");

        if (categoryCodes.contains(null)) {
            System.out.println("sfsds");
        }

//        List<String> collect = Stream.of("one", "two", "three", "four")
//                .filter(e -> e.length() > 3)
//                .peek(e -> System.out.println("Filtered value: " + e))
//                .map(String::toUpperCase)
//                .peek(e -> System.out.println("Mapped value: " + e))
//                .collect(Collectors.toList());
//        System.out.println(JSONObject.toJSONString(collect));
//        System.out.println("----------------------------------");
//        Stream.of("one", "two", "three", "four")
//                .filter(e -> e.length() > 3)
//                .forEach(x-> System.out.println("Mapped value :"+x));

    }

}
