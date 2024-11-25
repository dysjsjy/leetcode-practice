package com.jn.slidingwindow;


import java.util.Arrays;

/*
1838. 最高频元素的频数
中等
相关标签
相关企业
提示
元素的 频数 是该元素在一个数组中出现的次数。

给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。

执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 */
public class sd1838 {
    //注意curSum使用int溢出问题
    //在每一轮次中选择累加的过程可以转换到一段过程的总累加和
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); // O(n log n)
        int left = 0;
        long curSum = 0; // 使用 long 避免溢出
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];

            // 缩小窗口直到满足条件
            while ((long)(right - left + 1) * nums[right] - curSum > k) {
                curSum -= nums[left];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
