package com.jn.monotoneStack;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
496. 下一个更大元素 I
简单
相关标签
相关企业
nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。

给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。

对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。

返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。


 */
public class ms496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
    //看错了，不是求下一个更大的元素距离当前元素多远，而是下一个更大的元素是啥
    //错误示范
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new LinkedList<Integer>();

        stack.push(0);

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] < nums2[stack.peek()]) {
                stack.push(i);
            } else if (nums2[i] == nums2[stack.peek()]) {
                stack.push(i);
            } else if (nums2[i] > nums2[stack.peek()]) {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    map.put(nums2[i], i - stack.peek());
                    stack.pop();
                }
                stack.push(i);
            }
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(nums1[i]) == null ? -1 : map.get(nums1[i]);
        }

        return result;
    }
}
