

from collections import deque
import heapq
from typing import List


class Solution:
    # def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
    #     l, r = 0, 0
    #     priority_queue = []
    #     ans = []
    #     for i in range(k):
    #         heapq.heappush(priority_queue, -nums[i])
    #     ans.append(-priority_queue[0])
    #     for i in range(k, len(nums)):
    #         heapq.heappush(priority_queue, -nums[i])
    #         priority_queue.remove(-nums[l])
    #         l += 1
    #         ans.append(-priority_queue[0])
    #     return ans

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        ans = []
        q = deque()
        for r, n in enumerate(nums):
            # 进入队列，保证队列为递减队列，
            while q and nums[q[-1]] <= n:
                q.pop()
            # 再加入当前元素的下标
            q.append(r)
            # 出队列，如果当前窗口中的最大元素已经不在窗口中了，就弹出
            if r - q[0] >= k:
                q.popleft()
            # 加入ans，实际上ans中的元素是k - 1开始的
            if r >= k - 1:
                ans.append(nums[q[0]])
        return ans
'''
时间复杂度（n），
空间复杂度（1），
'''