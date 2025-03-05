

from typing import List

# 递归会超时
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        dicts = [[0, 1], [1, 0]]
        n, m = len(grid), len(grid[0])

        def dfs(i: int, j: int, sum: int) -> int:
            if i == n - 1 and j == m - 1:
                return sum + grid[i][j]

            min_path = float('inf')
            
            for adx, ady in dicts:
                next_x, next_y = i + adx, j + ady
                if not(0 <= next_x < n and 0 <= next_y < m):
                    continue
                min_path = min(min_path, dfs(next_x, next_y, sum + grid[i][j]))

            return min_path
        return dfs(0, 0, 0)
# 注意break是跳出当前循环，结束了循环，
# 而continue是跳过本轮循环，没有结束循环。

    def minPathSum2(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        dp = [([float('inf')] * m) for _ in range(n)]

        dp[0][0] = grid[0][0]

        for i in range(n):
            for j in range(m):
                if i > 0:
                    dp[i][j] = min(dp[i][j], dp[i - 1][j] + grid[i][j])
                if j > 0:
                    dp[i][j] = min(dp[i][j], dp[i][j - 1] + grid[i][j])
        return dp[n - 1][m - 1]