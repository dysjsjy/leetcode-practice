package com.dysjsjy.ox3f.MonotoneStack;

import java.util.*;

public class S901 {

    public static void main(String[] args) {
// Queue示例
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");  // 插入元素
        queue.offer("B");
        String head = queue.poll();  // 移除并返回头部元素
        String peek = queue.peek();  // 查看但不移除头部元素
        System.out.println(head);
        System.out.printf("%s\n", peek);
// Deque示例
        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst("A");  // 头部插入
        deque.offerLast("B");   // 尾部插入
        String first = deque.pollFirst();  // 头部移除
        String last = deque.pollLast();    // 尾部移除
        System.out.println(first);
        System.out.println(last);
        System.out.println(deque);
// 栈操作示例
        Deque<String> stack = new ArrayDeque<>();
        stack.push("A");  // 压栈
        stack.push("B");
        String top = stack.pop();  // 弹栈
        System.out.println(top);
        System.out.println(stack);
    }
}

// 及时去掉无用的数据，保证栈中的数据有序
// 尽量不要在一步中实现多部逻辑
// 在linkedlist中push和offer不同，
class StockSpanner {

    Deque<Integer[]> stack = new LinkedList<>();
    int curDay = -1;

    public StockSpanner() {
        stack.offer(new Integer[]{-1, Integer.MAX_VALUE});
    }

    public int next(int price) {
        while (price > stack.peek()[0]) {
            stack.pop();
        }
        int ans = ++curDay - stack.peek()[0];
        stack.offer(new Integer[]{ans, price});
        return ans;
    }
}