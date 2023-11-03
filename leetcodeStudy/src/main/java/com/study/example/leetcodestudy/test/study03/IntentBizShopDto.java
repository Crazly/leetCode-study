package com.study.example.leetcodestudy.test.study03;

import lombok.Data;

import java.io.Serializable;

/**
 * 意向跟单门店
 * @author yangjc
 */
@Data
public class IntentBizShopDto implements Serializable {

    private String shopCode;
    private String shopName;
    private Integer bizType;


}
