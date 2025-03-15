

from typing import List

# 一、递归dfs有向图
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g = [[] for _ in range(numCourses)]
        for a, b in prerequisites:
            g[b].append(a)
        
        colors = [0] * numCourses
        
        def dfs(x: int) -> bool:
            colors[x] = 1
            for y in g[x]:
                if colors[y] == 1 or colors[y] == 0 and dfs(y):
                    return True
            colors[x] = 2
            return False
        
        for i, c in enumerate(colors):
            if x == 0 and dfs(x):
                return False
        return True
'''
原来传入的数据是二维列表，不太好用，从题目中我们可以看出这就是一个判断有向图是否存在环的题目，
所以我们将二维列表转换成有向图，
由题可知，一共有numCourses个节点，我们用colors存储这些节点，方便我们遍历每一个节点，同时可以表示节点是否被访问过，
dfs递归遍历每个节点，
在dfs中，接受传入的节点值，将节点标记为正在访问，同时遍历当前节点连接的所有节点，
如果遍历到的其他节点也正在被访问，则存在环，在回溯阶段只要链表中存在环，就会返回True，
在dfs外，遍历每个节点，如果当前节点没有被访问过，且dfs判断存在环则表示无法修完所有课程，返回False，否则返回True。
时间复杂度(n + m)
空间复杂度(n + m)
n为节点，m为边，
'''