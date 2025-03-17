package com.jn.graph.acm;

import java.util.Arrays;

//java floyd
/*
Floyd算法的核心思想是动态规划。
它逐步考虑图中顶点的可能性,
检查每一对顶点之间的路径是否可以通过另一个顶点来缩短路径长度。
 */
public class gp97 {

    static final int INF = 100000;

    public static void main(String[] args) {
        //示例图的邻接矩阵
        int[][] graph = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };

        //调用floyd算法
        floydWarshall(graph);
    }

    public static void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        //初始化距离矩阵
        for (int i = 0; i < n; i++) {
            dist[i] = Arrays.copyOf(graph[i], n);
        }

        //核心算法，三重循环
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //更新dist[i][j]，判断是否通过k会更短
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist);
    }

    public static void printSolution(int[][] dist) {
        int n = dist.length;
        System.out.println("最短路径矩阵：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
