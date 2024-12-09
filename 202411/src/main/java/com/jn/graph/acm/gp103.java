package com.jn.graph.acm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
103. 水流问题
题目描述
现有一个 N × M 的矩阵，每个单元格包含一个数值，这个数值代表该位置的相对高度。矩阵的左边界和上边界被认为是第一组边界，而矩阵的右边界和下边界被视为第二组边界。



矩阵模拟了一个地形，当雨水落在上面时，水会根据地形的倾斜向低处流动，但只能从较高或等高的地点流向较低或等高并且相邻（上下左右方向）的地点。我们的目标是确定那些单元格，从这些单元格出发的水可以达到第一组边界和第二组边界。

输入描述
第一行包含两个整数 N 和 M，分别表示矩阵的行数和列数。

后续 N 行，每行包含 M 个整数，表示矩阵中的每个单元格的高度。

输出描述
输出共有多行，每行输出两个整数，用一个空格隔开，表示可达第一组边界和第二组边界的单元格的坐标，输出顺序任意。
 */
public class gp103 {
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

        //上边界和下边界
        boolean[][] paciifc = new boolean[n][m];
        boolean[][] antlantic = new boolean[n][m];

        //左右边界
        for (int i = 0; i < n; i++) {
            dfs(paciifc, i, 0, graph, Integer.MIN_VALUE);
            dfs(antlantic, i, m - 1, graph, Integer.MIN_VALUE);
        }

        //上下边界
        for (int i = 0; i < m; i++) {
            dfs(paciifc, 0, i, graph, Integer.MIN_VALUE);
            dfs(antlantic, n - 1, i, graph, Integer.MIN_VALUE);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paciifc[i][j] && antlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        for (List<Integer> list : result) {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    System.out.print(list.get(i) + "");
                } else {
                    System.out.print(list.get(i));
                }
            }
            System.out.println();
        }
    }

    static void dfs(boolean[][] visited, int x, int y, int[][] graph, int preHeight) {
        if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length || visited[x][y]) {
            return;
        }

        if (graph[x][y] < preHeight) {
            return;
        }

        visited[x][y] = true;

        dfs(visited, x + 1, y, graph, graph[x][y]);
        dfs(visited, x - 1, y, graph, graph[x][y]);
        dfs(visited, x, y - 1, graph, graph[x][y]);
        dfs(visited, x, y + 1, graph, graph[x][y]);
    }
}
