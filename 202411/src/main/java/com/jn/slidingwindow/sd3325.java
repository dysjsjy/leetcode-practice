package com.jn.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/*
3325. 字符至少出现 K 次的子字符串 I
中等
相关标签
相关企业
提示
给你一个字符串 s 和一个整数 k，在 s 的所有子字符串中，请你统计并返回 至少有一个 字符 至少出现 k 次的子字符串总数。

子字符串 是字符串中的一个连续、 非空 的字符序列。
 */
public class sd3325 {
    public int numberOfSubstrings(String s, int k) {
        int result = 0;
        char[] charArray = s.toCharArray();
        int left = 0;
        int [] cnt = new int[26];

        for (char c : charArray) {
            cnt[c - 'a']++;
            //注意这里是>=k
            while(cnt[c - 'a'] >= k) {
                cnt[charArray[left] - 'a']--;
                left++;
            }
            result += left;
        }

        return result;
    }

    //错误示范
    public int numberOfSubstrings2(String s, int k) {
        char[] charArray = s.toCharArray();
        int[] countS = new int[26];
        int left = 0;
        int result = 0;

        for (int i = 0; i < charArray.length; i++) {
            countS[charArray[i] - 'a']++;

            while(isAllBigK(countS, k)) {
                countS[charArray[left] - 'a']--;
                left++;
            }

            result += left;
        }

        return result;
    }

    boolean isAllBigK(int[] countS, int k) {
        for (int count : countS) {
            if (count > k) {
                return true;
            }
        }

        return false;
    }
}
