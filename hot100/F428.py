

from collections import Counter, defaultdict
from typing import List

# 错误写法
def findAnagrams(self, s: str, p: str) -> List[int]:
    p_set = set(p)
    p_cnt = [0] * 26
    ans = list(int)
    for x in p:
        p_cnt[ord(x) - ord('a')] += 1
    for i in range(len(s)):
        if s[i] in p_set:
            idx = i
            while s[idx] in p_set and p_cnt[s[idx]] - 1 >=0:
                p_cnt[s[idx]] -= 1
                idx += 1
            # 到这里算不出来了，大致意思是如果统计的字符串与p相同则加入结果
            ans.append(i)
        else:
            continue
    return ans

def findAnagrams2(self, s: str, p: str) -> List[int]:
    ans = []
    cnt_p = Counter(p)
    cnt_s = Counter()
    for right, c in enumerate(s):
        cnt_s[c] += 1
        left = right - len(p) + 1
        if left < 0:
            continue
        if cnt_s == cnt_p:
            ans.append(left)
        cnt_s[s[left]] -= 1
    return ans