


from collections import defaultdict
from typing import Optional

from hot100.Type import TreeNode
# 一、错误写法
# class Solution:
#     sum = 0
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
#         ans = 0
#         def dfs(node: Optional[TreeNode], targetSum: int) -> None:
#             if node is None:
#                 return None
#             self.sum += node.val
#             if self.sum == targetSum:
#                 nonlocal ans
#                 ans += 1
#             dfs(node.left, targetSum)
#             self.sum -= node.left.val if node.left else 0
#             dfs(root.right, targetSum)
#             self.sum -= node.right.val if node.right else 0
#         dfs(root, targetSum)
#         return ans
'''
递归中全局变量的错误使用导致错误
'''

# 二、前缀和
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        dic = defaultdict(int)
        ans = 0
        def dfs(node: Optional[TreeNode], targetSum: int, sum) -> None:
            if node is None:
                return
            sum += node.val
            if dic[sum - targetSum]:
                nonlocal ans
                ans += dic[sum - targetSum]
            dic[sum] += 1
            dfs(node.left, targetSum, sum)
            dfs(node.right, targetSum, sum)
            dic[sum] -= 1
        dfs(root, targetSum, 0)
        return ans
'''
注意defaultdict(int)必须初始化才能在未存在情况下给默认值，
比如ans += dic[sum - targetSum]，当dic[sum - targetSum]不存在时，由于设置了defaultdict(int)为int，所以会返回0，
ans += dic[sum - targetSum]，这一句就是前缀和，
意思是targetSum == dic[sum]时的个数加入ans中，
继续解释前缀和，
dic[sum - targetSum]是等于dic[sum - x]，
x就相当于我们需要的targetSum的后半部分，举个例子：1， 2， 3， 4， 5
1，3，6，10，15
我们需要求其中targetSum==5的部分，
sum = 6, x = 1的时候存在，即1，2，3中减去1，
而在前缀中1出现的次数为1，所以到3为止targetSum为5出现一次，
这个x其实不太好直接拿，但是x= sum - targetSum的，所以就用dic[sum - targetSum]表示在前缀中targetSum出现的个数。

时间复杂度(n)， n是树节点的个数，
空间复杂度(n)，递归中使用了n个dict空间，为什么使用了n个dict空间？因为树节点有n个。
'''