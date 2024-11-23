package com.jn.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
2958. 最多 K 个重复元素的最长子数组
中等

相关标签
相关企业

提示
给你一个整数数组 nums 和一个整数 k 。

一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。

如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。

请你返回 nums 中 最长好 子数组的长度。

子数组 指的是一个数组中一段连续非空的元素序列。
 */
public class sd2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxResult = 0;

        for (int rignt = 0; rignt < nums.length; rignt++) {
            
            map.put(nums[rignt], map.getOrDefault(nums[rignt], 0) + 1);
            //有点不清醒，这里是大于k
            while (map.get(nums[rignt]) > k) {
               map.put(nums[left] ,map.getOrDefault(nums[left], 0) - 1);
               if (map.get(nums[left]) == 0) {
                map.remove(nums[left]);
               }
               left++;
            }

            maxResult = Math.max(maxResult, rignt - left + 1);
        }

        return maxResult;
    }
}
