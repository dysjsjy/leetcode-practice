

def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
    if k <= 1:
        return 0
    left = ans = 0
    sum = 1
    for i, x in enumerate(nums):
        sum *= x
        while sum >= k:
            sum //= nums[left]
            left += 1
        ans += i - left + 1
    return ans