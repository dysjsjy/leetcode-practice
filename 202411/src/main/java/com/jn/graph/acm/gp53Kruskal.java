package com.jn.graph.acm;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
kruskal算法精讲
卡码网：53. 寻宝

题目描述：

在世界的某个区域，有一些分散的神秘岛屿，每个岛屿上都有一种珍稀的资源或者宝藏。国王打算在这些岛屿上建公路，方便运输。

不同岛屿之间，路途距离不同，国王希望你可以规划建公路的方案，如何可以以最短的总公路距离将 所有岛屿联通起来。

给定一张地图，其中包括了所有的岛屿，以及它们之间的距离。以最小化公路建设长度，确保可以链接到所有岛屿。

输入描述：

第一行包含两个整数V 和 E，V代表顶点数，E代表边数 。顶点编号是从1到V。例如：V=2，一个有两个顶点，分别是1和2。

接下来共有 E 行，每行三个整数 v1，v2 和 val，v1 和 v2 为边的起点和终点，val代表边的权值。

输出描述：

输出联通所有岛屿的最小路径总距离
 */
//kruskal算法，对边进行升序排序，验证开始和结尾的节点在集合中不属于同一根节点则加入集合（即未成环），直到遍历完所有的边。
public class gp53Kruskal {
    private static int n = 10001;
    private static int[] father = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public static int find(int u) {
        if (u == father[u]) return u;
        return father[u] = find(father[u]);
    }

    public static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        List<Edge> edges = new ArrayList<Edge>();
        int result_val = 0;

        for (int i = 0; i < e; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int val = scanner.nextInt();

            edges.add(new Edge(v1, v2, val));
        }

        edges.sort(Comparator.comparingInt(edge -> edge.val));

        init();

        for (Edge edge : edges) {
            int x = find(edge.l);
            int y = find(edge.r);

            if (x != y) {
                result_val += edge.val;
                join(x, y);
            }
        }

        System.out.println(result_val);
        scanner.close();
    }

    static class Edge {
        int l, r, val;

        public Edge(int l, int r, int val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }
}
