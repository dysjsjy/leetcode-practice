
"""
100
1000
11000
10000
10100
"""
def isPowerOfFour(self, n: int) -> bool:
    s = 1
    while s < n:
        s *= 4
    return s == n

def isPowerOfFour2(self, n: int) -> bool:
    return n > 0 and (n & (n - 1) == 0) and (n & 0x55555555) != 0