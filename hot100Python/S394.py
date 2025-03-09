

class Solution:
    def decodeString(self, s: str) -> str:
        stack, res, multi = [], "", 0
        for c in s:
            if c == "[":
                stack.append([res, multi])
                res, multi = "", 0
            elif c == "]":
                last_res, cur_multi = stack.pop()
                res = last_res + res * cur_multi
            elif '0' <= c <= '9':
                multi = multi * 10 + int(c)
            else:
                res += c
        return stack.pop()[0]
    
'''
难点在于括号嵌套的情况，如2[2[2[a]]]，
这样就需要使用到stack的后进先出的特点，
从头到尾遍历str，用c表示当前遍历到的字符，
如果c是'['，则要为进入到一个嵌套的括号做准备，即将当前的cur_multi和上一个last_res入栈，
如果c是']'，则表示当前这层结束了，要把栈里的元素拿出来拼接，
注意res记录的是当前元素的res，所以pop()出stack的一个元素，让res = last_res + res * cur_multi，
这样res中存储的就是当前括号完结时的res了，但是上一个括号的res还没获得，
如果'0' <= c <= '9'，则表示这是一个multi的一位数，则把multi = multi * 10 + int(c)，这里要强行转换一下，
最后都不是就是res，在res中加入即可，
时间复杂度(n)，
空间复杂度(n)，当全是层嵌套时，需要使用n个栈暂时存储每层的元素。

'''

def decodeString2(self, s: str) -> str:
    def dfs(s: str, i: int):
        res, multi = "", 0
        while i < len(s):
            if s[i] == '[':
                cur_res, i = dfs(s, i + 1)
                res = res + cur_res * multi
                # 注意这里multi使用过后需要变成0
                multi = 0
            elif s[i] == "]":
                return res, i
            elif '0' <= s[i] <= '9':
                multi = multi * 10 + int(s[i])
            else:
                res += s[i]
            i += 1
        return res
    return dfs(s, 0)