
# 分组循环
def maxPower(self, s: str) -> int:
    l = r = ans = 0
    while l < len(s):
        while r < len(s) and s[r] == s[l]:
            r += 1
        ans = max(ans, r - l)
        l = r
    return ans