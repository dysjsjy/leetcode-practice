

def minFlips(self, a: int, b: int, c: int) -> int:
    ans = 0
    for i in range(32):
        bit_a, bit_b, bit_c = (a >> i) & 1, (b >> i) & 1, (c >> i) & 1
        if bit_c == 0:
            ans += bit_a + bit_b
        else:
            ans += int(bit_a + bit_b == 0)
    return ans

def minFlips2(self, a: int, b: int, c: int) -> int:
    return ((a | b) ^ c).bit_count() + ((a & b & ~c)).bit_count()