from functools import reduce

from operator import xor
from typing import List


def minOperations(self, nums: List[int], k: int) -> int:
    n = len(nums)
    total = 0
    for num in nums:
        total ^= num
    c = total ^ k
    return c.bit_count()

def minOperations2(self, nums: List[int], k: int) -> int:
    return (reduce(xor, nums)).bit_count()
    # return reduce(lambda x, y: x ^ y, nums).bit_count()