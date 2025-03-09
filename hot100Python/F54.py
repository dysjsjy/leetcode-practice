

from typing import List



# (1)模拟顺时针旋转的过程

def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
    # 1. 判断矩阵存在，不存在即返回空
    if not matrix or not matrix[0]:
        return list()
    # 2. 初始化变量，其实一开始不一定能想到所有的变量，先把必须的写上去
    col, row = len(matrix[0]), len(matrix)
    times = col * row
    cur_row, cur_col = 0, 0
    visited = [[False] * col for _ in range(row)]
    ans = [0] * (col * row)
    # 3. 用于顺时针旋转的数组地图
    directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    # 用于选择directions的变量
    idx = 0
    # 一共要循环col * row次
    for i in range(times):
        ans[i] = matrix[cur_row][cur_col]
        visited[cur_row][cur_col] = True
        next_row = cur_row + directions[idx][0]
        next_col = cur_col + directions[idx][1]
        # 易错点1， 这里的逻辑如果写判断错误的逻辑比较麻烦即当“越界”或者“被访问”任意条件发生时，就顺时针转向，
        # 我们直接反过来想，即not(“位置合法” 且 “未被访问”)即需要顺时针旋转
        if not (0 <= next_row < row and 0 <= next_col < col and not visited[next_row][next_col]):
            idx = (idx + 1) % 4
        # 易错点2，前面if对next_row和next_col做了判断，判断当前位置是否合规，但更新时直接写成下面注释中错误的形式
        # if是为了让每次更新合规且顺时针转向，判断了就应该用判断后合规的数据，而不是直接使用判断前的数据
        '''
        cur_row = next_row
        cur_col = next_col
        '''
        cur_row += directions[idx][0]
        cur_col += directions[idx][1]
    return ans
'''
时间复杂度：row*col，矩阵的每个位置都要被访问一遍
空间复杂度：row*col，创建的ans矩阵和visited矩阵
'''


# (2)使用四个指针控制，螺旋遍历
def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
    # 1. 左右上下表示当前的一圈
    l, r, u, d = 0, len(matrix[0]) - 1, 0, len(matrix) - 1
    ans = list()
    while l <= r and u <= d:
        # 这里的if都是保证在while循环内对lrud进行操作时，不会出现去遍历一个不存在的区域
        # 遍历上面的行
        if u <= d:
            for j in range(l, r + 1):
                ans.append(matrix[u][j])
            u += 1
        # 遍历右边的列
        if l <= r:
            for i in range(u, d + 1):
                ans.append(matrix[i][r])
            r -= 1
        # 遍历下面的行
        if u <= d:
            for j in range(r, l + 1, -1):
                ans.append(matrix[d][j])
            d -= 1
        # 遍历左边的列
        if l <= r:
            for i in range(d, u, -1):
                ans.append(matrix[i][l])
            l += 1
    return ans