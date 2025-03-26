package com.dysjsjy.hot100Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class F2001 {

    public long interchangeableRectangles(int[][] rectangles) {
        Map<String, Long> cnt = new HashMap<>();
        for (int[] p : rectangles) {
            // 计算 w/h 的最简分数，计入哈希表
            int w = p[0];
            int h = p[1];
            int g = gcd(w, h);
            String key = (w / g) + "/" + (h / g);
            cnt.put(key, cnt.getOrDefault(key, 0L) + 1);
        }
        long ans = 0;
        for (long m : cnt.values()) {
            ans += m * (m - 1) / 2;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

}
