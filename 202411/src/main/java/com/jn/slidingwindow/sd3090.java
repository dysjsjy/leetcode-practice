package com.jn.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
3090. 每个字符最多出现两次的最长子字符串
简单
相关标签
相关企业
提示
给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该
子字符串
的 最大 长度。
 */
public class sd3090 {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxResult = 0;

        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);

            map.put(cur, map.getOrDefault(cur, 0) + 1);

            while (map.get(cur) > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {map.remove(leftChar);}
                left++;
            }

            maxResult = Math.max(maxResult, right - left + 1);
        }

        return maxResult;
    }

    public int maximumLengthSubstring2(String s) {
        int left = 0;
        int[] lookup = new int[26];
        int maxResult = 0;

        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            lookup[cur - 'a']++;

            while (lookup[cur - 'a'] > 2) {
                char leftChar = s.charAt(left);
                lookup[leftChar - 'a']--;

                left++;
            }

            maxResult = Math.max(maxResult, right - left + 1);
        }

        return maxResult;
    }
}
//map有时候后可以用数组代替