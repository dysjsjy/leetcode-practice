package com.jn.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/*
k516. 每种字符至少取 K 个
中等
相关标签
相关企业
提示
给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。

你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。


 */
public class sd2516 {
    //正确示范，其实map都可以用char[]代替，会快很多
    public int takeCharacters(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        freq.put('a', 0);
        freq.put('b', 0);
        freq.put('c', 0);

        for (char c : s.toCharArray()) {
            freq.put(c, freq.get(c) + 1);
        }

        if (freq.get('a') < k || freq.get('b') < k || freq.get('c') < k) {
            return -1;
        }

        int targetA = freq.get('a') - k;
        int targetB = freq.get('b') - k;
        int targetC = freq.get('c') - k;

        int left = 0, maxWindows = 0;
        Map<Character, Integer> windowFreq = new HashMap<>();

        windowFreq.put('a', 0);
        windowFreq.put('b', 0);
        windowFreq.put('c', 0);

        for (int right = 0; right < s.length(); right++) {
            windowFreq.put(s.charAt(right), windowFreq.get(s.charAt(right)) + 1);

            while (windowFreq.get('a') > targetA || windowFreq.get('b') > targetB || windowFreq.get('c') > targetC) {
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                left++;
            }

            maxWindows = Math.max(maxWindows, right - left + 1);
        }

        return s.length() - maxWindows;
    }

    //错误示范
    public int takeCharacters2(String s, int k) {
        char[] charArray = s.toCharArray();
        if (charArray.length < k * 3) {
            return -1;
        }

        int[] charCount = new int[3];
        int left = 0;
        int result = -1;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'a') {
                charCount[0]++;
            } else if (charArray[i] == 'b') {
                charCount[1]++;
            } else if (charArray[i] == 'c') {
                charCount[k]++;
            }
        }

        for (int right = 0; right < charArray.length; right++) {
            if (charArray[right] == 'a') {
                charCount[0]--;
            } else if (charArray[right] == 'b') {
                charCount[1]--;
            } else if (charArray[right] == 'c') {
                charCount[k]--;
            }

            while (charCount[0] < k || charCount[1] < k || charCount[k] < k) {
                if (charArray[left] == 'a') {
                    charCount[0]++;
                } else if (charArray[left] == 'b') {
                    charCount[1]++;
                } else if (charArray[left] == 'c') {
                    charCount[k]++;
                }
                left++;
            }

            if (charCount[0] == k && charCount[1] == k && charCount[k] == k) {
                result = charArray.length - (right - left + 1);
            }
        }

        return result;
    }
}
