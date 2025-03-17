package com.jn.graph.acm;

import java.util.*;

//错误示范
public class gp96 {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Edge>[] graph;
    static int[] dist;
    static boolean[] inQueue;

    //其实spfa不需要graph，直接管理边就行
    public static String spfa(int start, int end, int n) {
        dist[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        inQueue[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            inQueue[cur] = false;

            for (Edge edge : graph[cur]) {
                int v = edge.to;
                int weight = edge.weight;

                if (dist[cur] + weight < dist[v]) {
                    dist[v] = dist[cur] + weight;

                    if (!inQueue[v]) {
                        queue.add(v);
                        inQueue[v] = true;
                    }
                }
            }
        }

        if (dist[end] == INF) {
            return "unreachable";
        } else {
            return String.valueOf(dist[end]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        inQueue = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            graph[from].add(new Edge(to, weight));
        }

        int start = scanner.nextInt();
        int end = scanner.nextInt();

        if (start <= 0 || start > n || end <= 0 || end > n) {
            System.out.println("Invalid start or end node");
            scanner.close();
            return;
        }

        String result = spfa(start, end, n);

        System.out.println(result);

        scanner.close();
    }
}
