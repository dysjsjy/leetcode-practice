package com.jn.graph.acm;

import java.util.Arrays;
import java.util.Scanner;

/*
dijkstra（朴素版）精讲
卡码网：47. 参加科学大会

【题目描述】

小明是一位科学家，他需要参加一场重要的国际科学大会，以展示自己的最新研究成果。

小明的起点是第一个车站，终点是最后一个车站。然而，途中的各个车站之间的道路状况、交通拥堵程度以及可能的自然因素（如天气变化）等不同，这些因素都会影响每条路径的通行时间。

小明希望能选择一条花费时间最少的路线，以确保他能够尽快到达目的地。

【输入描述】

第一行包含两个正整数，第一个正整数 N 表示一共有 N 个公共汽车站，第二个正整数 M 表示有 M 条公路。

接下来为 M 行，每行包括三个整数，S、E 和 V，代表了从 S 车站可以单向直达 E 车站，并且需要花费 V 单位的时间。

【输出描述】

输出一个整数，代表小明从起点到终点所花费的最小时间。
 */
public class gp47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] grid = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
            grid[i][i] = 0; // 自身到自身的距离为0
        }

        for (int i = 0; i < m; i++) {
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            int val = scanner.nextInt();
            grid[p1][p2] = val;
        }

        int start = 1;
        int end = n;

        //存储从源点到每个节点的最短距离
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        //记录顶点是否被访问过
        boolean[] visited = new boolean[n + 1];

        //起始节点到自身的距离为0
        minDist[start] = 0;

        for (int i = 1; i <= n; i++) {//遍历所有节点，循环需要进行n次
            int minVal = Integer.MAX_VALUE;
            int cur = -1;

            //1.选择距离源节点最近且未被访问过的节点
            for (int v = 1; v <= n; v++) {
                if (!visited[v] && minDist[v] < minVal) {
                    minVal = minDist[v];
                    cur = v;
                }
            }

            if (cur == -1) break;

            visited[cur] = true;//2. 记录该节点已经被访问

            //3. 第三步，更新非访问节点到源节点的距离
            for (int v = 1; v <= n; v++) {
                if (!visited[v] && grid[cur][v] != Integer.MAX_VALUE) {
                    minDist[v] = Math.min(minDist[v], minDist[cur] + grid[cur][v]);
                }
            }
        }

        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDist[end]);
        }
    }
}
