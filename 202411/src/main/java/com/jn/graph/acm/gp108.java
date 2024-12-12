package com.jn.graph.acm;

import java.util.Scanner;

public class gp108 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        DisJoin disJoin = new DisJoin(n + 1);

        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();

            if (disJoin.isSame(s, t)) {
                System.out.println(s + " " + t);
            } else {
                disJoin.join(s, t);
            }
        }
    }

    static class DisJoin {
        private int[] father;

        public DisJoin(int n) {
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
}