

from typing import Optional

from hot100.Type import ListNode

# 一、将链表转换为list，再对list进行排序，再转换为一个新的链表
def sortLis2(self, head: Optional[ListNode]) -> Optional[ListNode]:
    list1 = list()
    cur = head
    while cur:
        list1.append(cur.val)
        cur = cur.next
    list1.sort()
    dummy = ListNode()
    cur = dummy
    for i in range(len(list1)):
        cur.next = ListNode(list1[i])
        cur = cur.next
    return dummy.next

# 二、分治
def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    def middleNode(head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        mid = slow.next
        slow.next = None
        return mid
    def mergeTwoList(list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        cur = dummy = ListNode()
        while list1 and list2:
            if list1.val < list2.val:
                cur.next = list1
                list1 = list1.next
            else:
                cur.next = list2
                list2 = list2.next
            cur = cur.next
        cur.next = list1 if list1 else list2
        return dummy.next
    if head is None or head.next is None:
        return head
    head2 = middleNode(head)
    head = self.sortList(head)
    head2 = self.sortList(head2)
    return mergeTwoList(head, head2)