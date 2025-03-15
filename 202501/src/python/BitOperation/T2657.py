

from typing import List


def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
    p = q = 0
    ans = []
    for x, y in zip(A, B):
        p |= 1 << x
        q |= 1 << y
        ans.append((p & q).bit_count())
    return ans

# 暴力
def findThePrefixCommonArray2(self, A: List[int], B: List[int]) -> List[int]:
    n = len(A)
    ans = [0] * n
    s1 = set()
    for i in range(n):
        s1.add(A[i])
        cnt = 0
        for j in range(i + 1):
            if B[j] in s1:
                cnt += 1
        ans[i] = cnt
    return ans