

def hasAlternatingBits1(self, n: int) -> bool:
    x = (n >> 1) ^ n
    return (x & (x + 1)) == 0

# 错误写法
def hasAlternatingBits2(self, n: int) -> bool:
    for i in range(1, n.bit_length()):
        a = n >> i & 1
        b = n >> (i - 1) & 1
        if a != b:
            return False
    return True