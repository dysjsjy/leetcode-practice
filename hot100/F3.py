

from collections import defaultdict


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        cnt = defaultdict()
        l, r = 0, 0
        ans = 0
        for r, c in enumerate(s):
            cnt[c] += 1
            while cnt[c] > 1:
                cnt[s[l]] -= 1
                l += 1
            ans = max(ans, r - l)
        return ans
    
    def lengthOfLongestSubstring2(self, s: str) -> int:
        windows = set()
        r, l = 0, 0
        ans = 0
        for r, c in enumerate(s):
            while c in windows:
                windows.remove(s[l])
                l += 1
            windows.add(c)
            ans = max(ans, r - l + 1)
        return ans
'''
经典滑动窗口，
defaultdict是有默认值的哈希表，就算访问没有创建的也不会报错，
滑动窗口的要点在于移动r指针将元素装入map中，并在这时判断当前的元素在窗口中的个数有没有大于1，
大于1则移动l指针逐渐收缩窗口，直到r指针指向的元素在窗口中没有超出1，
重点就在于r和l指针是怎么移动的。
时间复杂度（n），
空间复杂度（1），
'''