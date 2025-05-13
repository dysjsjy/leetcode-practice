package com.dysjsjy.hot100Java.alwaysImpossibleToAK;

import java.util.HashMap;
import java.util.Map;

import com.dysjsjy.hot100Java.Sample.TreeNode;

public class 路径总和3 {

    // 标准的解法应该是前缀和加哈希表
    // 暴力解法就是dfs针对每个节点都有选和不选两种情况
    class Solution {

        /*
         * 暴力解法其实有两个递归，第一个pathSum递归其实是为了遍历到每个节点，第二个递归是为了从每个节点，
         * 开始解决有没有当前节点下的路径和为targetSum的，
         */
        public int pathSum(TreeNode root, int targetSum) {
            int ans = dfs(root, targetSum);

            ans += pathSum(root.left, targetSum);
            ans += pathSum(root.right, targetSum);

            return ans;
        }

        // 这里的dfs其实没有回溯
        int dfs(TreeNode rNode, int targetSum) {
            int cnt = 0;

            if (rNode == null) {
                return 0;
            }

            if (rNode.val == targetSum) {
                cnt++;
            }

            cnt += dfs(rNode.left, targetSum - rNode.val);
            cnt += dfs(rNode.right, targetSum - rNode.val);

            return cnt;
        }
    }

    // 前缀和 + 哈希表 + dfs + 二叉树
    class Solution2 {
        int ans = 0;

        public int pathSum(TreeNode root, long targetSum) {
            Map<Long, Integer> map = new HashMap<>();

            // 1. 没注意到什么都不选也是一种情况
            map.put(0l, 1);

            dfs(root, targetSum, 0l, map);

            return ans;
        }

        void dfs(TreeNode rNode, long targetSum, long sum, Map<Long, Integer> map) {
            if (rNode == null) {
                return;
            }

            // 突然懵了一下我以为map的状态只保存在当前递归过程中，
            // 不影响后续，但map其实是在整个递归过程中都可见的

            sum += rNode.val;
            ans += map.getOrDefault(sum - targetSum, 0);

            map.merge(sum, 1, Integer::sum);

            dfs(rNode.left, targetSum, sum + rNode.val, map);
            dfs(rNode.right, targetSum, sum + rNode.val, map);

            // 回溯
            map.merge(sum, -1, Integer::sum);
        }
    }
}
