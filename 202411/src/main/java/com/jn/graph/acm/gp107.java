package com.jn.graph.acm;

import java.util.Scanner;

/*
107. 寻找存在的路径
题目描述

给定一个包含 n 个节点的无向图中，节点编号从 1 到 n （含 1 和 n ）。

你的任务是判断是否有一条从节点 source 出发到节点 destination 的路径存在。

输入描述

第一行包含两个正整数 N 和 M，N 代表节点的个数，M 代表边的个数。

后续 M 行，每行两个正整数 s 和 t，代表从节点 s 与节点 t 之间有一条边。

最后一行包含两个正整数，代表起始节点 source 和目标节点 destination。
 */
//用查并集的方法求路径是否可达
public class gp107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        DisJoin disJoin = new DisJoin(n + 1);

        for (int i = 0; i < m; i++) {
            disJoin.join(scanner.nextInt(), scanner.nextInt());
        }

        if (disJoin.isSame(scanner.nextInt(), scanner.nextInt())) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    //查并集模板
    static class DisJoin {
        private int[] father;

        public DisJoin(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int find(int n) {
            return n == father[n] ? n : (father[n] = find(father[n]));
        }

        public void join(int n, int m) {
            n = find(n);
            m = find(m);
            if (n == m) return;
            father[m] = n;
        }

        public boolean isSame(int n, int m) {
            n = find(n);
            m = find(m);
            return n == m;
        }
    }
}
