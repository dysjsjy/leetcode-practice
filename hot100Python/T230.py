

from typing import Optional
from Type import TreeNode

# 一、中序遍历
def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
    def dfs(node: Optional[TreeNode]) -> int:
        if node is None:
            return -1
        node_left = dfs(node.left)
        if node_left != -1:
            return node_left
        nonlocal k
        k -= 1
        if k == 0:
            return node.val
        return dfs(node.right)
    return dfs(root)
'''
这种二叉搜索树我们一般假定有一个只有三个节点的树，左1，中2，右3，假设我们需要第三大的val。
二叉搜索树的中序遍历就是升序，
当遍历到的节点的序列是None时，返回-1，我们使用-1来表示没找到第k大的节点，没找到就一直往上传-1，
dfs左节点，在左节点中，左节点的左右节点都为None，直接返回了，左节点存在，所以对k - 1，左节点最终返回的是为右节点，右边节为空，所以返回-1，
dfs中间节点，在中间节点中，node_left为传上来的-1，同时也对k - 1，dfs中节点的右节点，
dfs右节点，右节点左右都为None，返回-1，此时对k - 1，k == 0，返回右节点的val，就是需要的第三大的val。
'''