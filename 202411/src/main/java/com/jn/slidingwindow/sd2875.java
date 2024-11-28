package com.jn.slidingwindow;


import java.util.ArrayList;
import java.util.List;

/*
2875. 无限数组的最短子数组
1914分
中等
相关标签
相关企业
提示
给你一个下标从 0 开始的数组 nums 和一个整数 target 。

下标从 0 开始的数组 infinite_nums 是通过无限地将 nums 的元素追加到自己之后生成的。

请你从 infinite_nums 中找出满足 元素和 等于 target 的 最短 子数组，并返回该子数组的长度。如果不存在满足条件的子数组，返回 -1 。
 */
public class sd2875 {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int fullCycle = (int) (target / totalSum);
        target %= totalSum;

        if (target == 0) {
            return fullCycle * n;
        }

        if (fullCycle == 0 && target > totalSum) {
            return -1;
        }

        int[] extendNums = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            extendNums[i] = nums[i%n];
        }

        int minLen = Integer.MAX_VALUE;
        int left = 0, sum = 0;

        for (int right = 0; right < n * 2; right++) {
            sum += extendNums[right];

            while (sum > target) {
                sum -= extendNums[left];
                left++;
            }

            if (sum == target) {
                minLen = Math.min(minLen, right - left + 1);
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : fullCycle * n + minLen;
    }
}
