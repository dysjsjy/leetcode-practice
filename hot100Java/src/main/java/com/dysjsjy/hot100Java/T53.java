package com.dysjsjy.hot100Java;

public class T53 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int ans = Integer.MIN_VALUE;
            int preSum = 0;
            int minSum = 0;
            for (int num : nums) {
                preSum += num;
                ans = Math.max(ans, preSum - minSum);
                minSum = Math.min(minSum, preSum);
            }
            return ans;
        }
        //时间复杂对（n），空间复杂度（1）。

        public int maxSubArray2(int[] nums) {
            int[] f = new int[nums.length];
            f[0] = nums[0];
            int ans = f[0];
            for (int i = 1; i < nums.length; i++) {
                f[i] = Math.max(f[i - 1], 0) + nums[i];
                ans = Math.max(ans, f[i]);
            }
            return ans;
        }
        //时间复杂度（n），空间复杂度（1）。
    }
}

/*
前缀和动态规划经典题目
 */
