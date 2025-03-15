

from typing import Optional

from hot100.Type import TreeNode


class Solution:
    # 一、从右下角开始连接
    head = None
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return
        self.flatten(root.right)
        self.flatten(root.left)
        root.left = None
        root.right = self.head
        self.head = root
    '''
    用一个额外的head记录前一个节点，
    使用递归后序遍历树，后序遍历能在递归的回溯部分进行操作，
    注意后序遍历一般顺序为左右中，这里为右左中，要先遍历右节点，只有先遍历右节点回溯的时候才会从右下角开始，
    从右边最后一个节点开始，断开root.left = None，
    root.right = self.head，让当前节点指向head节点（前一个节点），此时为None，
    self.head = root，root处理完后，移动head到当前的head节点，
    '''

    # 二、使用迭代
    def flatten2(self, root: Optional[TreeNode]) -> None:
        if not root:
            return
        stack = [root]
        prev = None
        while stack:
            node = stack.pop()
            if prev:
                prev.left = None
                prev.right = node
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
            prev = node
    '''
    python中列表可以像栈一样操作，
    还是一样，如果root为None，则直接返回None，
    因为如果root为None，则在root.right和root.left不存在，会报错，此时stack，已经创建，里面有个None，所以可以进入while，
    node = stack.pop()，弹出栈顶元素，
    注意这里入栈需要先入right，再入left，这样弹出的时候才会先弹出left，对left进行处理，
    while循环中先对prev处理，在进行入栈，再更新prev，prev = node即刚刚处理的右边处理好的节点。
    ''' 