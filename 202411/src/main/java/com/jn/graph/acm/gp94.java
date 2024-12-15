package com.jn.graph.acm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
94. 城市间货物运输 I
题目描述
某国为促进城市间经济交流，决定对货物运输提供补贴。共有 n 个编号为 1 到 n 的城市，通过道路网络连接，网络中的道路仅允许从某个城市单向通行到另一个城市，不能反向通行。



网络中的道路都有各自的运输成本和政府补贴，道路的权值计算方式为：运输成本 - 政府补贴。权值为正表示扣除了政府补贴后运输货物仍需支付的费用；权值为负则表示政府的补贴超过了支出的运输成本，实际表现为运输过程中还能赚取一定的收益。



请找出从城市 1 到城市 n 的所有可能路径中，综合政府补贴后的最低运输成本。如果最低运输成本是一个负数，它表示在遵循最优路径的情况下，运输过程中反而能够实现盈利。



城市 1 到城市 n 之间可能会出现没有路径的情况，同时保证道路网络中不存在任何负权回路。

输入描述
第一行包含两个正整数，第一个正整数 n 表示该国一共有 n 个城市，第二个整数 m 表示这些城市中共有 m 条道路。

接下来为 m 行，每行包括三个整数，s、t 和 v，表示 s 号城市运输货物到达 t 号城市，道路权值为 v （单向图）。

输出描述
如果能够从城市 1 到连通到城市 n， 请输出一个整数，表示运输成本。如果该整数是负数，则表示实现了盈利。如果从城市 1 没有路径可达城市 n，请输出 "unconnected"。
 */
public class gp94 {

    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static String findMinCost(int n, int m, List<Edge> edges) {
        //初始化距离数组，所有城市的初始化距离为正无穷
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        //Bellman-Found 算法主循环
        for (int i = 0; i < n; i++) {
            boolean update = false;
            for( Edge edge : edges) {
                if (dist[edge.from] != Long.MAX_VALUE && dist[edge.from] + edge.cost < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    update = true;
                }
            }

            //如果没有更新提早推出
            if (!update) {
                break;
            }
        }

        //判断是否能到达城市n
        if (dist[n] == Long.MAX_VALUE) {
            return "unconnected";
        }

        //返回最短路径值
        return String.valueOf(dist[n]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //城市数量n和道路数量m
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //输入边信息
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new Edge(s, t, v));
        }

        System.out.println(findMinCost(n, m, edges));
    }
}
