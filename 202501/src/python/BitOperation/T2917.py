

from typing import List


def findKOr(self, nums: List[int], k: int) -> int:
    ans = 0
    for i in range(max(nums).bit_length()):
        cnt = sum(num >> i & 1 for num in nums)
        if cnt >= k:
            ans |= 1 << i
    return ans