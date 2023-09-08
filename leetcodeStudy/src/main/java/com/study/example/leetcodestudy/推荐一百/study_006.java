package com.study.example.leetcodestudy.推荐一百;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *  
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class study_006 {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{2,2,1,1,1,1,1,2,2};
//        Arrays.sort(nums);
//        int i = nums.length / 2;
//        Integer num1 = nums[nums.length / 2];
//        System.out.println(num1);

        Integer num2 = getNum2(nums);
        System.out.println(num2);

//        Integer num = getNum(nums);
//        System.out.println(num);
    }

    public static Integer getNum2(Integer[] nums){
        int result = 0;
        int now=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (now==nums[i]) {
                result++;
            }else {
                result--;
                if (result==0){
                    now = nums[i+1];
                }
            }
        }
        return now;
    }
    public static Integer getNum(Integer[] nums){

//        Map<Integer, List<Integer>> collect = Arrays.stream(nums).collect(Collectors.groupingBy(x -> x));
        Map<Integer, List<Integer>> collect = new HashMap<>();
        for (Integer num : nums) {
            if (collect.containsKey(num)) {
                List<Integer> integers = collect.get(num);
                if (null==integers) {
                    integers = new ArrayList<>();
                }
                integers.add(num);
            }else {
                List<Integer> intes = new ArrayList<>();
                intes.add(num);
                collect.put(num,intes);
            }
        }
        int i = Math.floorDiv(nums.length, 2);
        int result=0;
        int resultKey = 0;
        List<Integer> now = null;
        for (Map.Entry<Integer, List<Integer>> integerListEntry : collect.entrySet()) {
            Integer key = integerListEntry.getKey();
            List<Integer> value = integerListEntry.getValue();
            if (now==null) {
                now=value;
                result=value.size();
                resultKey = key;
                continue;
            }
            if (value.size()>=now.size()) {
                now=value;
                result=value.size();
                resultKey = key;
            }
        }
        if (i <result) {
            return resultKey;
        }
        return -1;
    }



}
