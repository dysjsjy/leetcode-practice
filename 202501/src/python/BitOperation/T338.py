

from typing import List

def countBits(self, n: int) -> List[int]:
    bit = [0]
    for i in range(1, n + 1):
        bit.append(bit[i & (i - 1)] + 1)
    return bit

def countBits2(self, n: int) -> List[int]:
    ans = [0] * (n + 1)
    for i in range(n + 1):
        ans[i] = i.bit_count()
    return ans