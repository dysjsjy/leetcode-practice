package com.jn.graph.acm;


import java.util.*;

/*
105.有向图的完全可达性
卡码网题目链接（ACM模式）

【题目描述】

给定一个有向图，包含 N 个节点，节点编号分别为 1，2，...，N。现从 1 号节点开始，如果可以从 1 号节点的边可以到达任何节点，则输出 1，否则输出 -1。

【输入描述】

第一行包含两个正整数，表示节点数量 N 和边的数量 K。 后续 K 行，每行两个正整数 s 和 t，表示从 s 节点有一条边单向连接到 t 节点。

【输出描述】

如果可以从 1 号节点的边可以到达任何节点，则输出 1，否则输出 -1。
 */
public class gp105 {
    public static List<List<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices_num = scanner.nextInt();
        int lines_num = scanner.nextInt();

        for (int i = 0; i < vertices_num; i++) {
            adjList.add(new LinkedList<>());
        }

        for (int i = 0; i < lines_num; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            adjList.get(s - 1).add(t - 1);
        }

        boolean[] visited = new boolean[vertices_num];

        dfs(visited, 0);

        for (int i = 0; i < vertices_num; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(1);
    }

    static void dfs(boolean[] visited, int key) {
        //一般程序开头都是做校验
        if (visited[key]) {
            return;
        }

        visited[key] = true;
        List<Integer> nextKeys = adjList.get(key);
        for (int nextKey : nextKeys) {
            dfs(visited, nextKey);
        }
    }

    static void bfs(boolean[] visited, int key) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(key);
        visited[key] = true;

        while (!queue.isEmpty()) {
            int cueKey = queue.poll();
            List<Integer> nextKeys = adjList.get(cueKey);
            for (int nextKey : nextKeys) {
                if (!visited[nextKey]) {
                    visited[nextKey] = true;
                    queue.add(nextKey);
                }
            }
        }
    }

    //错误解法
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//
//        int[][] graph = new int[n + 1][m + 1];
//
//        for (int i = 0; i < m; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            graph[x][y] = 1;
//        }
//
//        for (int i = 1; i < n; i++) {
//            graph[i][i] = 1;
//        }
//
//        boolean[][] visited = new boolean[n][m];
//
//        dfs(visited, 1, 1, graph);
//
//        int result = -1;
//
//        for (int i = 1; i <= n; i++) {
//            boolean nowLine = false;
//            for (int j = 1; j <= m; j++) {
//                if (visited[i][j]) {
//                    nowLine = true;
//                    break;
//                }
//            }
//            if (!nowLine) {
//                result = 1;
//                System.out.println(result);
//                return;
//            }
//        }
//
//        System.out.println(result);
//    }
//
//    static void dfs(boolean[][] visited, int x, int y, int[][] graph) {
//        visited[x][y] = true;
//
//        for (int i = 1; i <= graph[0].length; i++) {
//            if (!visited[x][i] && graph[x][i] == 1) {
//                dfs(visited, i, i, graph);
//            }
//        }
//    }
}
