package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.TreeNode;

public class T226 {

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            dfs(root);
            return root;
        }

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;

            dfs(root.left);
            dfs(root.right);
        }
    }
}
