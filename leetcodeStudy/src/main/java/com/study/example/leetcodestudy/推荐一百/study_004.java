package com.study.example.leetcodestudy.推荐一百;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class study_004 {

    /**
     * no 53.最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     *  f(i)=max{f(i−1)+nums[i],nums[i]}
     */

    /**
     *
     * 动态规划，可以套用公式
     * f(i)为到i之前的和
     * nums[i]为i的和
     * 假设 nums 数组的长度是 n，下标从 0 到 n−1。
     *
     * 我们用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」
     * 因此我们只需要求出每个位置的 f(i)，然后返回数组中的最大值即可。那么我们如何求 f(i)f(i) 呢？
     * 我们可以考虑nums[i] 单独成为一段还是加入 f(i-1) 对应的那一段，这取决于nums[i] 和 f(i-1) + +nums[i] 的大小，
     * 我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
     * f(i)=max{f(i−1)+nums[i],nums[i]}
     */

    public static int maxSubArray(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        int sumMax = 0;//前n个的和
        int result = nums[0];//最终返回结果
        for (int i = 0; i < nums.length; i++) {
            sumMax=Math.max(sumMax+nums[i],nums[i]);
            result=Math.max(result,sumMax);
        }
//        System.out.println(sumMax);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,-4,2,7};
        int i = maxSubArray(nums);
        System.out.println(i);
//        List<Study> linkedList = new ArrayList<>();
//
//        Study s = new Study();
//        s.setStr("s");
//        Study s1 = new Study();
//        s1.setStr("w");
//        Study s2 = new Study();
//        s2.setStr("z");
//        Study s3 = new Study();
//        s3.setStr("s");
//        linkedList.add(s);
//        linkedList.add(s1);
//        linkedList.add(s2);
//        linkedList.add(s3);
//        System.out.println(JSONObject.toJSONString(linkedList));
//
//        List<String> collect = linkedList.stream().map(x->x.getStr()).distinct().collect(Collectors.toList());
//        System.out.println(JSONObject.toJSONString(collect));

    }

    public static class Study{
        private String str;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }


}
