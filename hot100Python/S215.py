

import random
from typing import List


# 方法一，直接使用系统提供的排序方法，不过一般不能这样写
def findKthLargest(self, nums: List[int], k: int) -> int:
    return sorted(nums)[-k]
# 方法二、快速选择
def findKthLargest2(self, nums: List[int], k: int) -> int:
    def QuickSelect(nums: List[int], k: int):
        cur_v = random.choice(nums)
        small, equal, big = [], [], []
        for num in nums:
            if num < cur_v:
                small.append(num)
            elif nums > cur_v:
                big.append(num)
            else:
                equal.append(num)
        if len(big) >= k:
            return QuickSelect(big, k)
        elif len(num) - len(small) < k:
            return QuickSelect(small, k - len(nums) + len(small))
        return cur_v
    return QuickSelect(nums, k)
'''
快速选择的排序，QuickSelect是用于快速从一个nums中找到第k大的数的排序方法，
排序过程为，
先选择一个随机的cv来当本轮函数的哨兵值，
遍历nums，如果num比cv大则将num加入到big列表中，
如果num比cv小则将num加入到small中，
如果num等于cv则将num加入到equal中，
题目是要找第k大的，
如果k < len(big)，则说明k在big列表中，
如果len(nums) - len(small) < k，则说明k在small中
如果上面条件都不满足，则说明k就在equal中，equal的元素和cv一样，直接发挥cv就行了，这就是我们需要的第k大的数，
时间复杂度(N)，每次递归都会把nums完整遍历一遍，实际上最坏情况是，N, N/2, N/4, ..., N/N，即等比数列求和，
空间复杂度(log2N)，
'''