

from typing import List


def sortByBits(self, arr: List[int]) -> List[int]:
    return sorted(arr, key = lambda x : [x.bit_count(), x])