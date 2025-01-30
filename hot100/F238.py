

from typing import List

# 也是神人才能写出这种东西
def productExceptSelf(self, nums: List[int]) -> List[int]:
    n = len(nums)
    cnt_left = cnt_right = list()
    cnt_left.append(1)
    cnt_right.append(1)
    tp_left = tp_right = 1
    for i in range(n):
        tp_left *= nums[i]
        cnt_left.append(tp_left)
    # 123, 1, 1, 2, 6
    for i in range(n - 1, 0, -1):
        tp_right *= nums[i]
        cnt_right.append(tp_right)
    ans = list()
    for i in range(n):
        ans.append(cnt_left[i] * cnt_right[i])
    return ans

def productExceptSelf2(self, nums: List[int]) -> List[int]:
    n = len(nums)
    pre = [1] * n
    for i in range(1, n):
        pre[i] = pre[i - 1] * nums[i - 1]
    suf = [1] * n
    for i in range(n - 2, 0, -1):
        suf[i] = suf[i + 1] * nums[i + 1]
    return [x * y for x, y in zip(pre, suf)]
'''
pre记录当前位置左边的所有数字相乘的结果，
suf记录当前位置右边的所有数字相乘的结果，
重点考虑当位置为0和n - 1时，
当位置为0时，pre[0]应该为1，suf[0]应该为nums中除nums[0]外的所有数字相乘，
所以pre[i]实际上是0～i-1的所有数字乘
suf[i]是n-1～i+1的所有数字相乘
i代表nums[i]
'''