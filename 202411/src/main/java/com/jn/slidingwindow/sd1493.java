package com.jn.slidingwindow;

/*

代码
测试用例
测试结果
测试结果
1493. 删掉一个元素以后全为 1 的最长子数组
中等
相关标签
相关企业
提示
给你一个二进制数组 nums ，你需要从中删掉一个元素。

请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。

如果不存在这样的子数组，请返回 0 。
 */
public class sd1493 {
    public int longestSubarray(int[] nums) {
        //其实只需要统计0的数量
        int maxResult = 0;
        int left = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxResult = Math.max(maxResult, right - left);
        }

        return maxResult;
    }
}

/*
错误的方法
public int longestSubarray(int[] nums) {
        int maxResult = 0;
        int left = 0;
        int count = 0;
        int one = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                one++;
            }
            if (nums[right] == 1) {
                count++;
            }

            while (one > 1) {
                if (nums[left] == 0) {
                    one--;
                }
                if (nums[left] == 1) {
                    count--;
                }
            }

            maxResult = Math.max(maxResult, count);
        }

        return maxResult;
    }
 */
