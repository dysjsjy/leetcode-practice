package com.dysjsjy.ox3f.MonotoneStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T1475 {


    class Solution {
        public int[] finalPrices(int[] prices) {
            int n = prices.length;
            for (int i = 0; i < n - 1; i++) {
                int k = 0;
                for (int j = i + 1; j < n && k == 0; j++) {
                    if (prices[j] <= prices[i]) {
                        k = prices[j];
                    }
                }
                prices[i] -= k;
            }
            return prices;
        }

        public int[] finalPrices2(int[] prices) {
            int n = prices.length;
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                while (!deque.isEmpty() && prices[i] <= prices[deque.peekLast()]) {
                    int idx = deque.pollLast();
                    prices[idx] = prices[idx] - prices[i];
                }
                deque.offerLast(i);
            }

            return prices;
        }
    }
}
