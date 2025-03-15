

from collections import defaultdict
from typing import List


def beautifulBouquet(self, flowers: List[int], cnt: int) -> int:
    l = 0
    cntF = defaultdict(int)
    ans = 0
    for i, x in enumerate(flowers):
        cntF[x] += 1
        while cntF[x] > cnt:
            cntF[flowers[l]] -= 1
            l += 1
        ans += i - l + 1
    return ans % (10**9 + 7)