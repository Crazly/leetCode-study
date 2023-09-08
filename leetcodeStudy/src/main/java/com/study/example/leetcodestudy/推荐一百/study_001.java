package com.study.example.leetcodestudy.推荐一百;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class study_001 {
    /**
     * no 1. 两数之和
     *
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     *
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     *  示例 2：
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     * 示例 3：
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *  
     * 提示：
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int[] twoSum(int[] nums, int target) {
        if (nums==null||nums.length<2) {
            return null;
        }
        Map<Integer,Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(Math.subtractExact(target, nums[i]))) {
                return new int[]{i,resultMap.get(Math.subtractExact(target, nums[i]))};
            }
            resultMap.put(nums[i],i);
        }
        return null;
    }

    public static int[] twoSum2(int[] nums,int target){

        if (nums==null||nums.length<2) {
            return null;
        }
        int[] clone = nums.clone();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int i1 = Math.subtractExact(target, nums[i]);

            for (int i2 = 0; i2 < clone.length; i2++) {
                if (nums[i2]==i1&&i!=i2) {
                    result[0]=i;
                    result[1]=i2;
                    return result;
                }
            }

        }
        return null;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{2,4,6,3,9};
//        int[] nums2 = new int[6];
        int[] nums3 = {3,5,1,9,2};
        int target = 10;
        String s = JSONObject.toJSONString(twoSum(nums3, target));
        System.out.println(s);


        int[] ints = twoSum2(nums3, target);
        System.out.println(JSONObject.toJSONString(ints));

    }

}
