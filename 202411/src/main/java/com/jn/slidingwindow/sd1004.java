package com.jn.slidingwindow;


/*
1004. 最大连续1的个数 III
中等
相关标签
相关企业
提示
给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class sd1004 {
    public int longestOnes(int[] nums, int k) {
        int maxResult = 0;
        int count1 = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 1) {
                count1++;
            }

            while (count1 > k) {
                if (nums[left] != 1) {
                    count1--;
                }
                left++;
            }

            maxResult = Math.max(maxResult, right - left + 1);
        }

        return maxResult;
    }
}
