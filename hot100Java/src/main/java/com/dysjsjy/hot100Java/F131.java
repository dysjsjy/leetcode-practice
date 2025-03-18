package com.dysjsjy.hot100Java;

import java.util.ArrayList;
import java.util.List;

public class F131 {

    // 回溯的核心是选择、递归、撤销

    class Solution {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        String s;
        public List<List<String>> partition(String s) {
            this.s = s;
            dfs(0);
            return ans;
        }

        void dfs(int i) {
            // 结束条件
            if (i == s.length()) {
                ans.add(new ArrayList<>(path));
                return;
            }

            // 循环
            for (int j = i; j < s.length(); j++) {
                // 剪枝
                if (isPalindrame(i, j)) {
                    // 选择
                    path.add(s.substring(i, j + 1));
                    // 递归
                    dfs(j + 1);
                    // 撤销
                    path.remove(path.size() - 1);
                }
            }
        }

        boolean isPalindrame(int left, int right) {
            while (left < right) {
                if (s.charAt(left++)!= s.charAt(right--)) {
                    return false;
                }
            }
            
            return true;
        }
    }

    // 时间复杂度（2^n * n），空间复杂度（2^n * n）。


    class Solution2 {
        String s;
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        public List<List<String>> partition(String s) {
            this.s = s;
            dfs(0, 0);
            return ans;
        }

        void dfs(int i, int start) {
            if (i == s.length()) {
                ans.add(new ArrayList<>(path));
                return;
            }

            if (i < s.length() - 1) {
                dfs(i + 1, start);
            }

            if (isPalindrame(start, i)) {
                path.add(s.substring(start, i + 1));
                dfs(i + 1, i + 1);
                path.remove(path.size() - 1);
            }
        }

        boolean isPalindrame(int left, int right) {
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
