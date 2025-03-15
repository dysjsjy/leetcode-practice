
from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        n = len(board)
        m = len(board[0])
        def dfs(k: int, i: int, j: int) -> bool:
            if board[i][j] != word[k]:
                return False
            if k == len(word) - 1:
                return True
            board[i][j] = ''
            for x, y in (i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1):
                if 0 <= x < n and 0 <= y < m and dfs(k + 1, x, y):
                    return True
            board[i][j] = word[k]
            return False
        return any(dfs(0, i, j) for i in range(n) for j in range(m))