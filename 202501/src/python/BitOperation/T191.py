

def hammingWeight(self, n: int) -> int:
    ans = 0
    while n != 0:
        if (n & 1) == 1:
            ans += 1
        n >>= 1
    return ans
# 或者，return n.bit_count()