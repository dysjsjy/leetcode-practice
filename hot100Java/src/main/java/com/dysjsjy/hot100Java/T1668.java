package com.dysjsjy.hot100Java;

// 也算hot100中的一道奇葩题了

/*
给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。

给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
看着像简题实际上是动态规划，
 */
public class T1668 {
    class Solution {
        public int maxRepeating(String sequence, String word) {
            int n = sequence.length(), m = word.length();
            int[] dp = new int[n + 1];
            int ans = 0;

            for (int i = 1; i <= n; i++) {
                if (i - m < 0) {
                    continue;
                }
                if (sequence.substring(i - m, i).equals(word)) {
                    dp[i] = dp[i - m] + 1;
                }
                ans = Math.max(ans, dp[i]);
            }

            return ans;
        }
    }
}
