package com.jn.graph.acm;

import java.util.*;

/*
拓扑排序精讲
卡码网：117. 软件构建

题目描述：

某个大型软件项目的构建系统拥有 N 个文件，文件编号从 0 到 N - 1，在这些文件中，某些文件依赖于其他文件的内容，这意味着如果文件 A 依赖于文件 B，则必须在处理文件 A 之前处理文件 B （0 <= A, B <= N - 1）。请编写一个算法，用于确定文件处理的顺序。

输入描述：

第一行输入两个正整数 N, M。表示 N 个文件之间拥有 M 条依赖关系。

后续 M 行，每行两个正整数 S 和 T，表示 T 文件依赖于 S 文件。

输出描述：

输出共一行，如果能处理成功，则输出文件顺序，用空格隔开。

如果不能成功处理（相互依赖），则输出 -1。
 */
public class gp117 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> umap = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            umap.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            umap.get(s).add(t);//记录s指向了哪些文件
            inDegree[t]++;//t的入度加1
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        //拓补排序
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            for (int file : umap.get(cur)) {
                inDegree[file]--;
                if (inDegree[file] == 0) {
                    queue.add(file);
                }
            }
        }

        if (result.size() == n) {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) {
                    System.out.print(" ");
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}
