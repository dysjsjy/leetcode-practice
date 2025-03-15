

from typing import List


class Solution:
    # def maxProduct(self, nums: list[int]) -> int:
    #     n = len(nums)
    #     dp = [0] * n

    #     if n == 1:
    #         return nums[0]

    #     def dfs(i: int, maxSum: int) -> int:
    #         if i == n - 1:
    #             if nums[i] >= nums[i - 1]:
    #                 maxSum = max(maxSum, dp[i - 1] * nums[i])
    #             return maxSum
    #         if i == 0:
    #             dp[0] = nums[0]
    #         if i > 0:
    #             if nums[i] >= nums[i - 1]:
    #                 dp[i] = max(nums[i], dp[i - 1] * nums[i])
    #         maxSum = max(maxSum, dp[i])
    #         return dfs(i+1, maxSum)
    #     return dfs(0, - float('inf'))
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
                return 0
        n = len(nums)
        maxRes = minRes = result = nums[0]

        for i in range(1, n):
            if nums[i] < 0:
                maxRes, minRes = minRes, maxRes
            maxRes = max(nums[i], maxRes * nums[i])
            minRes = min(nums[i], minRes * nums[i])
            result = max(result, maxRes)
        return result
    
'''
子数组并没有说明是递增还是递减，所以不用考虑，
这道题是有顺序的遍历子数组，所以直接迭代就行，
为什么要同时处理最大和最小？因为要对负数进行处理，
最小乘负数就是最大了，最大乘负数就是最小了，
最大其实就在绝对值最大中产生，
更新的逻辑是当遇到负数就交换当前的最大和最小，
当前格子的最大最小要么是格子本身，要么是最大/最小乘当前格子，
最后更新result，result存储到此格子为止的最大数，
时间复杂度(n)，
空间复杂度(1)，
'''