package com.dysjsjy.ox3f.N14_16;

public class F2825 {

    class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            if (chars2.length > chars1.length) {
                return false;
            }
            int j = 0;
            for (char c : chars1) {
                char b = c == 'z' ? 'a' : (char) (c + 1);
                if (b == chars2[j] || c == chars2[j]) {
                    j++;
                }
                if (j == chars2.length) {
                    return true;
                }
            }
            return false;
        }
    }
}
