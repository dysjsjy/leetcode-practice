

def findComplement(self, num: int) -> int:
    s = 1
    for i in range(1, 31):
        if s << i < num:
            s <<= i
        else:
            break
    return (s - 1) ^ num

def bitwiseComplement(self, n: int) -> int:
    if n == 0:
        return 1
    mask = (1 << n.bit_length()) - 1
    return mask ^ n