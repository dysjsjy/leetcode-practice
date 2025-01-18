

from typing import List


def validStrings(self, n: int) -> List[str]:
    ans = []
    mask = (1 << n) - 1
    for x in range(1 << n):
        if (x >> 1) & x == 0:
            ans.append(f"{x ^ mask:0{n}b}")
    return ans


def validStrings2(self, n: int) -> List[str]:
    ans = []
    path = [''] * n
    def dfs(i: int) -> None:
        if i == n:
            ans.append(''.join(path))
            return
        
        path[i] = '1'
        dfs(i + 1)

        if i == 0 or path[i - 1] == '1':
            path[i] = '0'
            dfs(i + 1)
    dfs(0)
    return ans