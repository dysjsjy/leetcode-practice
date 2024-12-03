package com.jn.dynamic;


/*
516. 最长回文子序列
中等
相关标签
相关企业
给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。

子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。


 */
public class dy516 {
    //这个既有判断回文字串也有子序列的部分，就好像用不了求回文串的双指针法
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
//    int countSubseq(char[] chars, int i, int j) {
//        int count = 1;
//        for (int c : chars) {
//            while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
//                i--;
//                j++;
//                count += 2;
//            }
//        }
//
//        return count;
//    }
}
