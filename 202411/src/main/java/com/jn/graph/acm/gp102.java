package com.jn.graph.acm;

import java.util.Scanner;


/*
题目描述：

给定一个由 1（陆地）和 0（水）组成的矩阵，岛屿指的是由水平或垂直方向上相邻的陆地单元格组成的区域，且完全被水域单元格包围。孤岛是那些位于矩阵内部、所有单元格都不接触边缘的岛屿。

现在你需要将所有孤岛“沉没”，即将孤岛中的所有陆地单元格（1）转变为水域单元格（0）。

输入描述：

第一行包含两个整数 N, M，表示矩阵的行数和列数。

之后 N 行，每行包含 M 个数字，数字为 1 或者 0，表示岛屿的单元格。

输出描述

输出将孤岛“沉没”之后的岛屿矩阵。
 */
public class gp102 {
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (graph[i][0] == 1) {
                dfs(visited, i, 0, graph);
            }
            if (graph[i][m - 1] == 1) {
                dfs(visited, i, m - 1, graph);
            }
        }

        for (int i = 0; i < m; i++) {
            if (graph[0][i] == 1) {
                dfs(visited, 0, i, graph);
            }
            if (graph[n - 1][i] == 1) {
                dfs(visited, n - 1, i, graph);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(boolean[][] visited, int x, int y, int[][] graph) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if (nextX < 0 || nextY < 0 || nextX > graph.length - 1 || nextY > graph[0].length - 1 || visited[nextX][nextY]) {
                continue;
            }

            if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                dfs(visited, nextX, nextY, graph);
            }
        }
    }
}
