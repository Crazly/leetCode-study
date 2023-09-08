package com.example.demo;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
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


    private static void testForMe(Runnable s){
        new Thread(s).start();
    }

    private static void testChange(String s, Function<String,Integer> f1,Function<Integer,String> f2){
        String m = f1.andThen(f2).apply(s);
        System.out.println(m);
    };


    public static <T> List<List<T>> splitList(List<T> list, int splitSize) {

        //计算分割后的大小
        int maxSize = (list.size() + splitSize - 1) / splitSize;
        //开始分割
        return Stream.iterate(0, n -> n + 1)
                .limit(maxSize)
                .parallel()
                .map(a -> list.parallelStream().skip(a * splitSize).limit(splitSize).collect(Collectors.toList()))
                .filter(b -> !b.isEmpty())
                .collect(Collectors.toList());
    }
//    public static void main(String[] args) {
//        BigDecimal backRebate = BigDecimal.valueOf(12.00D);//返利
//        BigDecimal logisticsFee = BigDecimal.valueOf(12.00D);//物流
//        BigDecimal purchaseWithTax = BigDecimal.valueOf(99.99D);//含税采购价
//        BigDecimal setmealPrice = BigDecimal.valueOf(200.00D);////套餐基础价/升级折扣价
//        BigDecimal squareCoefficient = BigDecimal.valueOf(1.00D);//平方系数
//        BigDecimal marketPrice = BigDecimal.valueOf(300.00D);//市场价
//        //裸价= 含税采购价*（1-返利%-物流%）
//        BigDecimal nakedpriceWithTax = purchaseWithTax.multiply(BigDecimal.valueOf(100).subtract(backRebate.add(logisticsFee)).divide(BigDecimal.valueOf(100)));
//        System.out.println("裸价："+nakedpriceWithTax);
//        //裸价毛利率=(套餐基础价/升级折扣价-裸成本）/套餐基础价/升级折扣价
//        System.out.println( "裸价毛利率："+setmealPrice.subtract(nakedpriceWithTax).divide(setmealPrice, 2, BigDecimal.ROUND_HALF_UP));
//
//        //平方裸价=裸成本/平方系数
//        System.out.println("平方裸价："+nakedpriceWithTax.divide(squareCoefficient, 2, BigDecimal.ROUND_HALF_UP));
//        //平方套餐基础价/升级折扣价=套餐基础价/升级折扣价/平方系数
//        System.out.println("平方套餐基础价："+setmealPrice.divide(squareCoefficient, 2, BigDecimal.ROUND_HALF_UP));
//        //平方市场价 = 市场价/平方系数
//        System.out.println("平方市场价："+marketPrice.divide(squareCoefficient, 2, BigDecimal.ROUND_HALF_UP));
//
//    }

    private static int add(int ... nums){
        int s = 0;
        for (int num : nums) {
            s+=num;
        }
        return s;
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


    public void testAdd(){
        System.out.println("233214");

        synchronized (testSync.class){

        }

    }


    public static class testSync{

    }

    public static void main(String[] args) {
        Map<Long,List<Long>> brandMap = new HashMap<>();
        brandMap.put(1l,new ArrayList<>(Arrays.asList(9l)));
        if (brandMap.containsKey(1l)) {
            List<Long> longList = brandMap.get(1l);
            longList.add(7l);
        }

        System.out.println(JSONObject.toJSONString(brandMap));

    }

}
