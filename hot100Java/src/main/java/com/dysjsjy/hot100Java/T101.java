package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.TreeNode;

public class T101 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {

            return dfs(root.left, root.right);
        }

        boolean dfs(TreeNode leftNode, TreeNode rightNode) {
            if (leftNode == null && rightNode == null) {
                return true;
            }
            if (leftNode == null || rightNode == null) {
                return false;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }

//            boolean left = dfs(leftNode.left, rightNode.right);
//            boolean right = dfs(leftNode.right, rightNode.left);
//
//            return left && right;

            // 注意这种写法比上面的写法更高效，因为 && 具有短路特性，即当dfs(leftNode.left, rightNode.right)，
            // 返回false后dfs(rightNode.left, leftNode.right)就直接不执行了，直接整个返回false，
            // 但是如果用left && right的方法来写的化，会把两边的递归完整进行，因为left和right是值的比较，
            // 递归完成后才能比较。
            return dfs(leftNode.left, rightNode.right) && dfs(rightNode.left, leftNode.right);
        }

        // 时间复杂度（n），空间复杂度（n）,最坏的情况下二叉树是一条链递归需要O（n）的栈空间。

        // 灵神
        private boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) {
                return p == q;
            }
            return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
        }
        /*
            同样的return这里使用了 && 的短路技巧，即如果前面直接返回false了后面就不进行计算了。
         */
    }
}
