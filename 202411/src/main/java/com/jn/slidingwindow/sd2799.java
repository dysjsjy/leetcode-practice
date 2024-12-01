package com.jn.slidingwindow;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
2799. 统计完全子数组的数目
中等
相关标签
相关企业
提示
给你一个由 正 整数组成的数组 nums 。

如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：

子数组中 不同 元素的数目等于整个数组不同元素的数目。
返回数组中 完全子数组 的数目。

子数组 是数组中的一个连续非空序列。
 */
public class sd2799 {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int k = set.size();
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // 当窗口内包含所有不同的元素时
            while (map.size() == k) {
//                // 确定当前窗口的完整子数组数目
//                result += nums.length - right;

                // 将 left 向右移动，缩小窗口
                //注意这不是map.put(nums[left], map.get(left) - 1)，粗心会写错
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            result += left;
        }

        return result;
    }
}
