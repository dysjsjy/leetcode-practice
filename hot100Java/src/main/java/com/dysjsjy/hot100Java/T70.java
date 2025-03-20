package com.dysjsjy.hot100Java;

public class T70{


    // 动态规划关键词：状态转移方程，状态定义，边界条件，
    // 实现状态转移方程可以用递归也可以用迭代，
    class Solution {

        // 状态转移方程：dp[i] = dp[i - 1] + dp[i - 2];
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }
}
