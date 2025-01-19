

from itertools import pairwise
from typing import List


def findArray(self, pref: List[int]) -> List[int]:
    return [pref[0]] + [x ^ y for x, y in pairwise(pref)]

def findArray2(self, pref: List[int]) -> List[int]:
    ans = [pref[0]]
    for i in range(len(pref) - 1):
        ans.append(pref[i] ^ pref[i + 1])
    return ans