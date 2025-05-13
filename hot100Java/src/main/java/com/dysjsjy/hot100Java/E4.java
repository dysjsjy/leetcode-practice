package com.dysjsjy.hot100Java;

import java.util.*;

public class E4 {

}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 为了简化处理，始终对较短的数组做二分
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        // 二分搜索的起始范围
        int left = 0;
        int right = m;

        // 总共左边应有的元素个数（向下取整）
        int totalLeft = (m + n + 1) / 2;

        while (left <= right) {
            // 在 nums1 中切 i 个，nums2 中切 j 个
            int i = (left + right) / 2;
            int j = totalLeft - i;

            // 边界判断：如果没有左边元素，视作负无穷；如果没有右边元素，视作正无穷
            int nums1LeftMax  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int nums2LeftMax  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // 检查是否是一个合法的划分
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // 找到正确的切分点
                if ((m + n) % 2 == 1) {
                    // 奇数，总元素数是奇数，中位数就是左边最大值
                    return Math.max(nums1LeftMax, nums2LeftMax);
                } else {
                    // 偶数，总元素数是偶数，中位数是左右中间两个数的平均
                    return (Math.max(nums1LeftMax, nums2LeftMax)
                            + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                }
            } else if (nums1LeftMax > nums2RightMin) {
                // i 太大了，要往左边收缩
                right = i - 1;
            } else {
                // i 太小了，要往右边扩展
                left = i + 1;
            }
        }

        // 理论上永远不会到这里
        throw new IllegalArgumentException("输入数组不合法");
    }
}
