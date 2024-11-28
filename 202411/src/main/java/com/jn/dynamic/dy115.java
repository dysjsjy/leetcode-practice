package com.jn.dynamic;


/*
115. 不同的子序列
困难
相关标签
相关企业
给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
 */
//没怎么看懂
public class dy115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i < t.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
