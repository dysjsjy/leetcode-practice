package com.dysjsjy.hot100Java;

import java.util.ArrayList;
import java.util.List;

public class F17 {
    class Solution {
        String[] letters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        public List<String> letterCombinations(String digits) {
            char[] charArray = digits.toCharArray();
            List<char[]> res = new ArrayList<>();

            // 获得每个数字对应的字母数组，并将字母数组存到一起，存在res中。
            for (char c : charArray){
                int index = c - '2';
                if (index < 0 || index > 9){
                    continue;
                }
                res.add(letters[index].toCharArray());
            }

            List<String> ans = new ArrayList<>();
            if (res.size() == 0){
                return ans;
            }

            dfs(res, 0, new StringBuilder(), ans);

            return ans;    
        }

        void dfs(List<char[]> res, int index, StringBuilder path, List<String> ans) {
            // 如果index等于res的长度，说明已经遍历完了，将path加入ans中。
            if (index == res.size()) {
                // 注意这里要new一个String，path是一个StringBuilder，而StringBuilder是一直被引用的。
                ans.add(new String(path));
                return;
            }

            for (char c : res.get(index)) {
                path.append(c);
                dfs(res, index + 1, path, ans);
                path.deleteCharAt(path.length() - 1);
                // 这里的每个数字组都要选择一个使用，所以没有不选择的情况。
            }
        }

        // 时间复杂度（k^n * n），空间复杂度（k^n * n）。
        // k为每个数字对应的字母数量，n为数字数量。
    }
}
