package com.jn.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
797. 所有可能的路径
中等
相关标签
相关企业
给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）

 graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 */
//ACM模式
//邻接矩阵法
public class gp797 {
    static List<List<Integer>> result = new ArrayList<>(); // 收集符合条件的路径
    static List<Integer> path = new ArrayList<>(); // 1节点到终点的路径

    public static void dfs(List<LinkedList<Integer>> graph, int x, int n) {
        //结束条件
        if (x == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i : graph.get(x)) {
            path.add(i);
            dfs(graph, i, n);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<LinkedList<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        while (m-- > 0) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();

            graph.get(s).add(t);
        }

        path.add(1);

        dfs(graph, 1, n);

        if (result.isEmpty()) {
            System.out.println(-1);
        }

        for (List<Integer> pa : result) {
            for (int i = 0; i < pa.size() - 1; i++) {
                System.out.print(pa.get(i) + " ");
            }
            System.out.println(pa.get(pa.size() - 1));
        }
    }
}
