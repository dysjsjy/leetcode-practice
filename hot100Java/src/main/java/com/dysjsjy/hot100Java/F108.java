package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.TreeNode;

public class F108 {

    class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            return dfsBTS(nums, 0, nums.length - 1);
        }

        TreeNode dfsBTS(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfsBTS(nums, left, mid - 1);
            root.right = dfsBTS(nums, mid + 1, right);
            return root;
        }

        /*
            时间复杂度（n），空间复杂度（n）。
            时间复杂度：递归深度为 ​O(log n)，每层的工作量为 ​O(n)，因此总时间复杂度为 ​O(n)。
            空间复杂度：树的空间 ​O(n) 是主要部分，递归调用栈的空间 ​O(log n) 是次要部分。
         */


        // 错误方法，只选择一次链表中的mid节点来构造BST会平衡，
        // 必须使用递归对每次递归中的部分表都做同样的事
//        public TreeNode sortedArrayToBST(int[] nums) {
//            int mid = nums.length / 2;
//            TreeNode root = new TreeNode(nums[mid]);
//            TreeNode l = root;
//
//            for (int i = mid - 1; i > 0; i--) {
//                TreeNode node = new TreeNode(nums[i]);
//                if (nums[i] > root.val) {
//                    l.right = node;
//                } else if (nums[i] < root.val) {
//                    l.left = node;
//                }
//                l = node;
//            }
//
//            TreeNode r = root;
//            for (int i = nums.length - 1; i > mid; i--) {
//                TreeNode node = new TreeNode(nums[i]);
//                if (nums[i] > r.val) {
//                    r.right = node;
//                } else if (nums[i] < r.val) {
//                    r.left = node;
//                }
//                r = node;
//            }
//
//            return root;
//        }
    }
}
