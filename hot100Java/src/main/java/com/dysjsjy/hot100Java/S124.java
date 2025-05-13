package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.TreeNode;

public class S124 {

    class Solution {
        int ans = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            dfs(root);
            return ans;
        }

        int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            ans = Math.max(ans, left + right + root.val);
            return Math.max(Math.max(left, right) + root.val, 0);
        }
    }
}
