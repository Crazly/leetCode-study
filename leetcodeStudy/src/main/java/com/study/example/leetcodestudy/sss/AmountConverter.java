package com.study.example.leetcodestudy.sss;

import java.math.BigDecimal;

public class AmountConverter {
    private static final String[] CN_NUMERIC = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
    private static final String[] CN_UNIT = { "", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟" };

    public static String convertToChinese(double amount) {
        BigDecimal bd = new BigDecimal(amount);
        String amountStr = bd.toPlainString();

        String integerPart = amountStr.split("\\.")[0];
        String decimalPart = amountStr.split("\\.")[1];

        StringBuilder result = new StringBuilder();

        // 处理整数部分
        int integerLength = integerPart.length();
        if (integerLength > 0) {
            boolean isZero = true; // 是否连续为零
            boolean isLastUnitZero = false; // 上一个单位是否为零
            for (int i = 0; i < integerLength; i++) {
                int digit = Integer.parseInt(String.valueOf(integerPart.charAt(i)));
                if (digit != 0) {
                    isZero = false;
                    if (isLastUnitZero) {
                        result.append(CN_NUMERIC[0]); // 如果上一个单位为零，则先添加一个零
                    }
                    result.append(CN_NUMERIC[digit]).append(CN_UNIT[integerLength - 1 - i]);
                    isLastUnitZero = false;
                } else {
                    if (!isZero) {
                        result.append(CN_NUMERIC[digit]);
                    }
                    isZero = true;
                    if (i == integerLength - 1) {
                        isLastUnitZero = true;
                    }
                }
            }
        }

        // 处理小数部分
        int decimalLength = decimalPart.length();
        if (decimalLength > 0) {
            result.append("点");
            for (int i = 0; i < decimalLength; i++) {
                int digit = Integer.parseInt(String.valueOf(decimalPart.charAt(i)));
                result.append(CN_NUMERIC[digit]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        double amount = 4567.89;
        String chineseAmount = convertToChinese(amount);
        System.out.println(chineseAmount);
//        String[] chineseAmountArray = chineseAmount.split("");
//
//        System.out.println("合计大写：【" + chineseAmountArray[0] + "】佰【" + chineseAmountArray[1] + "】拾【" + chineseAmountArray[2] + "】万【" +
//                chineseAmountArray[3] + "】仟【" + chineseAmountArray[4] + "】佰【" + chineseAmountArray[5] + "】元【" + chineseAmountArray[6] +
//                "】角【" + chineseAmountArray[8] + "】分");
    }
}


