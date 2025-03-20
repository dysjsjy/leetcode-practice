package com.dysjsjy.hot100Java;

public class T198 {

    class Solution {

        // 状态转移方程，状态定义，边界条件
        // dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        public int rob(int[] nums) {
            // 边界条件，边界条件有两个需要注意的部分一个能不能正常开始，一个是能不能正常结束，
            if (nums.length <= 1) {
                return nums[0];
            }

            // 状态定义
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[1], dp[0]);
            // 使用迭代来执行状态转移方程
            for (int i = 2; i < nums.length; i++) {
                // 状态转移方程
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[dp.length - 1];
        }
    }
}
