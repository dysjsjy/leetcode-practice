


from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] >= nums[r]:
                l = mid + 1
            else:
                r = mid
        return r
    
    def lowbound(self, l: int, r: int, nums: List[int], target: int) -> int:
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] <= target:
                l = mid + 1
            else:
                r = mid - 1
        return r if nums[r] == target else -1

    def search(self, nums: List[int], target: int) -> int:
        i = self.findMin(nums)
        if target > nums[-1]:
            return self.lowbound(0, i - 1, nums, target)
        return self.lowbound(i, len(nums) - 1, nums, target)

'''
时间复杂度(log2n)，所有查找过程中都使用了二分查找，二分查找的时间复杂度为log2n，
空间复杂度(1)， 仅使用了常量空间，
'''

'''
二分查找的关键在于如何确定区间，
我一般使用的是闭区间[l, r]，
因为l和r都能取到，所以while循环条件为，l <= r，即当l = r时仍然有意义，
感觉还是现场举例子想一遍边界条件。
'''