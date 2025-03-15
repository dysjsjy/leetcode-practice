

from typing import List


def setZeroes(self, matrix: List[List[int]]) -> None:
    """
    Do not return anything, modify matrix in-place instead.
    """
    m, n = len(matrix), len(matrix[0])
    fr_row = any(matrix[0][i] == 0 for i in range(n))
    fr_col = any(matrix[i][0] == 0 for i in range(m))

    for i in range(1, m):
        for j in range(1, n):
            if matrix[i][j] == 0:
                matrix[0][j] = matrix[i][0] = 0
    
    for i in range(1, m):
        for j in range(1, n):
            if matrix[0][j] == 0 or matrix[i][0] == 0:
                matrix[i][j] = 0
    
    if fr_row:
        for i in range(n):
            matrix[0][i] = 0

    if fr_col:
        for i in range(m):
            matrix[i][0] = 0

'''
不使用额外的空间，来将矩阵中出现0的对应的行和列都变为0，
这里我们可以使用矩阵的第一行和第一列来记录需要全部变为0的行和列，
由于我们使用了矩阵中原本的第一行和第一列，那么如果第一行或者第一列中本来就有0，
即它们也是需要全部变为0的呢，在作记录的过程中后丢失这部分信息，
所以我们先对其进行遍历，用两个变量fr_row和fr_col进行记录其是否需要全变为0，
之后遍历除第一行和第一列的所有元素，如果元素为0，则把对应的第一行和第一列中的元素变为0，
再将除第一行和第一列的所有元素遍历，如果该元素对对应的第一行或者第一列中的元素为0，
则表示该元素是被改变为0的元素，将其变为0，
最后再检查第一行和第一列fr_row和fr_col，
如果为False，就把对应的第一行或者第一列变为0
'''