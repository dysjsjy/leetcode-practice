

from typing import List

# 一、只在矩阵的行上做二分查找
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n = len(matrix)
        m = len(matrix[0])
        for i in range(n):
            l, r = 0, m - 1
            if target < matrix[i][l]:
                break
            if not(target >= matrix[i][l] and target <= matrix[i][r]):
                continue
            while l <= r:
                mid = l + (r - l) // 2
                if matrix[i][mid] > target:
                    r = mid - 1
                else:
                    l = mid + 1
                if target == matrix[i][r]:
                    return True
        return False
'''
由于整个矩阵的每行是有规律的，即如果target在这一行，
则这行第一个数<= target <= 这一行最后一个数，
如果这行第一个最小的数就已经大于target了，那这行其实就可以直接跳过，
找到符合条件的行时，就可以直接在每行上使用二分查找，
标准的二分查找，左闭右闭，
时间复杂度(n*log2m)，
最坏的情况下每行都要遍历所以为n，然后对每行中的元素进行二分查找，log2m，
空间复杂度(1),
仅使用了常量空间，
'''
    
# 二、将整个矩阵看成一个一维数组，在整个一维数组上做二分查找
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n, m = len(matrix), len(matrix[0])
        l, r = 0, n * m - 1
        while l <= r:
            mid = l + (r - l) // 2
            cur = matrix[mid // m][mid % m]
            if cur == target:
                return True
            if cur > target:
                r = mid - 1
            else:
                l = mid + 1
        return False
    
'''
将整个矩阵看成一个一维数组，在整个一维数组上做二分查找，
左闭右闭，
left初始化为0， right初始化为m * n - 1，即矩阵的最后一个元素，
将一维数组对应到二维矩阵上，mid = l + (r - l) // 2，cur = matrix[mid // m][mid % m]，
比如说想知道当前假象的一维数组中的元素在矩阵到底是第几行第几列，
[mid // m][mid % m]，
mid是一维数组中的排序数，m为每行由多少个数，
mid整除m得到行，mid取余m得到列，
时间复杂度(log2n*m)，
n*m为矩阵的总体大小，log2x为二分查找的时间复杂度，
空间复杂度(1)，
仅使用了常量的空间，
'''