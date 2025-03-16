package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class F105 {

    // 来自灵神
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> index = new HashMap<>();

            for (int i = 0; i < inorder.length; i++) {
                index.put(inorder[i], i);
            }

            return dfs(preorder, 0, preorder.length, 0, inorder.length, index);
        }

        private TreeNode dfs(int[] preorder, int pl, int pr, int il, int ir, Map<Integer, Integer> index) {
            if (pl == pr) {
                return null;
            }

            int leftSize = index.get(preorder[pl]) - il;

            TreeNode left = dfs(preorder, pl + 1, pl + 1 + leftSize, il, il + leftSize, index);
            TreeNode right = dfs(preorder, pl + 1 + leftSize, pr, il + 1 + leftSize, ir, index);

            return new TreeNode(preorder[pl], left, right);
        }

        // 时间复杂度（n），空间复杂度（n），preorder有几个节点就要递归几次，map存储了n个节点。
    }
}
