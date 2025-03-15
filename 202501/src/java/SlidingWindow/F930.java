package java.SlidingWindow;

public class F930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left1 = 0, left2 = 0;
        int sum1 = 0, sum2 = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            sum1 += nums[right];
            sum2 += nums[right];
            while (left1 <= right && sum1 >= goal) {
                sum1 -= nums[left1++];
            }
            while (left2 <= right && sum2 > goal) {
                sum2 -= nums[left2++];
            }
            ans += left1 - left2;
        }
        return ans;
    }
}
