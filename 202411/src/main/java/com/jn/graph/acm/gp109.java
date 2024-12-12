package com.jn.graph.acm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//不太看得懂
public class gp109 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Edge> edges = new ArrayList<>();
        Node[] nodeMap = new Node[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodeMap[i] = new Node();
        }
        Integer doubleIn = null;
        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            //记录入度
            nodeMap[t].in++;
            if (!(nodeMap[t].in < 2)) doubleIn = t;
            Edge edge = new Edge(s, t);
            edges.add(edge);
        }

        Edge result = null;

        if (doubleIn != null) {
            List<Edge> doubleInEdges = new ArrayList<>();
            for (Edge edge : edges) {
                if (edge.t == doubleIn) {
                    doubleInEdges.add(edge);
                }
                if (doubleInEdges.size() == 2) {
                    break;
                }
            }
            Edge edge = doubleInEdges.get(1);
            if (isTreeWhthExclude(edges, edge, nodeMap)) {
                result = edge;
            } else {
                result = doubleInEdges.get(0);
            }
        } else {
            result = getRemoveEdge(edges, nodeMap);
        }

        System.out.println(result.s + " " + result.t);
    }

    static class Disjoin {
        private int[] father;

        public Disjoin(int n) {
            this.father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int find(int n) {
            return father[n] == n ? n : (father[n] = find(father[n]));
        }

        public void join(int n, int m) {
            n = find(n);
            m = find(m);

            if (n == m) return;
            father[m] = n;
        }

        public boolean isSame(int n, int m) {
            n = find(n);
            m = find(m);
            return n == m;
        }
    }

    static class Edge {
        int s;
        int t;

        public Edge(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    static class Node {
        int id;
        int in;
        int out;
    }

    public static boolean isTreeWhthExclude(List<Edge> edges, Edge exculdEdge, Node[] nodeMap) {
        Disjoin disjoin = new Disjoin(nodeMap.length + 1);
        for (Edge edge : edges) {
            if (edge == exculdEdge) continue;
            if (disjoin.isSame(edge.s, exculdEdge.t)) {
                return false;
            }
            disjoin.join(edge.s, exculdEdge.t);
        }
        return true;
    }

    public static Edge getRemoveEdge(List<Edge> edges , Node[] nodeMap) {
        int length = nodeMap.length;
        Disjoin disjoin = new Disjoin(length);

        for (Edge edge : edges) {
            if (disjoin.isSame(edge.s, edge.t)) {
                return edge;
            }
            disjoin.join(edge.s, edge.t);
        }
        return null;
    }
}
