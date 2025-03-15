

from itertools import pairwise


def longestContinuousSubstring(self, s: str) -> int:
    ans = cnt = 1
    for x, y in pairwise(map(ord, s)):
        cnt = cnt + 1 if x + 1 == y else 1
        ans = max(ans, cnt)
    return ans