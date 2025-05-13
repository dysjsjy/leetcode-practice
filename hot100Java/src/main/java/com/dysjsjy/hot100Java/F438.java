package com.dysjsjy.hot100Java;

import java.util.ArrayList;
import java.util.List;

public class F438 {

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            char[] chars1 = s.toCharArray();
            char[] chars2 = p.toCharArray();
            int[] cnt = new int[26];
            int current = 0;
            List<Integer> ans = new ArrayList<>();

            for (char c : chars2) {
                cnt[c - 'a']++;
            }

            for (int i = 0; i < Math.min(chars1.length, chars2.length); i++) {
                if (cnt[chars1[i] - 'a'] > 0) {
                    current++;
                }
                cnt[chars1[i] - 'a']--;
            }

            if (current == chars2.length) {
                ans.add(0);
            }

            for (int r = chars2.length; r < chars1.length; r++) {
                int left = chars1[r - chars2.length] - 'a';
                if (cnt[left] >= 0) {
                    current--;
                }
                cnt[left]++;
                int right = chars1[r] - 'a';
                if (cnt[right] > 0) {
                    current++;
                }
                cnt[right]--;
                if (current == chars2.length) {
                    ans.add(r - chars2.length + 1);
                }
            }
            return ans;
        }
    }
}
