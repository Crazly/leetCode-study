package com.study.example.leetcodestudy.sss;

import java.math.BigDecimal;

public class AmountToChineseUtils {
    private static final String[] CN_NUMERIC = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] CN_UNIT = {"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿"};
    private static final String CN_YUAN = "元";
    private static final String CN_JIAO = "角";
    private static final String CN_FEN = "分";

    public static String amountToChinese(double amount) {
        if (amount < 0 || amount > 9999999) {
            throw new IllegalArgumentException("金额超出范围");
        }

        BigDecimal decimal = BigDecimal.valueOf(amount).setScale(2, BigDecimal.ROUND_HALF_UP);
        int yuan = decimal.intValue();
        int jiao = decimal.multiply(BigDecimal.TEN).intValue() % 10;
        int fen = decimal.multiply(BigDecimal.TEN).multiply(BigDecimal.TEN).intValue() % 10;

        StringBuilder result = new StringBuilder();
        result.append(convertToChinese(yuan)).append(CN_YUAN);
        result.append(convertToChinese(jiao)).append(CN_JIAO);
        result.append(convertToChinese(fen)).append(CN_FEN);

        return result.toString();
    }

    private static String convertToChinese(int num) {
        StringBuilder result = new StringBuilder();
        int unit = 0;
        boolean isZero = true;
        if(num==0){
            return CN_NUMERIC[0];
        }
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) {
                if (!isZero) {
                    isZero = true;
                    result.insert(0, CN_NUMERIC[digit]);
                }
            } else {
                isZero = false;
                result.insert(0, CN_NUMERIC[digit] + CN_UNIT[unit]);
            }
            unit++;
            num /= 10;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        double amount = 10;
        String chineseAmount = AmountToChineseUtils.amountToChinese(amount);
        System.out.println(chineseAmount);  // 输出：肆仟伍佰陆拾柒元陆角柒分
    }

}