

def countSubarrays(self, nums: List[int], k: int) -> int:
    ans = sumNum = 0
    left = 0
    for i, x in enumerate(nums):
        sumNum += x
        while sumNum * (i - left + 1) >= k:
            sumNum -= nums[left]
            left += 1
        ans += i - left + 1
    return ans