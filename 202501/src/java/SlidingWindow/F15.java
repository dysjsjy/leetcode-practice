package java.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue;
            if (x + nums[n - 1] + nums[n - 2] < 0) continue;
            if (x + nums[i + 1] + nums[i + 2] > 0) break;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = x + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                }
                if (sum > 0) {
                    right--;
                }
                if (sum == 0) {
                    ans.add(List.of(x, nums[left], nums[right]));
                    for (left++; left < right && nums[left] == nums[left - 1]; left++);
                    for (right--; right > left && nums[right] == nums[right + 1]; right--);
                }
            }
        }
        return ans;
    }
}
