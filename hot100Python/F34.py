


from typing import List

# # 一、左闭右闭，两遍二分查找，没写出来
# class Solution:
#     def searchRange(self, nums: List[int], target: int) -> List[int]:
#         left, right = -1, -1
#         l, r = 0, len(nums) - 1
#         while l <= r:
#             mid = l + (r - l) // 2
#             if target == nums[mid] and nums[l] != target and nums[r] == target:
#                 left = r
#                 break
#             if target > nums[mid]:
#                 l = mid + 1
#             else:
#                 r = mid - 1
#         l, r = 0, len(nums) - 1
#         while l <= r:
#             mid = l + (r - l) // 2
#             if target == nums[mid] and nums[l] == target and nums[r] != target:
#                 right = l
#                 break
#             if target > nums[mid]:
#                 l = mid + 1
#             else:
#                 r = mid - 1
#         return list(left, right)
# '''
# 这其实相当于，两遍二分查找，
# 不过没写出来，
# '''

'''
1233345
'''

# 来自灵神，两遍二分，左闭右闭
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # 找出最左边的target
        def lower_bound(nums: List[int], target: int) -> int:
            l, r = 0, len(nums) - 1
            while l <= r:
                mid = l + (r - l) // 2
                if nums[mid] >= target:
                    r = mid - 1
                else:
                    l = mid + 1
            return l
        start = lower_bound(nums, target)
        if not (start >= 0 and start < len(nums) - 1):
            return [-1, -1]
        # 很绝的一手
        end = lower_bound(nums, target + 1) - 1
        return [start, end]