package com.study.example.leetcodestudy.test;

/**
 * 派工单状态
 * @author
 */
public enum DistributeOrderStatusEnum {

    WAIT_ORDER(1, "WAIT_ORDER", "待下单"),
    WAIT_PAY(2, "WAIT_PAY", "待支付"),
    PART_PAY(3, "PART_PAY", "部分支付"),
    PAYED(4, "PAYED", "已支付");

    private Integer index;
    private String code;
    private String name;

    private DistributeOrderStatusEnum(Integer index, String code, String name) {
        this.index = index;
        this.code = code;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
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

    public static DistributeOrderStatusEnum getEnum(Integer index) {
        for (DistributeOrderStatusEnum type : DistributeOrderStatusEnum.values()) {
            if (type.getIndex().equals(index)) {
                return type;
            }
        }
        return null;
    }

    public static DistributeOrderStatusEnum getEnum(String code) {
        for (DistributeOrderStatusEnum type : DistributeOrderStatusEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }


}
