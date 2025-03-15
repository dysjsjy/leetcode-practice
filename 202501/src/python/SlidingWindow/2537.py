

from collections import defaultdict
from typing import List


def countGood(self, nums: List[int], k: int) -> int:
    left, pairs, ans = 0
    cnt = defaultdict(int)
    
    for x in nums:
        pairs += cnt[x]
        cnt[x] += 1
        while pairs >= k:
            cnt[nums[left]] -= 1
            pairs -= cnt[nums[left]]
            left += 1
        ans += left

    return ans
    
# 要去看看collections包，defaultdict创建出的字典，相当于Java中的Map，会当创建不存在的键时会自动创建
# 如果直接使用dict的话不会且会报错