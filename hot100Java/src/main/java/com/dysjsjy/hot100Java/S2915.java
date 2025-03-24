package com.dysjsjy.hot100Java;

import java.util.Arrays;
import java.util.List;

public class S2915 {

    class Solution {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            int[] f = new int[target + 1];
            Arrays.fill(f, Integer.MIN_VALUE);
            f[0] = 0;
            int s = 0;

            for (int x : nums) {
                s = Math.min(s + x, target);
                for (int j = s; j >= x; j--) {
                    f[j] = Math.max(f[j], f[j - x] + 1);
                }
            }

            return f[target] != Integer.MIN_VALUE ? f[target] : -1;
        }
    }
}
