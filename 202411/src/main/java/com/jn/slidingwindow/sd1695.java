package com.jn.slidingwindow;


import java.util.HashSet;
import java.util.Set;

/*
1695. 删除子数组的最大得分
中等
相关标签
相关企业
提示
给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。

返回 只删除一个 子数组可获得的 最大得分 。

如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 */
public class sd1695 {
    //正确示范
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, maxResult = 0, currentSum = 0;
        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            int cur = nums[right];

            // 如果当前元素已经在窗口内，移动左指针以移除重复元素
            while (set.contains(cur)) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // 将当前元素加入窗口
            set.add(cur);
            currentSum += cur;

            // 更新最大得分
            maxResult = Math.max(maxResult, currentSum);
        }

        return maxResult;
    }


    //错误示范
    public int f2(int[] nums) {
        int left = 0, curSum = 0, maxResult = 0;
        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            int cur = nums[right];

            while (set.contains(cur)) {
                set.remove(nums[left]);
                //这里的curSum -= nums[left]发送在left++之后会导致减去错误的值
                left++;
                curSum -= nums[left];
            }

            set.add(cur);
            curSum += cur;

            maxResult = Math.max(maxResult, curSum);
        }

        return maxResult;
    }
}
