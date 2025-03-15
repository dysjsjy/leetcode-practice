package java.SlidingWindow;

public class O3258 {
    public static void main(String[] args) {
        
    }

    public int countKConstraintSubstrings(String s, int k) {
        int left = 0, ans = 0;
        int[] cnt = new int[2];
        for (int right = 0; right < s.length(); right++) {
            int x = s.charAt(right) == '1' ? 1 : 0;
            cnt[x]++;

            while (cnt[0] > k || cnt[1] > k) {
                x = s.charAt(right) == '1' ? 1 : 0;
                cnt[x]--;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}