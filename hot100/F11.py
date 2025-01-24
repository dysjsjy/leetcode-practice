

from collections import defaultdict
from typing import List

# 暴力解法超时
def maxArea(self, height: List[int]) -> int:
    ans = 0
    for i in range(len(height)):
        for j in range(i + 1, len(height)):
            ans = max(ans, (min(height[i], height[j]) * (j - i)))
    return ans

# 错误
def maxArea2(self, height: List[int]) -> int:
    d = defaultdict()
    for i in range(len(height)):
        d[height[i]] = i
    sortedHeight = list.copy(height)
    sorted(sortedHeight)
    for i in sortedHeight:
        cur = i
        curIdx = d[cur]
        next = curIdx
        while cur <= height[next] and next < len(height):
            next += 1
        ans = max(ans, cur * (next - curIdx))
    return ans

# 灵神
def maxArea3(self, height: List[int]) -> int:
    left, right = 0, len(height) - 1
    ans = 0
    while left < right:
        anstemp = (right - left) * min(height[left], height[right])
        ans = max(ans, anstemp)
        if height[left] < height[right]:
            left += 1
        else:
            right += 1
    return ans