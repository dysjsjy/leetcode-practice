package com.jn.monotoneStack;


import java.util.Deque;
import java.util.LinkedList;

/*
42. 接雨水
困难
相关标签
相关企业
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class ms42 {
    //暴力破解法
    public int trap1(int[] height) {
        int sum = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
          if (i == 0 || i == n - 1) {
              continue;
          }

          int lheight = height[i - 1];
          int rheight = height[i + 1];

          for (int lh = i - 1; lh >= 0; lh--) {
              if (height[lh] > lheight) {
                  lheight = height[lh];
              }
          }

          for (int rh = i + 1; rh < n; rh++) {
              if (height[rh] > rheight) {
                  rheight = height[rh];
              }
          }

          int h = Math.min(lheight, rheight) - height[i];
          if (h > 0) {
              sum += h;
          }
        }

        return sum;
    }

    //双指针优化
    public int trap2(int[] height) {
        int n = height.length;
        int sum = 0;

        int[] lheight = new int[n];
        int[] rheight = new int[n];

        lheight[0] = height[0];
        rheight[n - 1] = height[n - 1];

        //记录每个元素左边最大元素
        for (int i = 1; i < n; i++) {
            lheight[i] = Math.max(lheight[i - 1], height[i]);
        }

        //记录每个元素右边最大的元素
        for (int i = n - 2; i >= 0; i--) {
            rheight[i] = Math.max(rheight[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                continue;
            }

            int h = Math.min(lheight[i], rheight[i]) - height[i];
            if (h > 0) {
                sum += h;
            }
        }

        return sum;
    }

    //单调栈
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            //注意这里的n-1会被取到，因为mid要取到n-2
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else if (height[i] > height[stack.peek()]) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int w = i - stack.peek() - 1;
                        int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                        /*
                        为什么w * h一定大于等于0？
                        w: i是有边界，stack.peek()是左边界一定大于等于0
                        h: height[i]一定大于height[mid]，height[stack.peek()]一定大于height[mid]在上一次循环判断
                         */
                        sum += w*h;
                    }
                }
                stack.push(i);
            }
        }

        return sum;
    }
}
