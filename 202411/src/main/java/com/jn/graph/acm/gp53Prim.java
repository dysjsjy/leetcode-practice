package com.jn.graph.acm;

import java.util.Arrays;
import java.util.Scanner;

/*
53. 寻宝（第七期模拟笔试）
题目描述
在世界的某个区域，有一些分散的神秘岛屿，每个岛屿上都有一种珍稀的资源或者宝藏。国王打算在这些岛屿上建公路，方便运输。

不同岛屿之间，路途距离不同，国王希望你可以规划建公路的方案，如何可以以最短的总公路距离将 所有岛屿联通起来（注意：这是一个无向图）。

给定一张地图，其中包括了所有的岛屿，以及它们之间的距离。以最小化公路建设长度，确保可以链接到所有岛屿。

输入描述
第一行包含两个整数V 和 E，V代表顶点数，E代表边数 。顶点编号是从1到V。例如：V=2，一个有两个顶点，分别是1和2。

接下来共有 E 行，每行三个整数 v1，v2 和 val，v1 和 v2 为边的起点和终点，val代表边的权值。

输出描述
输出联通所有岛屿的最小路径总距离
 */
//最小生成树prim算法，prim算法的结束条件并不是所有节点都访问而是循环运行v-1次

public class gp53Prim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();

        //初始化邻接矩阵
        int[][] grid = new int[v + 1][v + 1];
        for (int i = 0; i <= v; i++) {
            Arrays.fill(grid[i], 10001);
        }

        //读取每条边的信息并填充邻接矩阵
        for (int i = 0; i < e; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int k = scanner.nextInt();

            grid[x][y] = k;
            grid[y][x] = k;
        }

        //所有节点到最小生成树的最小距离
        int[] minDist = new int[v + 1];
        Arrays.fill(minDist, 10001);

        //记录节点是否在树里
        boolean[] isInTree = new boolean[v + 1];

        //prim算法主循环
        for (int i = 1; i < v; i++) {
            int cur = -1;
            int minVal = Integer.MAX_VALUE;

            //选择距离生成树最近的节点
            for (int j = 1; j <= v; j++) {
                if (!isInTree[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    cur = j;
                }
            }

            isInTree[cur] = true;

            //更新非生成树的节点到生成树的距离
            for (int j = 1; j <= v; j++) {
                if (!isInTree[j] && grid[cur][j] < minDist[j]) {
                    minDist[j] = grid[cur][j];
                }
            }
        }

        //统计结果
        int result = 0;
        //不统计第一个节点，因为第一个节点是起始节点
        for (int i = 2; i <= v; i++) {
            result += minDist[i];
        }

        System.out.println(result);
        scanner.close();
    }
}
