package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T94 {

    // 二叉树的中序遍历
    class Solution {
        List<Integer> ans = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return ans;
        }

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            dfs(root.left);

            ans.add(root.val);

            dfs(root.right);
        }
    }
}
