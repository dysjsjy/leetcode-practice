package com.dysjsjy.ox3f.N14_16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class T3111 {

    class Solution {

        public int minRectanglesToCoverPoints(int[][] points, int w) {
            int ans = 0;
            int idx = -1;
            Arrays.sort(points, (p0, p1) -> {
                return p0[0] - p1[0];
            });

            for (int[] p : points) {
                if (p[0] > idx) {
                    idx = p[0] + w;
                    ans++;
                }
            }

            return ans;
        }

//        public int minRectanglesToCoverPoints2(int[][] points, int w) {
//            int ans = 0;
//            Arrays.sort(points, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return o1[0] - o2[0];
//                }
//            });
//            Set<Integer> pSet = new HashSet<>();
//            for (int[] p : points) {
//                pSet.add(p[0]);
//            }
//
//            int start = points[0][0];
//            int end = points[points.length - 1][0];
//
//            for (int i = start; i < end; i++) {
//                int r = i + w;
//                while (r > end || (!pSet.contains(r))) {
//                    r--;
//                }
//                i = r + 1;
//                ans++;
//            }
//
//            return ans;
//        }
    }
}
