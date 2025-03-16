package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class F199 {

    class Solution {

        // 二叉树的层序遍历
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (i == size - 1) {
                        ans.add(node.val);
                    }
                }
            }

            return ans;
        }

        // 时间复杂度（n），空间复杂度（n）。
        // 空间复杂度算的其实是程序在运行过程中最大的空间占用情况。


        // 灵神递归右中左，同时使用deep记录每层是否第一次到达
        public List<Integer> rightSideView2(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            dfs(root, 0, ans);
            return ans;
        }

        void dfs(TreeNode root, int deep, List<Integer> ans) {
            if (root == null) {
                return;
            }

            if (deep == ans.size()) {
                ans.add(root.val);
            }

            dfs(root.right, deep + 1, ans);
            dfs(root.left, deep + 1, ans);
        }

        // 时间复杂度（n），空间复杂度（n），n为二叉树节点数。
    }
}
