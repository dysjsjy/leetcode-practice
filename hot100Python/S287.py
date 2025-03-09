

from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        min, max = 1, len(nums)
        while min < max:
            mid = (max + min) // 2
            cnt = sum(min <= num <= mid for num in nums)
            if cnt > mid - min + 1:
                max = mid
            else:
                min = mid + 1

        return min