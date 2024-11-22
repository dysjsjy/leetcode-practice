package com.jn.slidingwindow;


/*
2730. 找到最长的半重复子字符串
中等
相关标签
相关企业
提示
给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。

如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串 t 是 半重复的 。例如，"0010" 、"002020" 、"0123" 、"2002" 和 "54944" 是半重复字符串，而 "00101022" （相邻的相同数字对是 00 和 22）和 "1101234883" （相邻的相同数字对是 11 和 88）不是半重复字符串。

请你返回 s 中最长 半重复
子字符串
 的长度。
 */
public class sd2730 {
    //正确示范
    public int longestSemiRepetitiveSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int left = 0;
        int count = 0;  // 记录连续重复的次数
        int maxResult = 0;

        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right) == s.charAt(right - 1)) { // 检查是否连续重复
                count++;
            }

            while (count > 1) { // 如果重复字符超过1对，调整窗口
                if (s.charAt(left) == s.charAt(left + 1)) {
                    count--;
                }
                left++;
            }

            maxResult = Math.max(maxResult, right - left + 1);
        }

        return maxResult;
    }
}

//错误示范
/*
public int longestSemiRepetitiveSubstring(String s) {

        if (s.length() == 1) return 1;

        int left = 0;
        char before = s.charAt(0);
        int count = 0;
        int maxResult = 0;

        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right) == before) {
                count++;
            }

            while (count > 1) {
            //这里的统计毫无意义，并没有统计出前面重复的序列
            //实际上只需要比较s.charAt(left)和s.charAt(left + 1)
                if (s.charAt(left) == before) {
                    count--;
                }
                left++;
            }

            before = s.charAt(right);

            maxResult = Math.max(maxResult, right - left - 1);
        }

        return maxResult;
    }
 */

