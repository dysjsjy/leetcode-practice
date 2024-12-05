package com.jn.monotoneStack;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

/*
503. 下一个更大元素 II
中等
相关标签
相关企业
给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。

数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 */
public class ms503 {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return new int[]{-1};
        }

        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        int n = nums.length;

        Arrays.fill(res, -1);

        stack.push(0);

        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[i%n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i%n];
            }

            //存入栈的目的是找到下一个比它更大的元素，在第二轮中重复存入会重复计算
            if (i < n) {
                stack.push(i);
            }
        }

        return res;
    }
    //错误示范
    public int[] nextGreaterElements2(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[nums.length];
        int n = nums.length;

        for (int i = 0; i < n * 2; i++) {
            if (nums[i%n] < stack.peek()) {
                stack.push(nums[i%n]);
            } else if (nums[i%n] == stack.peek()) {
                stack.push(nums[i%n]);
            } else if (nums[i%n] > stack.peek()) {
                while (!stack.isEmpty() && nums[i%n] > stack.peek()) {
                    result[i%n] = stack.pop();
                }
                stack.push(nums[i%n]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == 0) result[i] = -1;
        }

        return result;
    }
}
