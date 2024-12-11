package com.jn.graph.acm;

import java.util.Scanner;

/*
106. 岛屿的周长
卡码网题目链接（ACM模式）

题目描述

给定一个由 1（陆地）和 0（水）组成的矩阵，岛屿是被水包围，并且通过水平方向或垂直方向上相邻的陆地连接而成的。

你可以假设矩阵外均被水包围。在矩阵中恰好拥有一个岛屿，假设组成岛屿的陆地边长都为 1，请计算岛屿的周长。岛屿内部没有水域。

输入描述

第一行包含两个整数 N, M，表示矩阵的行数和列数。之后 N 行，每行包含 M 个数字，数字为 1 或者 0，表示岛屿的单元格。
 */
public class gp106 {
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //写了这么久Java突然忘记了Java中的变量都是按值传递的，除非是static，才会按引用
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    count = 0;
                    calculate(i, j, graph);
                    result += count;
                }
            }
        }

        System.out.println(result);
    }

    static void calculate(int i, int j, int[][] graph) {
        for (int k = 0; k < 4; k++) {
            int nextX = i + dir[k][0];
            int nextY = j + dir[k][1];

            if (nextX < 0 || nextY < 0 || nextX > graph.length - 1 || nextY > graph[0].length - 1 || graph[nextX][nextY] == 0) {
                count++;
            }
        }
    }
}
