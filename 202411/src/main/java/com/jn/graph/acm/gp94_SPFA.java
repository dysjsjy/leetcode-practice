package com.jn.graph.acm;

import java.util.*;

public class gp94_SPFA {
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

    public static void spfa(int n, int start) {
        //初始化距离数组和队列状态
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        inQueue = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        inQueue[start] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            inQueue[u] = false;

            for (Edge edge : graph[u]) {
                int v = edge.to;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;

                    //如果v还没有入队或者它不在队列中，则将它加入队列
                    if (!inQueue[v]) {
                        queue.offer(v);
                        inQueue[v] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n= scanner.nextInt();
        int m = scanner.nextInt();

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            graph[u].add(new Edge(v, weight));
        }

        int start = scanner.nextInt();
        spfa(n, start);

        //输出从起点到各个点的最短路径
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

        scanner.close();
    }
}
