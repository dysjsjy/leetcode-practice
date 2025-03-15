package com.dysjsjy.hot100Java;

public class F48 {

    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int m = n;
            for (int i = 0; i < (n + 1) / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[m - 1][j];
                    matrix[m - 1][j] = matrix[m - 1 - i][n - 1 - j];
                    matrix[m - 1 - i][n - 1 - j] = matrix[j][m - 1 - i];
                    matrix[j][m - 1 - i] = temp;
                }
            }
        }
    }
}
