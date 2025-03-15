
def binaryGap(self, n: int) -> int:
    last, ans, i = -1, 0, 0
    while n:
        if n & 1:
            if last != -1:
                ans = max(ans, i - last)
            last = i
        n >>= 1
        i += 1
    return ans

# 错误写法
def binaryGap2(self, n: int) -> int:
    l1 = []
    while n != 0:
        l1.append(n & 1)
        n >>= 1
    ans = -1
    left = right = 0
    n = len(l1)
    while right < n:
        left = right
        while right < n:
            if l1[right] == 0:
                right += 1
            else:
                break
            right += 1
        ans = max(ans, right - left - 1)
    return ans