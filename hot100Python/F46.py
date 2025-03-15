

from typing import List

# 一、使用list回溯
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        ans = []
        def re(nums: List[int], path: List[int]) -> None:
            if not nums:
                nonlocal ans
                ans.append(path[:])
            for i in range(len(nums)):
                path = path + [nums[i]]
                new_nums = nums[:i] + nums[i + 1:]
                re(new_nums, path)
                # 这相当于是dfs中的回溯阶段
                path.remove(nums[i])
        re(nums, [])
        return ans

# 二、使用visited标记回溯
class Solution2:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        n = len(nums)
        visited = [False] * n
        path = [0] * n
        ans = []
        def re(x: int) -> None:
            if x == n:
                # 注意这里不能写成ans.append(path)，因为这样添加的其实是path的引用而不是path的值，
                # 这样会导致最后ans中全是最后一次path的结果。
                ans.append(path.copy())
                return
            for i in range(n):
                if visited[i] is False:
                    visited[i] = True
                    path[x] = nums[i]
                    re(x + 1)
                    visited[i] = False
        re(0)
        return ans