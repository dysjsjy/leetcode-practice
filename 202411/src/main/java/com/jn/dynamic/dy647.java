package com.jn.dynamic;


/*
647. 回文子串
中等
相关标签
相关企业
提示
给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

回文字符串 是正着读和倒过来读一样的字符串。

子字符串 是字符串中的由连续字符组成的一个序列。
 */
public class dy647 {
    //双指针法
    public int countSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int result = 0;

        for (int i = 0; i < charArray.length; i++) {
            result += countS(charArray, i, i);
            result += countS(charArray, i, i + 1);
        }
        return result;
    }
    int countS(char[] chars, int i, int j) {
        int result = 0;

        //注意这里的判断要写在while里
        while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
            result++;
            i--;
            j++;
        }
//        如果写成这样有个问题，如果字串不是回文串那么以这个串扩展出的串都不可能是回文串了
//        while (i >= 0 && j < chars.length) {
//            if (chars[i] == chars[j]) {
//                result++;
//            }
//            i--;
//            j++;
//        }

        return result;
    }
    //动态规划法
    public int countSubstrings3(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return result;
    }

    //错误示范
    public int countSubstrings2(String s) {
        String rs = "";
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            rs += s.charAt(i);
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rs.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[n][n];
    }
}