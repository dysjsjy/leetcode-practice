package com.dysjsjy.hot100Java;


import java.util.HashSet;
import java.util.Set;

public class F3 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int[] cnt = new int[128];
            int l = 0;
            int ans = 0;

            for (int r = 0; r < chars.length; r++) {
                cnt[chars[r]]++;
                while (cnt[chars[r]] > 1) {
                    cnt[chars[l]]--;
                    l++;
                }

                ans = Math.max(ans, r - l + 1);
            }

            return ans;
        }

        public int lengthOfLongestSubstring2(String s) {
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            int l = 0;
            int ans = 0;

            for (int r = 0; r < chars.length; r++) {
                char c = chars[r];
                while (set.contains(c)) {
                    set.remove(chars[l]);
                    l++;
                }
                set.add(c);
                ans = Math.max(ans, r - l + 1);
            }

            return ans;
        }
    }
}
