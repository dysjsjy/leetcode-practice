

from typing import List


def doesValidArrayExist(self, derived: List[int]) -> bool:
    n = len(derived)
    for x0 in [0, 1]:
        original = [_ for _  in range(n)]
        original[0] = x0
        for i in range(1, n):
            original[i] = original[i - 1] ^ derived[i - 1]
        if original[n - 1] == original[0] ^ derived[n - 1]:
            return True
    return False

def doesValidArrayExist2(self, derived: List[int]) -> bool:
    ans = 0
    for s in derived:
        ans ^= s
    return ans == 0