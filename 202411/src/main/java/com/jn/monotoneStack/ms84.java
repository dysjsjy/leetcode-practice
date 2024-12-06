package com.jn.monotoneStack;


import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

/*
84. 柱状图中最大的矩形
困难
相关标签
相关企业
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class ms84 {
    //暴力解法
    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int lh = i;
            int rh = i;

            for (; lh >= 0; lh--) {
                if (heights[i] > heights[lh]) {
                    break;
                }
            }

            for (; rh < n; rh++) {
                if (heights[i] > heights[rh]) {
                    break;
                }
            }

            int w = rh - lh - 1;
            int h = heights[i];
            max = Math.max(w*h, max);
        }

        return max;
    }

    //双指针法
    public int largestRectangleArea2(int[] heights) {
        //记录每个矩形左边右边第一个小于它的矩形下标
        int max = Integer.MIN_VALUE;
        int n = heights.length;
        int[] minLeftIndex = new int[heights.length];
        int[] minRightIndex = new int[heights.length];

        minLeftIndex[0] = -1;
        for (int i = 1; i < n; i++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) {
                //注意这里的minLeftIndex[t]代表的是最近的一个小于下表t的方块的下标
                t = minLeftIndex[t];
            }
            minLeftIndex[i] = t;
        }

        minRightIndex[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < n && heights[t] >= heights[i]) {
                t = minRightIndex[t];
            }
            minRightIndex[i] = t;
        }

        for (int i = 0; i < n; i++) {
            int w = minRightIndex[i] - minLeftIndex[i] - 1;
            int h = heights[i];
            max = Math.max(max, w*h);
        }

        return max;
    }
    //单调栈
    public int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int[] newheights = IntStream.concat(IntStream.concat(IntStream.of(0), IntStream.of(heights)), IntStream.of(0)).toArray();
        Deque<Integer> stack = new LinkedList<>();
        int n = newheights.length;

        stack.push(0);

        for (int i = 1; i < n; i++) {
            if (newheights[i] > newheights[stack.peek()]) {
                stack.push(i);
            } else if (newheights[i] == newheights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else if (newheights[i] < newheights[stack.peek()]) {
                while (!stack.isEmpty() && newheights[i] < newheights[stack.peek()]) {
                    int mid = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int h = newheights[mid];
                        int w = i - stack.peek() - 1;
                        max = Math.max(max, h*w);
                    }
                }
                stack.push(i);
            }
        }

        return max;
    }
}
