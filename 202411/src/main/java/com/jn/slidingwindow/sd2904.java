package com.jn.slidingwindow;


/*
2904. 最短且字典序最小的美丽子字符串
中等
相关标签
相关企业
提示
给你一个二进制字符串 s 和一个正整数 k 。

如果 s 的某个子字符串中 1 的个数恰好等于 k ，则称这个子字符串是一个 美丽子字符串 。

令 len 等于 最短 美丽子字符串的长度。

返回长度等于 len 且字典序 最小 的美丽子字符串。如果 s 中不含美丽子字符串，则返回一个 空 字符串。

对于相同长度的两个字符串 a 和 b ，如果在 a 和 b 出现不同的第一个位置上，a 中该位置上的字符严格大于 b 中的对应字符，则认为字符串 a 字典序 大于 字符串 b 。

例如，"abcd" 的字典序大于 "abcc" ，因为两个字符串出现不同的第一个位置对应第四个字符，而 d 大于 c 。
 */
public class sd2904 {
    //不知道为啥这样还是错了
    public String smallestBeautifulSubstring(String s, int k) {
        int left = 0, right = 0; // 滑动窗口边界
        int n = s.length(); // 字符串长度
        if (n < k) return ""; // 字符串长度不足，直接返回空

        int oneCount = 0; // 当前窗口中 '1' 的数量
        int minLen = Integer.MAX_VALUE; // 最短美丽子字符串长度
        String minString = ""; // 保存结果

        // 滑动窗口遍历字符串
        while (right < n) {
            // 扩展窗口
            if (s.charAt(right) == '1') {
                oneCount++;
            }
            right++;

            // 收缩窗口，当窗口中 '1' 的数量大于 k 时
            while (oneCount > k) {
                if (s.charAt(left) == '1') {
                    oneCount--;
                }
                left++;
            }

            // 检查当前窗口是否满足条件
            if (oneCount == k) {
                int curLen = right - left;
                String curSubstring = s.substring(left, right); // 截取子字符串

                // 更新最小子字符串
                if (curLen < minLen || (curLen == minLen && curSubstring.compareTo(minString) < 0)) {
                    minLen = curLen;
                    minString = curSubstring;
                }
            }
        }

        // 如果没有找到美丽子字符串，返回空字符串
        return minLen == Integer.MAX_VALUE ? "" : minString;
    }

    //错误示范
    public String shortestBeautifulSubstring2(String s, int k) {
        String maxString = s;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            k -= s.charAt(right);

            while (k < 0) {
                k += s.charAt(left);
                left++;
            }

            String temp = s.substring(left, right + 1);
            if (temp.length() < maxString.length() || (temp.length() == maxString.length() && temp.compareTo(maxString) < 0)) {
                maxString = temp;
            }
        }

        return maxString;
    }
    //灵神
    public String shortestBeautifulSubstring3(String s, int k) {
        if (s.replace("0", "").length() < k) {
            return "";
        }
        char[] charArray = s.toCharArray();
        String ans = s;
        int cnt1 = 0, left = 0;
        for (int right = 0; right < charArray.length; right++) {
            cnt1 += charArray[right] - '0';
            while (cnt1 > k || charArray[left] == '0') {
                cnt1 -= charArray[left++] - '0';
            }
            if (cnt1 == k) {
                String t = s.substring(left, right + 1);
                if (t.length() < ans.length() || t.length() == ans.length() && t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
        }
        return ans;
    }
}