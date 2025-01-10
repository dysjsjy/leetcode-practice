package java.SlidingWindow;

public class F248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int left1 = 0, left2 = 0, cnt1 = 0, cnt2 = 0, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                cnt1++;
                cnt2++;
            }
            while (cnt1 >=k) {
                if (nums[left1++] % 2 != 0) {
                    cnt1--;
                }
            }
            while (cnt2 > k) {
                if (nums[left2++] % 2 != 0) {
                    cnt2--;
                }
            }
            ans += left1 - left2;
        }
        return ans;
    }
}
