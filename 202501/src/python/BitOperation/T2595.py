

from typing import List


def evenOddBit(self, n: int) -> List[int]:
    ans = [0, 0]
    idx = 0
    while n:
        ans[idx] += (n & 1)
        n >>= 1
        idx ^= 1
    return ans

def evenOddBit2(self, n: int) -> List[int]:
    even = 0
    odd = 0
    for i in range(n.bit_length()):
        if i % 2 == 0:
            if ((n >> i) & 1) == 1:
                even += 1
        else:
            if ((n >> i) & 1) == 1:
                odd += 1
    return [even, odd]

def evenOddBit3(self, n: int) -> List[int]:
    MASK = 0x5555
    return [(MASK & n).bit_count(), ((MASK >> 1) & n).bit_count()]