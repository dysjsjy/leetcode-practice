

from typing import Optional
from Type import ListNode

# 一、反转链表
# 不能用反转链表，因为题目表示不能改变原链表
def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
    def reverseList(head: ListNode) -> ListNode:
        pre = None
        cur = head
        while cur:
            next = cur.next
            cur.next = pre  # 翻转当前指针方向
            pre = cur
            cur = next
        return pre  # 反转后的新头结点
    reverseA, reverseB = reverseList(headA), reverseList(headB)
    rA, rB = reverseA,  reverseB
    pre = None
    while rA and rB and rA.val == rB.val:
        pre = rA
        rA = rA.next
        rB = rB.next
    # 恢复原链表
        headA = reverseList(reverseA)  # 再次反转回去
        headB = reverseList(reverseB)
    return pre

# 二、双指针
def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
    if not headA or not headB:
        return None
    a, b = headA, headB
    while a != b:
        a = a.next if a else headB
        b = b.next if b else headA
    return a
'''
为什么双指针正确？
粗略地看双指针法如果没有相等的就会一直循环，
但其实中间隐藏了一个None，即当a.next和b.next == None时，
双指针法保证了两个指针走的路线长度是一样的，都是走完a + b的长度，
如果在中间有同样的交点则返回，否则就是都走完整个a + b，最后同时走到None，返回None。
'''