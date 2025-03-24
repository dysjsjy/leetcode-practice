package com.dysjsjy.hot100Java;

import java.util.Arrays;

public class F518 {

    class Solution {
        public int change(int amount, int[] coins) {
            int[] f = new int[amount + 1];
            f[0] = 0;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    f[i] += f[i - coin];
                }
            }
            return f[amount];
        }
    }
}
