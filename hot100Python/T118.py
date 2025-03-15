

from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        paths = [[1] * (i + 1) for i in range(numRows)]
        for i in range(2, numRows):
            for j in range(1, i):
                paths[i][j] = paths[i - 1][j - 1] + paths[i - 1][j]
        return paths
    
'''
先创建处基本的杨辉三角形结构，要几层就构建几层全部是1的二维数组，
注意这个二维数组并不是n*n类型的，而是从1开始每层加1的二维数组，
所以创建代码为paths = [[1] * i + 1 for i in range(numRows)]，
创建好后对代码内部的需要修改的地方进行修改，
由于每行的第一个和最后一个元素必定为1，所以在遍历的时候要跳过这两个，
我们可以很清楚地看到从第三层开始，paths[i][j] = paths[i - 1][j] + paths[i - 1][j - 1]，
确定边界条件，i - 1和j - 1不越界，从第三层开始遍历，也就是i = 2的时候，所以i肯定不越界，
j从1开始，一直遍历到第i - 1个，因为每行的最后一个元素都跟这行的row有关，都和这行的row数相等，所以内层range条件为(1, i)，
时间复杂度(n^2)，
空间复杂度(n^2)，
'''