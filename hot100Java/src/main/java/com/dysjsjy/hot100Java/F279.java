package com.dysjsjy.hot100Java;

import java.lang.reflect.Array;
import java.util.Arrays;

public class F279 {


    class Solution {

        // 动态规划完全背包问题
        public int numSquares(int n) {
            int[] dp = new int[n + 1];

            Arrays.fill(dp, Integer.MAX_VALUE);

            dp[0] = 0;

            // i列举物品，j列举背包容量
            for (int i = 1; i * i <= n; i++) {
                for (int j = i * i; j <= n; j++) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
            /*
                状态转移方程：dp[j] = Math.min(dp[j], dp[j - i * i] + 1)，
                dp[j]表示不选当前物品，dp[j - i * i]表示选当前物品
             */

            return dp[n];
        }
    }
}
