package com.jn.dynamic;


/*
674. 最长连续递增序列
简单

相关标签
相关企业
给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。

连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class dy674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        //一开始脑子抽筋，把nums[i] > nums[i - 1]写成dp[i] > dp[i - 1]了
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
        }
        System.out.println(dp);
        int maxResult = 0;
        //其实最后这里不用再遍历一遍了，直接放入上面的for循环中就可以了
        for (int i = 0; i < dp.length; i++) {
            maxResult = Math.max(maxResult, dp[i]);
        }

        return maxResult;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 4, 7};
        int lengthOfLCIS = new dy674().findLengthOfLCIS(nums);
    }
}
