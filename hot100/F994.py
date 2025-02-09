

from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid is None:
            return 0
        q = []
        n, m = len(grid), len(grid[0])
        fresh = 0
        for i, row in enumerate(grid):
            for j, cur in enumerate(row):
                if cur == 1:
                    fresh += 1
                elif cur == 2:
                    q.append((i, j))
        ans = 0
        while q and fresh:
            ans += 1
            temp = q
            q = []
            for x, y in temp:
                for i, j in (x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1):
                    if 0 <= i < n and 0 <= j <m and grid[i][j] == 1:
                        grid[i][j] = 2
                        fresh -= 1
                        q.append((i, j))
        return -1 if fresh else ans
    
'''
首先判断grid是否为None，为None就直接结束程序并返回0，
先遍历整个图，统计其中的fresh的个数，并收集其中的坏苹果存入q中，
然后用while循环，判断条件为q and fresh，即一开始存在坏苹果且在遍历的过程中存在由新鲜苹果变为坏苹果，且还有新鲜水果，
遍历当前分钟下的坏苹果，将其上下左右四个方向上的好苹果变为坏苹果，并将好苹果的数量fresh - 1，同时将这个变化后的坏苹果加入到新建的q中，
运行完后，如果还有新鲜水果fresh存在即返回-1，否则返回需要的分钟数ans。
时间复杂度O(mn)，最坏的情况下遍历两次完整的图，
空间复杂度O(mn)，最坏的情况下存储两次完整的图。
'''