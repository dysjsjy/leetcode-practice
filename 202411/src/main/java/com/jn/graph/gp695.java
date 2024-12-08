package com.jn.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
695. 岛屿的最大面积
中等
相关标签
相关企业
给你一个大小为 m x n 的二进制矩阵 grid 。

岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

岛屿的面积是岛上值为 1 的单元格的数目。

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class gp695 {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int count = 0;

    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count = 0;
                    dfs(visited, i, j, grid);
                    result = Math.max(result, count);
                }
            }
        }

        return result;
    }

    public void dfs(boolean[][] visited, int x, int y, int[][] grid) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if (    nextX >= 0
                    && nextY >= 0
                    && nextX < grid.length
                    && nextY < grid[0].length
                    && !visited[nextX][nextY]
                    && grid[nextX][nextY] == 1
            ) {
                dfs(visited, nextX, nextY, grid);
            }
        }
    }
}
