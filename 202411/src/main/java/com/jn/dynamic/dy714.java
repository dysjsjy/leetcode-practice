package com.jn.dynamic;


/*
714. 买卖股票的最佳时机含手续费
中等
相关标签
相关企业
提示
给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class dy714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],
                    Math.max(dp[i - 1][1] - prices[i] - fee, dp[i - 1][2] - prices[i] - fee));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }

        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
//三个状态，持有、已经卖出、当天卖出，在三个状态之间转移,其实也可以连个状态，持有和不持有，不持有包括已经卖出和当天卖出。
