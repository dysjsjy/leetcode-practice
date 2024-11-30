package com.jn.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/*
2962. 统计最大元素出现至少 K 次的子数组
中等
相关标签
相关企业
给你一个整数数组 nums 和一个 正整数 k 。

请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。

子数组是数组中的一个连续元素序列。
 */
public class sd2962 {
    public long countSubarrays(int[] nums, int k) {
        long aws = 0;
        int maxInt = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > maxInt) maxInt = num;
        }

        int countMaxInt = 0;
        int left = 0;

        for (int num : nums) {
            if (num == maxInt) countMaxInt++;

            //注意这里的==，想想为什么不能填>
            while (countMaxInt == k) {
                if (nums[left] == maxInt) countMaxInt--;
                left++;
            }

            aws += left;
        }

        return aws;
    }

    public long countSubarrays2(int[] nums, int k) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        long ans = 0;
        int cntMx = 0, left = 0;
        for (int x : nums) {
            if (x == mx) {
                cntMx++;
            }
            while (cntMx == k) {
                if (nums[left++] == mx) {
                    cntMx--;
                }
            }
            ans += left;
        }
        return ans;
    }

//    作者：灵茶山艾府
//    链接：https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/solutions/2560940/hua-dong-chuang-kou-fu-ti-dan-pythonjava-xvwg/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
