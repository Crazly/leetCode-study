package com.study.example.leetcodestudy.test;


import java.util.*;

/**
 * 意向跟单状态
 *
 * @author s10005467
 */
public enum PromotionStatusEnum {

    //待查看
    WAIT_LOOK(10L, "WAIT_LOOK", "待查看"),
    //待首呼
    WAIT_CALL(20L, "WAIT_CALL", "待首呼"),
    //继续联系
    CONTINUE(25L, "CONTINUE", "继续联系"),
    //待上门准备
    WAIT_UP_DOOR_PREPARE(30L, "WAIT_UP_DOOR_PREPARE", "待上门准备"),
    //待上门签到
    WAIT_UP_DOOR_SIGN(40L, "WAIT_UP_DOOR_SIGN", "待上门签到"),
    //待上门完成填写结果
    WAIT_UP_DOOR_FINISH(50L, "WAIT_UP_DOOR_FINISH", "待完成上门"),
    //上门后继续跟进
    WAIT_UP_DOOR_FOLLOW(60L, "WAIT_UP_DOOR_FOLLOW", "上门后继续跟进"),
    //待预约到店准备
    WAIT_UP_SHOP_PREPARE(70L, "WAIT_UP_SHOP_PREPARE", "待到店准备"),
    //待用户到店签到
    WAIT_UP_SHOP_SIGN(80L, "WAIT_UP_SHOP_SIGN", "待用户签到"),
    //待到店完成填写结果
    WAIT_UP_SHOP_FINISH(90L, "UP_SHOP_FINISH", "待完成到店"),
    CONVERT_TO_DC(95L, "CONVERT_TO_DC", "已转家装"),
    //到店后继续跟进
    WAIT_UP_SHOP_FOLLOW(100L, "UP_SHOP_FOLLOW", "到店后继续跟进"),
    WAIT_UP_ORDER(105L, "WAIT_UP_ORDER", "待下单"),
    ORDERED(106L, "ORDERED", "已下单"),
    WAIT_UPGRADEING(107L, "WAIT_UPGRADEING", "店内升级中"),

    //已支付
    PAYED(120L, "PAYED", "已完成"),
    //部分支付
   PART_PAY(130L, "PART_PAY", "部分支付"),
    //废单
    WASTE_ORDER(140L, "WASTE_ORDER", "废单"),
    //死单
    DEAD_ORDER(150L, "DEAD_ORDER", "死单"),
    //取消审核中
    CANCEL_AUDIT(160L, "CANCEL_AUDIT", "取消审核中"),




    EMPTY(1000L, "EMPTY", ""),

    ;

    private Long index;
    private String code;
    private String name;

    private PromotionStatusEnum(Long index, String code, String name) {
        this.index = index;
        this.code = code;
        this.name = name;
    }

    public static List<PromotionStatusEnum> getEnumList() {
        return Arrays.asList(values());
    }

    public static List<Map<String, Object>> getEnumListMap() {
        List<Map<String, Object>> enumList = new ArrayList<>();

        getEnumList().forEach(o -> {
            Map<String, Object> map = new HashMap<>();
            map.put("index", o.getIndex());
            map.put("code", o.getCode());
            map.put("name", o.getName());
            enumList.add(map);
        });
        return enumList;
    }

    public static Map<String, Object> getEnumByIndex(Integer index){
        for (PromotionStatusEnum value : values()) {
            if (value.getIndex().equals(index)){
                Map<String, Object> map = new HashMap<>();
                map.put("index", value.getIndex());
                map.put("code", value.getCode());
                map.put("name", value.getName());
                return map;
            }
        }
        return null;
    }

    public Long getIndex() {
        return this.index;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Long index) {
        return null == index ? false : index.equals(this.index);
    }

    public static PromotionStatusEnum getEnum(Long index) {
        for (PromotionStatusEnum type : PromotionStatusEnum.values()) {
            if (type.getIndex().equals(index)) {
                return type;
            }
        }
        return EMPTY;
    }

    public static PromotionStatusEnum getEnum(String code) {
        for (PromotionStatusEnum type : PromotionStatusEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return EMPTY;
    }

}
