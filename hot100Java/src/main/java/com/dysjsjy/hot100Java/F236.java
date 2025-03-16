package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.TreeNode;

public class F236 {

    class Solution {

        // 灵神
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            String str = "hello";

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) {
                return root;
            }

            if (left != null) {
                return left;
            }

            if (right != null) {
                return right;
            }

            return null;

            // 上面的判断也可以简化为 return left != null ? left : right;
        }

        /*
           这里面对应了几种情况：
           1. root == null || root == p || root == q时都直接返回root，
           2. 如果left != null && right != null说明当前节点的左右节点中有p和q，即当前节点就是最近的公共节点，
           3. 最后返回这里left != null ? left : right，只要找不到left和right都为null，只要找到了就会返回找到的那个，
           时间复杂度（n），空间复杂度（n）。
         */
    }
}
