

from collections import defaultdict
from typing import List


def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
    ans = defaultdict(list)
    for i in range(len(strs)):
        cnt = 0
        for j in strs[i]:
            cnt += ord(j)
        ans[cnt].append(strs[i])
    return list(ans.values)



def groupAnagrams2(self, strs: List[str]) -> List[List[str]]:
    d = defaultdict(list)
    for s in strs:
        d[''.join(sorted(s))].append(s)  # sorted(s) 相同的字符串分到同一组
    return list(d.values())

'''
复习一下python字典的遍历和对应源码
'''