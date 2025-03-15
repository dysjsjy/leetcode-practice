package java.SlidingWindow;

import java.util.Collections;
import java.util.List;

public class T524 {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            } else {
                return a.compareTo(b);
            }
        });
        for (String ss : dictionary) {
            int n = ss.length();
            int m = s.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (ss.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }
            if (i == n) {
                return ss;
            }
        }
        return "";
    }
}
