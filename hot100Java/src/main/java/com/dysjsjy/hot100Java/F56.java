package com.dysjsjy.hot100Java;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class F56 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new ArrayList<>();

            // Arrays.sort(intervals, (p, q) -> p[0] - q[0]);

            //1.先排序
            Collections.sort(Arrays.asList(intervals), new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int preStart = intervals[0][0], preEnd = intervals[0][1];

            for (int i = 1; i < intervals.length; i++) {
                int[] cur = intervals[i];
                int curStart = cur[0];
                int curEnd = cur[1];

                if (preEnd > curStart) {
                    preEnd = Math.max(preEnd, curEnd);
                } else {
                    res.add(new int[]{preStart, preEnd});
                    preStart = curStart;
                    preEnd = curEnd;
                }
            }

            res.add(new int[]{preStart, preEnd});

            int[][] ans = new int[res.size()][2];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }

            //res.toArray(new int[res.size()][]);

            return ans;
        }

        //时间复杂度（nlogn），空间复杂度（1）。nlogn是排序的消耗。
    }
}
