

def countKConstraintSubstrings(self, s: str, k: int) -> int:
    left = ans = 0
    cnt = [0] * 2
    for i, x in enumerate(s):
        cnt[ord(x) & 1] += 1
        while cnt[0] > k and cnt[1] > k:
            cnt[ord(s[left]) & 1] -= 1
            left += 1
        ans += i - left + 1
    return ans