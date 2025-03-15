package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.TreeNode;

public class T104 {

    class Solution {
        public int maxDepth(TreeNode root) {
            return dfs(root, 0);
        }

        int dfs(TreeNode root, int depth) {
            if (root == null) {
                return 0;
            }

            int left = dfs(root.left, depth + 1);
            int right = dfs(root.right, depth + 1);

            return Math.max(left, right) + 1;
        }
    }
}
