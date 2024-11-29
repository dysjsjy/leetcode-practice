package com.jn.slidingwindow;


/*
1574. 删除最短的子数组使剩余数组有序
1932
中等
相关标签
相关企业
提示
给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。

一个子数组指的是原数组中连续的一个子序列。

请你返回满足题目要求的最短子数组的长度。
 */
public class sd1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == n - 1) return 0;

        int right = n - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        int minLen = Math.min(n - left - 1, right);

        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minLen = Math.min(minLen, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return minLen;
    }
}
//感觉1900分的都不会直接暴力破解，或者很模板化的，一般都有几个知识点的组合或者，比较巧的方法降低复杂度