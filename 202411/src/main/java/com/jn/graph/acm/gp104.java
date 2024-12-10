package com.jn.graph.acm;


import java.util.*;

/*
104.建造最大岛屿
卡码网题目链接（ACM模式）

题目描述：

给定一个由 1（陆地）和 0（水）组成的矩阵，你最多可以将矩阵中的一格水变为一块陆地，在执行了此操作之后，矩阵中最大的岛屿面积是多少。

岛屿面积的计算方式为组成岛屿的陆地的总数。岛屿是被水包围，并且通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设矩阵外均被水包围。

输入描述：

第一行包含两个整数 N, M，表示矩阵的行数和列数。之后 N 行，每行包含 M 个数字，数字为 1 或者 0，表示岛屿的单元格。

输出描述：

输出一个整数，表示最大的岛屿面积。
 */
public class gp104 {
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int count;
    static int mark;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        if (n <= 0 || m <= 0) {
            System.out.println(0);
            return;
        }

        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        boolean[][] visited = new boolean[n][m];
        mark = 2;
        //判断是否全是岛屿
        boolean isAllLand = true;
        //记录某片岛屿的标记号和面积
        Map<Integer, Integer> getSize = new HashMap<>();
        //判断某一位置四周是否存在不同标记的岛屿
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    isAllLand = false;
                }
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    bfs(visited, i, j, graph);
                    getSize.put(mark, count);
                    mark++;
                }
            }
        }

        int result = 0;
        if (isAllLand) {
            System.out.println(n * m);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    set.clear();

                    int curSize = 1;

                    for (int[] dir : dirs) {
                        int nextX = i + dir[0];
                        int nextY = j + dir[1];

                        if (nextX < 0 || nextY < 0 || nextX > graph.length - 1 || nextY > graph[0].length - 1) {
                            continue;
                        }

                        int curMark = graph[nextX][nextY];

                        if (set.contains(curMark) || !getSize.containsKey(curMark)) {
                            continue;
                        }

                        set.add(curMark);
                        curSize += getSize.get(curMark);
                    }

                    result = Math.max(result, curSize);
                }
            }
        }
        System.out.println(result);
    }

    static void bfs(boolean[][] visited, int x, int y, int[][]graph) {
        //*在bfs中经常容易忘记既需要在一开始就对进入bfs中的格子处理，也需要对while中的格子进行同样的处理*
        count++;
        visited[x][y] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        graph[x][y] = mark; // 标记当前岛屿

        while (!queue.isEmpty()) {
            int curX = queue.peek().x;
            int curY = queue.poll().y;
            graph[curX][curY] = mark;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dirs[i][0];
                int nextY = curY + dirs[i][1];

                if (nextX < 0 || nextY < 0 || nextX > graph.length - 1 || nextY > graph[0].length - 1 || visited[nextX][nextY]) {
                    continue;
                }

                if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                    queue.offer(new Pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                    //注意这里同样需要进行标记和count++
                    graph[nextX][nextY] = mark; // 标记岛屿
                    count++; // 增加岛屿面积
                }
            }
        }
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
