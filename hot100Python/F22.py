

from typing import List

# 一、回溯中使用数学归纳，其实也就是什么时候能放左括号，什么时候能放右括号的问题，
# 什么时候能放左括号？n没用完前
# 什么时候能放有括号？已经放了的括号中左括号大于等于右括号时
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        path = [''] * 2 * n
        def dfs(i: int, l: int) -> None:
            if i == 2 * n:
                ans.append(''.join(path))
            if l < n:
                path[i] = '('
                dfs(i + 1, l + 1)
            if i - l < l:
                path[i] = ')'
                dfs(i + 1, l)
        dfs(0, 0, 0)
        return ans
'''
感觉回溯就是把几种情况都写出来，然后dfs，
时间复杂度(),对于回溯问题，时间复杂度一般是，树的长度 * C(2n, n),
空间复杂度(n)。
'''