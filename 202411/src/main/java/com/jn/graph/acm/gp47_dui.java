package com.jn.graph.acm;


import java.util.*;

/*
dijkstra（堆优化版）精讲
卡码网：47. 参加科学大会

【题目描述】

小明是一位科学家，他需要参加一场重要的国际科学大会，以展示自己的最新研究成果。

小明的起点是第一个车站，终点是最后一个车站。然而，途中的各个车站之间的道路状况、交通拥堵程度以及可能的自然因素（如天气变化）等不同，这些因素都会影响每条路径的通行时间。

小明希望能选择一条花费时间最少的路线，以确保他能够尽快到达目的地。

【输入描述】

第一行包含两个正整数，第一个正整数 N 表示一共有 N 个公共汽车站，第二个正整数 M 表示有 M 条公路。

接下来为 M 行，每行包括三个整数，S、E 和 V，代表了从 S 车站可以单向直达 E 车站，并且需要花费 V 单位的时间。

【输出描述】

输出一个整数，代表小明从起点到终点所花费的最小时间。
 */
public class gp47_dui {

    static class Edge {
        int to;
        int val;

        Edge(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }

    static class MyComparison implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> lhs, Pair<Integer, Integer> rhs) {
            return Integer.compare(lhs.second, rhs.second);
        }
    }

    static class Pair<U, V> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Edge>> grid = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            grid.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            int val = scanner.nextInt();
            grid.get(p1).add(new Edge(p2, val));
        }

        int start = 1;
        int end = n;

        //存储从源点到每个节点的距离
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        //记录顶点是否被访问过
        boolean[] visited = new boolean[n + 1];

        //优先队列中存放Pair<节点，源点到该系节点的权值>
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new MyComparison());

        pq.add(new Pair<>(start, 0));

        minDist[start] = 0;

        while (!pq.isEmpty()) {
            //1,选源节点到哪个节点近，且未被访问过
            Pair<Integer, Integer> cur = pq.poll();

            if (visited[cur.first]) continue;

            //2.该节点的最近节点被标记访问过
            visited[cur.first] = true;

            //3.更新非访问节点到源节点的距离
            for (Edge edge : grid.get(cur.first)) {
                if (!visited[edge.to] && minDist[cur.first] + edge.val < minDist[edge.to]) {
                    minDist[edge.to] = minDist[cur.first] + edge.val;
                    pq.add(new Pair<>(edge.to, minDist[edge.to]));
                }
            }
        }

        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDist[end]);
        }
    }
}
