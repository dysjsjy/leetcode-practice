package com.jn.monotoneStack;


import java.util.Deque;
import java.util.LinkedList;

/*
739. 每日温度
中等
相关标签
相关企业
提示
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer
，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class ms739 {
    //使用单调栈，从栈头到栈底递增
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] result = new int[temperatures.length];

        stack.push(0);

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < temperatures[stack.peek()]) {
                stack.push(i);
            } else if (temperatures[i] == temperatures[stack.peek()]) {
                stack.push(i);
            } else if (temperatures[i] > temperatures[stack.peek()]) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return result;
    }
}
