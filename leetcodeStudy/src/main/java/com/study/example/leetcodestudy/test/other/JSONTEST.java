package com.study.example.leetcodestudy.test.other;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

public class JSONTEST {

    public static void main(String[] args) {
        Map<String,String> stringStringMap = new HashMap<>();
        //获取初始化信息
//        initInfo();
        //初始化套餐信息
        initDecorationPackage();
    }

    private static void initDecorationPackage() {
        List<DecorationPackage> decorationPackages = new ArrayList<>();
        List<String> shopCodes = new ArrayList<>(Arrays.asList("1004","1009","1401"));
        getDecorationPackage("欧派","测试套餐","高性价比·小户型推荐","1373676", BigDecimal.valueOf(19),BigDecimal.valueOf(12888),BigDecimal.valueOf(1300),shopCodes,decorationPackages);
        System.out.println(JSONObject.toJSONString(decorationPackages));
    }

    private static void getDecorationPackage(String brandName,String packageName,String packageLabel,
                                             String sapSkuCode,BigDecimal packageArea,BigDecimal packagePrice,BigDecimal addPrice,List<String> shopCodes,List<DecorationPackage> decorationPackages) {
        DecorationPackage d1 = new DecorationPackage();
        d1.setBrandName(brandName);
        d1.setPackageName(packageName);
        d1.setPackageLabel(packageLabel);
        d1.setSapSkuCode(sapSkuCode);
        d1.setPackageArea(packageArea);
        d1.setPackagePrice(packagePrice);
        d1.setAddPrice(addPrice);
        d1.setShopCodes(shopCodes);
        decorationPackages.add(d1);
    }

    private static void initInfo() {
        JSONObject res = new JSONObject();
        List<WardrobeDto> wardrobeNumArray = new ArrayList<>();
        getWardrobeDto(1,"1个",wardrobeNumArray);
        getWardrobeDto(2,"2个",wardrobeNumArray);
        getWardrobeDto(3,"3个",wardrobeNumArray);

        List<WardrobeDto> cabinetTypeArray = new ArrayList<>();
        getWardrobeDto(1,"立柜",cabinetTypeArray);
        getWardrobeDto(2,"L型柜",cabinetTypeArray);
        getWardrobeDto(3,"U型柜",cabinetTypeArray);

        List<WardrobeDto> doorTypeArray = new ArrayList<>();
        getWardrobeDto(1,"合页门",doorTypeArray);
        getWardrobeDto(2,"滑门",doorTypeArray);
        getWardrobeDto(3,"无门",doorTypeArray);

        List<WardrobeDto> depthArray = new ArrayList<>();
        getWardrobeDto(1,"60CM以内(含)",null, depthArray);
        getWardrobeDto(2,"60CM以上",null, depthArray);

        List<WardrobeDto> internalConfigArray = new ArrayList<>();
        getWardrobeDto(1,"挂置短衣","test1", internalConfigArray);
        getWardrobeDto(2,"挂置长衣","test2", internalConfigArray);
        getWardrobeDto(3,"叠放衣物","test3", internalConfigArray);
        getWardrobeDto(4,"放置内衣物","test4", internalConfigArray);
        getWardrobeDto(5,"收纳首饰配件","test5", internalConfigArray);
        getWardrobeDto(6,"挂置裤裙","test6", internalConfigArray);
        getWardrobeDto(7,"放置鞋子","test7", internalConfigArray);
        getWardrobeDto(8,"收纳过季衣物","test8", internalConfigArray);
        getWardrobeDto(9,"收纳被褥","test9", internalConfigArray);
        getWardrobeDto(10,"放置行李箱","test10", internalConfigArray);
        getWardrobeDto(11,"放置包包","test11", internalConfigArray);
        getWardrobeDto(12,"存放贵重物品","test12", internalConfigArray);


        List<WardrobeDto> usersArray = new ArrayList<>();
        getWardrobeDto(1, "独居男性", usersArray);
        getWardrobeDto(2, "独居女性", usersArray);
        getWardrobeDto(3, "二人世界", usersArray);
        getWardrobeDto(4, "三口之家", usersArray);
        getWardrobeDto(5, "五口之家", usersArray);
        getWardrobeDto(6, "年长夫妇", usersArray);


        List<WardrobeDto> doorPlankTypeArray1 = new ArrayList<>();
        getWardrobeDto(1,"新品","test",doorPlankTypeArray1);
        getWardrobeDto(2,"3D贴膜","test",doorPlankTypeArray1);
        getWardrobeDto(3,"高光表面","test",doorPlankTypeArray1);
        getWardrobeDto(4,"新品","test",doorPlankTypeArray1);
        getWardrobeDto(5,"新品","test",doorPlankTypeArray1);
        getWardrobeDto(6,"新品","test",doorPlankTypeArray1);
        List<WardrobeDto> doorPlankTypeArray = new ArrayList<>();
        getWardrobeDto(1,"合叶门",null,doorPlankTypeArray,doorPlankTypeArray1);

        List<WardrobeDto> cabinetColorArray = new ArrayList<>();
        getWardrobeDto(1,"白色","test",cabinetColorArray);
        getWardrobeDto(2,"原木色","test",cabinetColorArray);
        getWardrobeDto(3,"黑色","test",cabinetColorArray);


        List<WardrobeDto> handleTypeArray1 = new ArrayList<>();
        getWardrobeDto(1,"复古","test",handleTypeArray1);
        getWardrobeDto(2,"极简","test",handleTypeArray1);
        getWardrobeDto(3,"长方形","test",handleTypeArray1);
        getWardrobeDto(4,"圆形","test",handleTypeArray1);

        List<WardrobeDto> handleTypeArray2 = new ArrayList<>();
        getWardrobeDto(1,"黑色","test",handleTypeArray2);
        getWardrobeDto(1,"银色","test",handleTypeArray2);
        getWardrobeDto(1,"黄色","test",handleTypeArray2);
        getWardrobeDto(1,"白色","test",handleTypeArray2);


        List<WardrobeDto> handleTypeArray = new ArrayList<>();
        getWardrobeDto(1,"陶瓷","test",handleTypeArray,handleTypeArray1);
        getWardrobeDto(2,"天然","test",handleTypeArray,handleTypeArray2);


        res.put("wardrobeNum",wardrobeNumArray);//衣柜数量
        res.put("cabinetType",cabinetTypeArray);//柜型
        res.put("doorType",doorTypeArray);//门型
        res.put("depth",depthArray);//深度
        res.put("internalConfig",internalConfigArray);//内配
        res.put("users",usersArray);//使用人群
        res.put("doorPlankType",doorPlankTypeArray);//门板样式
        res.put("cabinetColor",cabinetColorArray);//柜体颜色
        res.put("handleType",handleTypeArray);//把手样式

        System.out.println(res.toJSONString());
    }


    private static void getWardrobeDto(Integer type, String name, String img, List<WardrobeDto> usersArray) {
        WardrobeDto internalConfig1 = new WardrobeDto();
        internalConfig1.setType(type);
        internalConfig1.setName(name);
        internalConfig1.setImg(img);

        usersArray.add(internalConfig1);
    }

    private static void getWardrobeDto(Integer type, String name, List<WardrobeDto> usersArray) {
        WardrobeDto internalConfig1 = new WardrobeDto();
        internalConfig1.setType(type);
        internalConfig1.setName(name);
        usersArray.add(internalConfig1);
    }
    private static void getWardrobeDto(Integer type, String name,String img,Integer capacity, List<WardrobeDto> usersArray) {
        WardrobeDto internalConfig1 = new WardrobeDto();
        internalConfig1.setType(type);
        internalConfig1.setName(name);
        internalConfig1.setImg(img);
        internalConfig1.setCapacity(capacity);
        usersArray.add(internalConfig1);
    }
    private static void getWardrobeDto(Integer type, String name, String img, List<WardrobeDto> usersArray, List<WardrobeDto> usersArray1) {
        WardrobeDto internalConfig1 = new WardrobeDto();
        internalConfig1.setType(type);
        internalConfig1.setName(name);
        internalConfig1.setImg(img);
        internalConfig1.setWardrobeDtos(usersArray1);
        usersArray.add(internalConfig1);
    }


    @Data
    private static class WardrobeDto {
        private Integer type;
        private String  name;
        private Integer capacity;
        private String img;
        private List<WardrobeDto> WardrobeDtos;
    }



    @Data
    private static class DecorationPackage{
        private String brandName;
        private String packageName;
        private String packageLabel;
        private String sapSkuCode;
        private BigDecimal packageArea;
        private BigDecimal packagePrice;
        private BigDecimal addPrice;
        private List<String> shopCodes;
    }





}
