


from typing import Optional
from Type import TreeNode


def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
    ans = 0
    def dfs(root: Optional[TreeNode]) -> int:
        if root is None:
            return -1
        left_length = dfs(root.left) + 1
        right_length = dfs(root.right) + 1
        sum = left_length + right_length
        nonlocal ans
        ans = max(ans, sum)
        return max(left_length, right_length)
    dfs(root)
    return ans

'''
使用dfs遍历二叉树，
对于每个根节点，需要返回的其实是左子树和右子树中最大的深度，
为什么当root为None时需要返回None？因为left_length = dfs(root.left) + 1，即没有要为0，
ans在递归中随时更新为最大的。
时间复杂度(n)，n为二叉树节点个数，
空间复杂度(n)，递归需要使用到栈所以为n，
'''