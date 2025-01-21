

from typing import List
from collections import Counter


def countTriplets(self, arr: List[int]) -> int:
    n = len(arr)
    ans = 0
    xors = [0]
    for a in arr:
        xors.append(xors[-1] ^ a)
    for j in range(1, n - 1):
        for i in range(j):
            for k in range(j, n):
                if xors[i] == xors[k + 1]:
                    ans += 1
    return ans

# 两个哈西表
def countTriplets2(self, arr: List[int]) -> int:
    n = len(arr)
    xors = [0]
    for a in arr:
        xors.append(xors[-1] ^ a)
    cnt, total = Counter(), Counter()
    ans = 0
    for k in range(n):
        if xors[k + 1] in cnt:
            ans += cnt[xors[k + 1]] * k - total[xors[k + 1]]
        cnt[xors[k]] += 1
        total[xors[k]] += k
    return ans