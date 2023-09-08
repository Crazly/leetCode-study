package com.study.example.leetcodestudy.推荐一百;

import com.alibaba.fastjson.JSONObject;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 思路：两次遍历，第一次把非零0的往前挪位置，定义个参数k记录挪了几次，第二次遍历把k位置以后的数组元素设为0
 *
 */
public class study_007 {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,0,3,2,4,0,2,0};
        Integer[] integers = checkNums(nums);
        System.out.println(integers.toString());
        System.out.println(JSONObject.toJSONString(integers));

    }



    public static Integer[] checkNums(Integer[] num){

        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] !=0) {
               num[index]=num[i];
               index++;
            }
        }
        while (index<=num.length-1) {
            num[index]=0;
            index++;
        }
        return num;
    }


}
