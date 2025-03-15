

class Solution:
    # def longestPalindrome(self, s: str) -> str:
    #     n = len(s)
    #     dp = [[1] * n] * n
    #     row_max = [1] * n
    #     ans = ""
    #     for i in range(1, n - 1):
    #         left, right = i - 1, i + 1
    #         while left >=0 and right <= n - 1 and s[left] == s[right]:
    #             dp[i][left] = dp[i][left - 1] + 1
    #             dp[i][right] = dp[i][right - 1] + 1
    #             left -= 1
    #             right += 1
    #             if row_max[i] < dp[i][left]:
    #                 ans = s[left : right + 1]
    #                 row_max[i] = right - left + 1
    #     return ans
    
    # 中心扩展法
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        start, end = 0, 0
        for i in range(n):
            left1, right1 = self.expandAroundCenter(s, i, i)
            left2, right2 = self.expandAroundCenter(s, i, i + 1)
            if right1 - left1 > end - start:
                start, end = left1, right1
            if right2 - left2 > end - start:
                start, end = left2, right2
        return s[start : end + 1]
    
    def expandAroundCenter(self, s: str, left: int, right: int):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        # 当结束循环时，left + 1和right - 1才是真正满足条件的区间，区间为左闭右闭
        return left + 1, right - 1