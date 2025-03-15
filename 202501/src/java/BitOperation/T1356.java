package java.BitOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T1356 {
    public int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list  = new ArrayList<>();
        for (int x : arr) {
            bit[x] = get(x);
            list.add(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bit[o1] != bit[o2]) {
                    return bit[o1] - bit[o2];
                } else {
                    return o1 - o2;
                }
            }
        });
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    int get(int x) {
        int res = 0;
        while (x != 0) {
            x %= 2;
            x /= 2;
            res += x;
        }
        return res;
    }
}
