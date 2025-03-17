package com.dysjsjy.hot100Java;

public class F200 {


    class Solution {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int numIslands(char[][] grid) {
            int count = 0;
            int n = grid.length;
            int m = grid[0].length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    bfs(grid, i, j, n, m);
                    if (grid[i][j] == '1') {
                        count++;
                    }
                }
            }
            return count;
        }

        void bfs(char[][] grid, int x, int y, int n, int m) {
            if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '0') {
                return;
            }

            grid[x][y] = '0';

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                bfs(grid, nextX, nextY, n, m);
            }
        }

        // 时间复杂度（n*m），空间复杂度（n*m）。

        // 错误解法，只考虑了上下左右都是海水的岛屿
//        public int numIslands(char[][] grid) {
//            int count = 0;
//
//            int n = grid.length;
//            int m = grid[0].length;
//
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (grid[i][j] != 1) {
//                        continue;
//                    }
//
//                    boolean isLand = true;
//
//                    for (int[] dir : dirs) {
//                        int nextX = i + dir[0];
//                        int nextY = j + dir[1];
//                        if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m) {
//                            if (grid[nextX][nextY] == 1) {
//                                isLand = false;
//                            }
//                        }
//                    }
//
//                    if (isLand) {
//                        count++;
//                    }
//                }
//            }
//
//            return count;
//        }
    }
}
