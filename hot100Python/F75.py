

import random
from typing import List


class Solution:
    # 经典冒泡排序
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        for i in range(n):
            for j in range(i, n):
                if nums[i] > nums[j]:
                    nums[i], nums[j] = nums[j], nums[i]
    '''
    时间复杂度（n!），
    空间复杂度（1），
    '''
    # 统计数组个数再用dict、while循环重新填充数组
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nums0, nums1, nums2 = 0, 0, 0
        for n in nums:
            if n == 0:
                nums0 += 1
            elif n== 1:
                nums1 += 1
            else:
                nums2 += 1
        dic = {0: nums0, 1: nums1, 2:nums2}
        num = 0
        cnt = 0
        for i in range(len(nums)):
            while cnt == dic[num]:
                cnt = 0
                num += 1
            nums[i] = num
            cnt += 1
    '''
    时间复杂度（n），
    空间复杂度（1），
    '''