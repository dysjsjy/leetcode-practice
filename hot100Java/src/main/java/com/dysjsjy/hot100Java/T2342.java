package com.dysjsjy.hot100Java;

import java.util.HashMap;
import java.util.Map;

public class T2342 {
    // 动态规划，记忆化搜索，哈希表优化
    class Solution {
        public int maximumSum(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int n : nums) {
                int digital = cntNum(n);
                if (map.containsKey(digital)) {
                    int v = map.get(digital);
                    ans = Math.max(ans, v + n);
                    map.put(digital, Math.max(v, n));
                } else {
                    map.put(digital, map.getOrDefault(digital, n));
                }
            }

            return ans;
        }

        int cntNum(int a) {
            int cnt = 0;
            while (a != 0) {
                int w = a % 10; // 获取最后一位数字
                a = a / 10;     // 去掉最后一位数字
                cnt += w;       // 累加最后一位数字
            }
            return cnt;
        }
    }

//    性能优化
//    class Solution {
//        public int maximumSum(int[] nums) {
//            int n = nums.length;
//            int[] n1 = new int[n];
//            for (int i = 0; i < n; i++) {
//                int x = nums[i];
//                n1[i] = cntNum(x);
//            }
//
//            int ans = 0;
//
//            for (int i = 0; i < n; i++) {
//                for (int j = i + 1; j < n; j++) {
//                    if (n1[i] == n1[j]) {
//                        ans = Math.max(ans, nums[i] + nums[j]);
//                    }
//                }
//            }
//
//            return ans;
//        }
//
//        int cntNum(int a) {
//            int cnt = 0;
//            while (a != 0) {
//                int w = a % 10;
//                a /= 10;
//                cnt += w;
//            }
//            return cnt;
//        }
//    }
}
