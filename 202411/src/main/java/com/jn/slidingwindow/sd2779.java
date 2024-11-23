package com.jn.slidingwindow;

import java.util.Arrays;

/*
2779. 数组的最大美丽值
中等

相关标签
相关企业

提示
给你一个下标从 0 开始的整数数组 nums 和一个 非负 整数 k 。

在一步操作中，你可以执行下述指令：

在范围 [0, nums.length - 1] 中选择一个 此前没有选过 的下标 i 。
将 nums[i] 替换为范围 [nums[i] - k, nums[i] + k] 内的任一整数。
数组的 美丽值 定义为数组中由相等元素组成的最长子序列的长度。

对数组 nums 执行上述操作任意次后，返回数组可能取得的 最大 美丽值。

注意：你 只 能对每个下标执行 一次 此操作。

数组的 子序列 定义是：经由原数组删除一些元素（也可能不删除）得到的一个新数组，且在此过程中剩余元素的顺序不发生改变。
 */

//不定长滑动数组 + 区间覆盖
public class sd2779 {
    //正确示范
    public static int maximumBeauty(int[] nums, int k) {
        // 构造每个元素的区间范围
        int[][] ranges = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            ranges[i][0] = nums[i] - k; // 起始值
            ranges[i][1] = nums[i] + k; // 结束值
        }

        // 按区间起始值从小到大排序
        Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));

        // 使用滑动窗口找到最多重叠区间数
        int maxBeauty = 0;
        int left = 0;
        for (int right = 0; right < ranges.length; right++) {
            // 检查窗口范围
            //判断右边窗口的起始值是否已经超过左边窗口的结束值，left是左边窗口，right是右边窗口
            while (ranges[right][0] > ranges[left][1]) {
                left++; // 收缩窗口
            }
            // 窗口长度表示当前重叠区间数
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }

        return maxBeauty;
    }

    //错误示范
    public int maximumBeauty2(int[] nums, int k) {
        int maxResult = 0;
        int count = 0;
        int[][] temp = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            temp[i][0] = nums[i] - k;
            temp[i][1] = nums[i] + k;
        }

        Arrays.sort(temp, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (temp[j][0] < temp[i][1]) {
                    count++;
                } else {
                    count = 0;
                }
                maxResult = Math.max(maxResult, count);
            }
        }

        return maxResult;
    }
}
