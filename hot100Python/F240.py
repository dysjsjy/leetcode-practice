

from typing import List

# (1)模拟
def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    rows, cols = len(matrix), len(matrix[0])
    for i in range(rows):
        if matrix[i][0] <= target <= matrix[i][cols - 1]:
            for j in range(cols):
                cur = matrix[i][j]
                if cur > target:
                    continue
                elif cur == target:
                    return True 
        else:
            continue
    return False
'''
把需要的变量列出来，矩阵的行数和列数，
逐行遍历矩阵，
由题可知，如果target在这一行，那么matrix[i][0] <= target <= matrix[i][cols - 1]，
在逐步遍历当前行时，如果当前位置的值大于target，则target不可能在这一行了，就continue跳过这一行，
小于的情况继续遍历，等于的情况就直接返回True
全部遍历完仍然未找到target就返回False。
'''

# (2)两个指针，右上角开始删减
def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    l, r, u, d = 0, len(matrix[0]) - 1, 0, len(matrix) - 1
    while l <= r and u <= d:
        cur = matrix[u][r]
        if cur < target:
            u += 1
        elif cur > target:
            r -= 1
        else:
            return True
    return False
'''
l, r, u, d分别代表左右上下边界，
while循环判断条件l <= r and u <= d保证不越界，
如果cur小于target则说明当前行不存在target，u += 1向下移动，
如果cur大于target则说明当前列不存在target，r -= 1向左移动，
找到target则返回True，
遍历完找不到则返回False。

为什么当矩阵只有一行或者一列时，不会报错？
只有一行或者一列时l <= r and u <= d仍然满足
当判断cur < target或者cur > target，对u或者r进行操作后，如果此时越界了，则说明target不存在矩阵中，
没越界则继续遍历完。

l, r, u, d其实可以优化，有些变量不需要明着写出来。
'''