package java.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class lcp68 {

    public int beautifulBouquet(int[] flowers, int cnt) {
        int ans = 0;
        int[] count = new int[1000001];
        for (int l = 0, r = 0; r < flowers.length; r++) {
            count[flowers[r]]++;
            while (count[flowers[r]] > cnt) {
                count[flowers[l]]--;
                l++;
            }
            ans += r - l + 1;
        }
        return ans % 1000000007;
    }

    // public int beautifulBouquet(int[] flowers, int cnt) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int left = 0;
    //     long ans = 0;
    //     for (int right = 0; right < flowers.length; right++) {
    //         map.put(flowers[right], map.getOrDefault(flowers[right], 0) + 1);
    //         while (isVaild(map, cnt)) {
    //             map.put(flowers[left], map.getOrDefault(flowers[left], 0) - 1);
    //             if (map.get(flowers[left]) == 0) {
    //                 map.remove(flowers[left]);
    //             }
    //         }
    //         ans += right - left + 1;
    //     }
    //     return ans;
    // }
    // boolean isVaild(Map map, Integer cnt) {
    //     for (Integer i : map.values()) {
    //         if (i > cnt) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
