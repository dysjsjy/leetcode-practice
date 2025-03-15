package java.SlidingWindow;

public class O2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int i = 0, j = 0, ans = 0;
        for (int x : nums) {
            while (nums[i] + diff < x) {
                ++i;
            }
            if (nums[i] + diff > x) {
                continue;
            }
            while (nums[j] + diff * 2 < x) {
                ++j;
            }
            if (nums[j] + diff * 2 == x) {
                ++ans;
            }
        }
        return ans;
    }
}
