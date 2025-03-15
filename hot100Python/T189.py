

from typing import List

# 模拟手动，超时
def rotate(self, nums: List[int], k: int) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    n = len(nums)
    k = k % n
    for i in range(k):
        last = nums[n - 1]
        for j in range(n - 1, 1, -1):
            nums[j] = nums[j - 1]
        nums[0] = last

# 还是不行
def rotate2(self, nums: List[int], k: int) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    n = len(nums)
    k = k % n
    for i in range(k):
        nums = [nums[-1] + nums[: -1]]

def rotate3(self, nums: List[int], k: int) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    def reverse(left: int, right: int) -> None:
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1
    n = len(nums)
    k %= n
    reverse(0, n - 1)
    reverse(0, k - 1)
    reverse(k, n - 1)
# 移动数组等于旋转数组