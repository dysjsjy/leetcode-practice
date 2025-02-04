

from typing import Optional
from Type import Node

# # 我只能想到在原链的基础上给每个node加一个唯一表示符号，之后创建一个新的ans，遍历的原链的过程中
# def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
#     dummy = Node()
#     prev = dummy
#     cur = head
#     while prev:
#         prev.next = Node(cur.val)
#         prev = prev.next
#         cur = cur.next
#     prev = dummy
#     cur = head
#     while prev:

# 一、灵神
def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
    if head is None:
        return None
    cur = head
    while cur:
        cur.next = Node(cur.val, cur.next)
        cur = cur.next.next
    cur = head
    while cur:
        if cur.random:
            cur.next.random = cur.random.next
        cur = cur.next.next
    cur = head.next
    while cur.next:
        cur.next = cur.next.next
        cur = cur.next
    return head.next
'''
遍历三次，第一次将每个原列表节点后跟一个复制的节点，
第二次将将复制的节点的random连接对位置，
通过原节点的相对位置定位复制节点的位置，即复制节点random连接的就是原节点random后的一个复制节点，
第三次遍历将复制节点的next指向下一个复制节点，
最后返回head.next即第一个复制节点。
'''
# 二、哈西表
def copyRandomList2(self, head: 'Optional[Node]') -> 'Optional[Node]':
    dic = {}
    cur = head
    while cur:
        dic[cur] = Node(cur.val)
        cur = cur.next
    cur = head
    while cur:
        dic[cur].next = dic.get(cur.next)
        dic[cur].random = dic.get(cur.random)
        cur = cur.next
    return dic[head]