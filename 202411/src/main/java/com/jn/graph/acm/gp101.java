package com.jn.graph.acm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
题目描述

给定一个由 1（陆地）和 0（水）组成的矩阵，岛屿指的是由水平或垂直方向上相邻的陆地单元格组成的区域，且完全被水域单元格包围。孤岛是那些位于矩阵内部、所有单元格都不接触边缘的岛屿。

现在你需要计算所有孤岛的总面积，岛屿面积的计算方式为组成岛屿的陆地的总数。

输入描述

第一行包含两个整数 N, M，表示矩阵的行数和列数。之后 N 行，每行包含 M 个数字，数字为 1 或者 0。

输出描述

输出一个整数，表示所有孤岛的总面积，如果不存在孤岛，则输出 0。
 */
public class gp101 {
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
                bfs(visited, i, 0, graph);
            }
            if (graph[i][m - 1] == 1) {
                bfs(visited, i, m - 1, graph);
            }
        }

        for (int i = 0; i < m; i++) {
            if (graph[0][i] == 1) {
                bfs(visited, 0, i, graph);
            }
            if (graph[n - 1][i] == 1) {
                bfs(visited, n - 1, i, graph);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(boolean[][] visited, int x, int y, int[][] graph) {
        Queue<pair> que = new LinkedList<>();
        que.offer(new pair(x, y));
        visited[x][y] = true;
        //如果起始点是1的话遍历的过程可能无法做到对起始点的处理
        graph[x][y] = 0; // 将起始点直接变成海洋

        while (!que.isEmpty()) {
            int curX = que.peek().x;
            int curY = que.poll().y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];

                if (nextX < 0 || nextY < 0 || nextX > graph.length - 1 || nextY > graph[0].length - 1) {
                    continue;
                }

                if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    //将岛屿变成大海
                    graph[nextX][nextY] = 0;
                    que.offer(new pair(nextX, nextY));
                }
            }
        }
    }

    static class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
