package com.dysjsjy.hot100Java;

import java.util.ArrayList;
import java.util.List;

public class F78 {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(nums, 0, path, ans);
            return ans;
        }
        
        void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> ans){
            if (index == nums.length){
                // 注意这里要新建一个list，不能直接add(path)，因为path是不断变化的
                ans.add(new ArrayList<>(path));
                return;
            }

            // 选择当前元素
            path.add(nums[index]);

            dfs(nums, index + 1, path, ans);

            path.remove(path.size() - 1);

            // 不选择当前元素
            dfs(nums, index + 1, path, ans);
        }

        // 时间复杂度（2^n * n），空间复杂度（2^n * n）。
    }
}
