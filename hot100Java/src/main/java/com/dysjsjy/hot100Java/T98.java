package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.TreeNode;

public class T98 {


    class Solution {
        public boolean isValidBST(TreeNode root) {
            return validBST(root, null, null);
        }

        // 对于左子树来说，当前的节点的值为上界，因为左子树上的值都小于当前节点的值，
        // 对于右子树来说，当前的节点的值为下界，因为右子树上的值都大于当前节点的值，
        boolean validBST(TreeNode root, Integer min, Integer max) {
            if (root == null) {
                return true;
            }

            // 这里比较的其实是左子树都要小于min
            if (min != null && root.val <= min) {
                return false;
            }

            // 这里比较的其实是右子树都要大于max
            if (max != null && root.val >= max) {
                return false;
            }

            return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
        }
        // 时间复杂度（n），空间复杂度（n）。


        // 二叉搜索树需要保证整个左子树和右子树都满足BST的条件，而不是仅在一组节点上
//        public boolean isValidBST(TreeNode root) {
//            if (root == null) {
//                return true;
//            }
//
//            if (root.left != null && root.val <= root.left.val) {
//                return false;
//            }
//
//            if (root.right != null && root.val >= root.right.val) {
//                return false;
//            }
//
//            boolean left = isValidBST(root.left);
//            boolean right = isValidBST(root.right);
//
//            return left && right;
//        }
    }
}
