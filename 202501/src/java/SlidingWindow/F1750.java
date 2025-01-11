package java.SlidingWindow;

public class F1750 {
    public int minimumLength(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                char c = s.charAt(l);
                while (l <= r && s.charAt(l) == c) {
                    l++;
                }
                while (l <= r && s.charAt(r) == c) {
                    r--;
                }
            } else {
                break;
            }
        }

        return r - l + 1;
    }
}
