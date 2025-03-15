

from typing import List


def hasTrailingZeros(self, nums: List[int]) -> bool:
    cnt = 0
    for s in nums:
        if (s & 1) == 0:
            cnt += 1
    return cnt >= 2

def hasTrailingZeros2(self, nums: List[int]) -> bool:
    return len(nums) - sum(x % 2 == 0 for x in nums)