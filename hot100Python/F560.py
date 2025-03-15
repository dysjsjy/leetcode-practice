

from collections import defaultdict
from typing import List


def subarraySum(self, nums: List[int], k: int) -> int:
    left = 0
    sum_all = 0
    ans = 0
    for right in range(len(nums)):
        sum_all += nums[right]
        if sum_all < k:
            continue
        elif sum_all > k:
            sum_all -= nums[left]
            left += 1
        else:
            ans += 1
    return ans

# 哈西表+前缀和
def subarraySum2(self, nums: List[int], k: int) -> int:
    s = [0] * (len(nums) + 1)
    for i in range(len(nums)):
        s[i + 1] = nums[i] + s[i]

    ans = 0
    cnt = defaultdict()
    for sj in s:
        ans += cnt[sj - k]
        cnt[sj] += 1
    return ans
'''
为什么滑动窗口无法解决有负数的情况？
当right加入的数为负数时，sum减少，按理来说应该继续向右，但是这时应该向左，矛盾了
'''