package com.jn.graph;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
200. 岛屿数量
中等
相关标签
相关企业
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。
 */
public class gp200 {
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    result++;
                    bfs(visited, i, j, grid);
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(boolean[][] visited, int x, int y, int[][] grid) {
        Queue<pair> que = new LinkedList<>();
        que.offer(new pair(x, y));
        //这里有没有都对，在这里标记表示放入队列即访问过了
        visited[x][y] = true;
        while (!que.isEmpty()) {
            int curX = que.peek().first;
            int curY = que.poll().second;
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }
                if (grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    //在这里标记表示没有被访问过以及是陆地即标记
                    //其实这个函数中这两种标记都对，只是标记的时期不同而已保留一个就行
                    visited[nextX][nextY] = true;
                    que.offer(new pair(nextX, nextY));
                }
            }
        }
    }

    static class pair {
        int first;
        int second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void dfs(boolean[][] visited, int x, int y, char[][] grid) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextY < 0 || nextX < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                continue;
            }
            if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                dfs(visited, nextX, nextY, grid);
            }
        }
    }
}
