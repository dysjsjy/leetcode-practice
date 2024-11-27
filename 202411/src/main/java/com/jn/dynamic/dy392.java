package com.jn.dynamic;


/*
392. 判断子序列
简单
相关标签
相关企业
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

进阶：

如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

致谢：

特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 */
public class dy392 {
    //方法一
    public boolean isSubsequence(String s, String t) {
        if ("".equals(s)) {
            return true;
        }

        if (t.length() < s.length() || "".equals(t)) {
            return false;
        }


        char[] left = s.toCharArray();
        char[] right = t.toCharArray();
        int j = 0;

        for (int i = 0; i < right.length; i++) {
            if (right[i] == left[j]) {
                j++;
            }

            if (j >= left.length) {
                return true;
            }
        }

        return false;
    }
    //方法二
    public boolean isSubsequence1(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //这里因为s不能删除所以只要写删除t的部分
                    //dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[s.length()][t.length()] >= s.length();
    }
}
