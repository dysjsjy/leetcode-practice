package com.jn.dynamic;


/*
718. 最长重复子数组
中等
相关标签
相关企业
提示
给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class dy718 {
    //动态规划
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int maxResult = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                if (dp[i][j] > maxResult) {
                    maxResult = dp[i][j];
                }
            }
        }

        return maxResult;
    }

    //暴力解法
    public int findLength2(int[] nums1, int[] nums2) {
        int maxResult = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int n1 = i;
                    int n2 = j;
                    int count = 0;
                    while (n1 < nums1.length && n2 < nums2.length && nums1[n1] == nums2[n2]) {
                        n1++;
                        n2++;
                        count++;
                        maxResult = Math.max(maxResult, count);
                    }
                }
            }
        }

        return maxResult;
    }


}
