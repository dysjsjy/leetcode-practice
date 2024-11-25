package com.jn.slidingwindow;

/*
1658. 将 x 减到 0 的最小操作数
中等
相关标签
相关企业
提示
给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。

如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 */
public class sd1658 {
    //正确是示范，求首位的可以转换成求中间的
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0) return -1;

        int n = nums.length;
        int left = 0, currentSum = 0, maxLen = -1;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return  maxLen == -1 ? -1 : n - maxLen;
    }
    //错误示范2
    public int minOperations2(int[] nums, int x) {
        int cur = nums.length - 1;
        int sum = 0;

        for (; sum < x && cur >= 0; cur--) {
            sum += nums[cur];
        }

        if (sum == x) return nums.length - cur;

        int k = nums.length - cur;

        while (sum != x && cur < 2 *nums.length) {
            sum -= nums[cur % nums.length];
            sum += nums[(cur + k) % nums.length];
            cur++;
        }
        return 0;
    }
    //错误示范1
    public int minOperations1(int[] nums, int x) {
        int sum = 0;
        int right = 0;

        while (sum < x && right < nums.length) {
            sum += nums[right];
            right++;
        }

        if (sum == x) return right;

        int left = nums.length - 1;

        while (sum > x && left >= 0) {
            sum += nums[left];
            left--;
            if (right >= 0) {
                sum -= nums[right];
                right--;
            }
        }

        if (sum == x) return right + nums.length - left;

        return -1;
    }
}
