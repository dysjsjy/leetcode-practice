
from collections import deque
from typing import List, Optional

from hot100.Type import TreeNode


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        que = deque()
        ans = []
        que.append(root)
        while que:
            path = []
            for _ in range(len(que)):
                node = que.popleft()
                path.append(node.val)
                if node.left: que.append(node.left)
                if node.right: que.append(node.right)
            ans.append(path)
        return ans
'''
使用双端队列deque迭代，
重难点在如何确定每层的结束位置，
这里我们直接使用len(que)的方式，
每道题的惯例，首先先判断输入的数据是否为None，为None则直接返回，
初始化必要的参数，双端队列que，返回的结果ans，
当que不为空时，
每层用一个path来记录，
判断每层到底有几个节点直接使用for _ in range(len(que))就行了，
for结束后path中有装满了当前层所有的val，此时将path加入到ans中，
时间复杂度(n)
空间复杂度(n)
n为树节点的个数，会对每个节点进行append和pop操作，
空间复杂度看的其实是某一时间，这段程序占用的最大的空间，
对于path中，最坏的情况是树是一颗完全二叉树，path占用n/2的空间，把系数去掉就是O(n)，
对于ans来说，ans中最终会包含所有的node，也就是占用n的空间，也就是O(n)。
补充，这里是用一个双端队列来记录每层的值，其实也能用两个数组来记录，一个cur，一个nex，
每次循环中遍历cur中的节点，并取出节点的left和right，nex收集当前循环的节点，循环结束后将nex赋值给cur，
'''