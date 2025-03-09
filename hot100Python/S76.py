

from typing import Counter

'''
滑动窗口
分别用两个哈西map统计，一个cnt_s map统计滑动窗口内拥有的字母以及字母的个数，另一个cnt_t map统计需要找到的字符串拥有的字母以及对应的字母个数
用for循环，right指针从第一个元素开始不断向右移动指针，同时将right指针指向的字符装入cnt_s map中，
同时比较cnt_s, cnt_t两个map，如果cnt_t中的字母和对应字母的在cnt_s中都有且个数cnt_s >= cnt_t的，
此时的s[left: right + 1]就是符合条件的子字符串，题目要的是最小的符合条件的子字符串，就需要额外的两个变量来记录
这里我们使用ans_left, ans_right，当记录的子字符串的长度大于当前的子字符串长度即（right - left > ans_right - ans_left）时
就把ans_left, ans_right = left, right赋值一下
最后就可以移动left指针缩小子字符串的长度了，将left指针指向的cnt_s中的字母数量-1
重复这个过程到最后就能获得最小的包含t的子字符串了
'''

def minWindow(self, s: str, t: str) -> str:
    ans_left, ans_right = -1, len(s)
    cnt_s = Counter()
    cnt_t = Counter(t)
    left = 0
    for right, c in enumerate(s):
        cnt_s[c] += 1
        while cnt_s >= cnt_t:
            if right - left > ans_right - ans_left:
                ans_left = left
                ans_right = right
            cnt_s[s[left]] -= 1
            left += 1
    return "" if ans_left < 0 else s[ans_left : ans_right + 1]