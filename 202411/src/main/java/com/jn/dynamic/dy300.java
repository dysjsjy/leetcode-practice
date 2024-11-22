package com.jn.dynamic;


/*
300. 最长递增子序列
中等
相关标签
相关企业
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
子序列
。
 */
public class dy300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxResult = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {dp[i] = Math.max(dp[i], dp[j] + 1);}
            }
            if (dp[i] > maxResult) maxResult = dp[i];
        }
        return maxResult;
    }
}
