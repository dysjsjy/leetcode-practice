package com.dysjsjy.ox3f.MonotoneStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class S1504 {


    class Solution {
        public int numSubmat(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
            int[][] row = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j == 0) {
                        row[i][j] = 0;
                    } else if (mat[i][j] != 0) {
                        row[i][j] = row[i][j - 1] + 1;
                    } else {
                        row[i][j] = 0;
                    }
                }
            }

            int ans = 0;
            for (int j = 0; j < m; j++) {
                int i = 0;
                int sum = 0;
                Deque<int[]> Q = new ArrayDeque<>();
                while (i <= n - 1) {
                    int height = 1;
                    while (!Q.isEmpty() && Q.peekFirst()[0] > row[i][j]) {
                        sum -= Q.peekFirst()[1] * (Q.peekFirst()[0] - row[i][j]);
                        height += Q.peekFirst()[1];
                        Q.pollFirst();
                    }
                    sum += row[i][j];
                    ans += sum;
                    Q.offerFirst(new int[] {row[i][j], height});
                    i++;
                }
            }

            return ans;
        }
    }
}
