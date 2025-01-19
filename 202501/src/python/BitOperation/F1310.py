

from typing import List

# 错误做法
def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
    ans = []
    for qu in queries:
        s = 0
        for i in range(qu[0], qu[1] + 1):
            s ^= arr[i]
        ans.append(s)
    return ans

# 前缀异或
def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
    xor = [0]
    for a in arr:
        xor.append(xor[-1] ^ a)
    ans = list()
    for qu in queries:
        ans.append(xor[qu[0]] ^ xor[qu[1] + 1])
    return ans