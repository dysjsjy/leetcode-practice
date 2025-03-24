package com.dysjsjy.hot100Java;

import java.util.Arrays;

public class F494 {


    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int s = 0;
            for (int x : nums) {
                s += x;
            }
            s -= Math.abs(target);
            if (s < 0 || s % 2 == 1) {
                return 0;
            }
            int m = s / 2;
            int n = nums.length;

            int[][] f = new int[n + 1][m + 1];
            f[0][0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= m; j++) {
                    if (j < nums[i]) {
                        f[i + 1][j] = f[i][j];
                    } else {
                        f[i + 1][j] = f[i][j] + f[i][j - nums[i]];
                    }
                }
            }

            return f[n][m];
        }
    }
}
