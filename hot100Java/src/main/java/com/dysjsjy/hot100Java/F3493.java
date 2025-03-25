package com.dysjsjy.hot100Java;

import java.util.*;

public class F3493 {
    // 查并集模版，数组，find，merge，
    // 用一个数组来记录每个节点的根节点，
    // find通过递归找到修改后数组中的某个节点的真正根节点即未修改过的节点，
    // merge调用find查询rootX和rootY两个节点个最近相等的父节点，并将parent[rootX]节点指向rootY，
//    联想故事：
//    想象一个古代部落社会：
//    开始时（建村），有 n 个小村庄，每人自立门户。
//    要找谁是老大（寻根），从村民问到村长，整理家谱。
//    两个村庄结盟（联姻），村长们谈判，一个认另一个为上级，部落数减少。
    class UnionFind {
        private int[] parent;
        private int cc;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.cc = n;
            // 问题三，查并集要初始化
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            // 问题一，这里应该是将他们两个节点的并集中的节点连接起来，而是是直接连接他们
            parent[rootX] = rootY;
//            parent[x] = y;
            cc--;
        }
    }

    class Solution {
        public int numberOfComponents(int[][] properties, int k) {
            int n = properties.length;
            int m = properties[0].length;
            UnionFind u = new UnionFind(n);
            Set<Integer>[] sets = new HashSet[n];
            for (int i = 0; i < n; i++) {
                for (int x : properties[i]) {
                    sets[i].add(x);
                }
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> s = sets[i];
                for (int j = 0; j < i; j++) {
                    int cnt = 0;
                    // 问题二，这里应该使用sets[j]，因为题目是共有的不同整数的数量，
                    for (int x : properties[j]) {
                        if (s.contains(x)) {
                            cnt++;
                        }
                    }
                    if (cnt >= k) {
                        u.union(i, j);
                    }
                }
            }
            return u.cc;
        }
    }
}
