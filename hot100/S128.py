

from typing import List


def longestConsecutive(self, nums: List[int]) -> int:
    s = set(nums)
    ans = 0
    # 注意这里是s不是nums，因为set对nums进行了去重
    for x in s:
        if x - 1 in s:
            continue
        y = x + 1
        while y in s:
            y += 1
        ans = max(ans, y - x)
    return ans