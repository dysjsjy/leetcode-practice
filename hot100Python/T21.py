


from typing import Optional

from hot100.Type import ListNode


def mergeTwoLists(list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    dummy = ListNode(-1)  # 哑节点，避免处理头节点的特殊情况
    prev = dummy  # 指向当前合并链表的最后一个节点

    while list1 and list2:
        if list1.val <= list2.val:
            prev.next = list1
            list1 = list1.next
        else:
            prev.next = list2
            list2 = list2.next
        prev = prev.next  # 移动 prev 指针

    # 处理剩余链表
    prev.next = list1 if list1 else list2

    return dummy.next  # 返回合并链表的头部

'''
pre永远指向前一个节点，
比较当前list1和list2的大小，
如果list1.val <= list2.val，prev.next就指向list1，
因为list1被连接过一次了，所以list1 = list1.next向后移一位，
else部分同理，
此时prev还未移动，prev需要指向新增的末尾，prev = prev.next，
在while循环中，循环条件是list1 and list2，
循环结束时将未连接的部分连接到prev后面，
dummy作为虚拟头节点，主要是帮助在最后返回合并链表的头节点，其次是帮助prev初始化。
'''