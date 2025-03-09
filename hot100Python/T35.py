

from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums)
        while left < right:
            # mid = (right + left) // 2
            mid = left + (right - left) // 2
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid
        return left
'''
1, 3, 6, 7, 8, 10
找8
0, 6
mid = 3
4, 6
mid = 5
4, 5
mid = 4
4, 4
'''