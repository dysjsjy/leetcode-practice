package com.dysjsjy.hot100Java;

public class T121 {

    // 贪心基本流程：预处理，初始化，迭代选择，返回结果
    // 关键词：局部最优，无回溯
    class Solution {
        // 解法一
        public int maxProfit(int[] prices) {
            // 预处理，这里不需要预处理

            // 初始化，初始化变量
            int ans = 0;
            int minPrice = prices[0];

            // 迭代选择
            for (int p : prices) {
                // 在迭代选择中选择局部最优
                ans = Math.max(ans, p - minPrice);
                minPrice = Math.min(minPrice, p);
            }

            // 返回结果
            return ans;
        }

        // 时间复杂度（n），空间复杂度（1）。


        // 解法二
        public int maxProfit2(int[] prices) {
            int ans = 0;
            int[] sample = new int[prices.length + 1];
            for (int i = 1; i < prices.length; i++) {
                sample[i] = Math.max(0, sample[i - 1] + prices[i] - prices[i - 1]);
                ans = Math.max(ans, sample[i]);
            }

            return ans;
        }
    }
}
