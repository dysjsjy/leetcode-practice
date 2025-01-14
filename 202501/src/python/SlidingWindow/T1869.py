
# 分组循环
def checkZeroOnes(self, s: str) -> bool:
    zero = one = 0
    l = r = 0
    while l < len(s):
        r = l
        while r < len(s) and s[r] == s[l]:
            r += 1
        if s[l] == '0':
            zero = max(zero, r - l)
        elif s[l] == '1':
            one = max(one, r - l)
        l = r
    return one > zero