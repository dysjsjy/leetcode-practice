package com.jn.slidingwindow;


/*
1234. 替换子串得到平衡字符串
中等
相关标签
相关企业
提示
有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。

假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。

你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。

请返回待替换子串的最小可能长度。

如果原字符串自身就是一个平衡字符串，则返回 0。
 */
public class sd1234 {
    public int balancedString(String s) {
        int countQ = 0;
        int countW = 0;
        int countE = 0;
        int countR = 0;

        char[] chars = s.toCharArray();
        int n = chars.length;
        int k = n/4;

        for (int i = 0; i < n; i++) {
            if (chars[i] == 'Q') {
                countQ++;
            }
            if (chars[i] == 'W') {
                countW++;
            }
            if (chars[i] == 'E') {
                countE++;
            }
            if (chars[i] == 'R') {
                countR++;
            }
        }

        if (countQ <= k && countW <= k && countE <= k && countR <= k) {
            return 0;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            if (chars[right] == 'Q') {
                countQ--;
            }
            if (chars[right] == 'W') {
                countW--;
            }
            if (chars[right] == 'E') {
                countE--;
            }
            if (chars[right] == 'R') {
                countR--;
            }

            while (countQ <= k && countW <= k && countE <= k && countR <= k) {
                minLen = Math.min(minLen, right - left + 1);
                if (chars[left] == 'Q') {
                    countQ++;
                }
                if (chars[left] == 'W') {
                    countW++;
                }
                if (chars[left] == 'E') {
                    countE++;
                }
                if (chars[left] == 'R') {
                    countR++;
                }
                left++;
            }
        }

        return minLen;
    }
}
