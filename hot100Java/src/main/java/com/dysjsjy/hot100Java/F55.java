package com.dysjsjy.hot100Java;

public class F55 {

    // 预处理，初始化，迭代选择，返回结果
    // 局部最优，无回溯
    class Solution {
        public boolean canJump(int[] nums) {
            // 初始化
            int max = 0;
            // 迭代选择
            for (int i = 0; i < nums.length; i++) {
                // 如果前面每一步的最优都无法到达i，则说明到达不了直接返回false
                if (i > max) {
                    return false;
                }
                max = Math.max(max, i + nums[i]);
            }

            // 返回结果
            return true;
        }

        // 时间复杂度（n），空间复杂度（1）。
    }
}
