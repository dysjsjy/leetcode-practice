

from typing import List

# 暴力模拟，超时
def getMaximumXor(self, nums: List[int], maximumBit: int) -> List[int]:
    n = len(nums)
    ans = list()
    c = 2**maximumBit - 1
    for i in range(n):
        s = nums[0]
        for j in range(1, n - i):
            s ^= nums[j]
        ans.append(c ^ s)
    return ans

# 前缀异或
def getMaximumXor2(self, nums: List[int], maximumBit: int) -> List[int]:
    n = len(nums)
    xor = [None for _ in range(n)]
    c = nums[0]
    xor[0] = nums[0]
    for i in range(1, n):
        c ^= nums[i]
        xor[i] = c

    ans = list()
    s = 2**maximumBit - 1
    for i in range(n):
        ans.append(xor[n - i - 1] ^ s)
    return ans

def getMaximumXor3(self, nums: List[int], maximumBit: int) -> List[int]:
    m = pow(2, maximumBit)
    ans = list()
    total = 0
    for num in nums:
        total ^= num
        ans.append((m - 1) ^ total)
    return ans[::-1]