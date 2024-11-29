package com.jn.dynamic;


/*
583. 两个字符串的删除操作
中等
相关标签
相关企业
给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。

每步 可以删除任意一个字符串中的一个字符。
 */
public class dy583 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
/*
dp[i][j]代表的就是：此时word1[i - 1]，长也长i - 1，word2[j - 1]，长也长j - 1
当word1.charAt(i - 1) == word2.charAt(j - 1)相等了，就不用删除，也就是在
等于dp[i - 1][j - 1]了，等于两个字符同时删去最后一个字符的需要删除的数量
 */
