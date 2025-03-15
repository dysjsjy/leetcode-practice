

def hammingDistance(self, x: int, y: int) -> int:
    s = x ^ y
    ans = 0
    while s != 0:
        ans += s & 1
        s >>= 1
    return ans

def hammingDistance1(self, x: int, y: int) -> int:
    return (x ^ y).bit_count