package com.dysjsjy.hot100Java;

import java.util.ArrayList;
import java.util.List;

public class F39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            backtrack(candidates, 0, target, path, res);
            return res;
        }

        void backtrack(int[] candidates, int index, int target, List<Integer> path , List<List<Integer>> res){
            if (target == 0){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i < candidates.length; i++){
                if (target - candidates[i] < 0){
                    continue;
                }

                path.add(candidates[i]);
                backtrack(candidates, i, target - candidates[i], path, res);
                path.remove(path.size() - 1);
            }
        }

        // 时间复杂度（k^T），空间复杂度（k^T * T)，k为候选组的平均分支数，T为目标值
    }

    // 错误解法，这里尝试了在一次递归中，传递多个相同的数。
    class Solution2 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            bfs(candidates, 0, target, path, res);
            return res;
        }

        void bfs(int[] candidates, int index, int target, List<Integer> path , List<List<Integer>> res){
            if (target == 0){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i < candidates.length; i++){
                if (target - candidates[i] < 0){
                    continue;
                }

                // 这里也有问题，target = target % candidates[i] 会一直除到余数才进入下一层递归，
                // 但是也有没除到最后的情况
                int cnt = target / candidates[i];
                target = target % candidates[i];
                for (int j = 0; j < cnt; j++){
                    path.add(candidates[i]);
                }
                // 由于题目说数字可以重复所以你这里应该是i
                bfs(candidates, i + 1, target, path, res);
                for (int j = 0; j < cnt; j++){
                    path.remove(path.size() - 1);
                }
                target = target + candidates[i] * cnt;
            }
        }
    }

    // 一次添加和移除多个元素正确写法
    class Solution3 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(candidates, 0, target, path, res);
            return res;
        }
    
        void dfs(int[] candidates, int index, int target, List<Integer> path, List<List<Integer>> res) {
            // 如果目标值为 0，说明找到了一组解
            if (target == 0) {
                res.add(new ArrayList<>(path)); // 添加当前路径到结果中
                return;
            }
    
            // 遍历候选数组
            for (int i = index; i < candidates.length; i++) {
                // 如果当前元素大于目标值，跳过
                if (candidates[i] > target) {
                    continue;
                }
    
                // 计算当前元素可以使用的最大次数
                int cnt = target / candidates[i];
                // 尝试使用 1 到 cnt 次当前元素
                for (int j = 1; j <= cnt; j++) {
                    // 添加 j 个当前元素到路径中
                    for (int k = 0; k < j; k++) {
                        path.add(candidates[i]);
                    }
                    // 递归调用，目标值减去 j 个当前元素的值
                    dfs(candidates, i + 1, target - j * candidates[i], path, res);
                    // 回溯，移除 j 个当前元素
                    for (int k = 0; k < j; k++) {
                        path.remove(path.size() - 1);
                    }
                }
            }
        }
    }
}
