

from typing import Optional

from Type import ListNode

# 一、双指针
def hasCycle(self, head: Optional[ListNode]) -> bool:
    fast = slow = head
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
        if fast == slow:
            return True
    return False
'''
这里的while循环其实只需要判断fast and fast.next，
slow不需要判断，因为slow走的都是fast走过的，
fast存在保证了fast.next的存在，fast.next.next的存在，
如果没有环，那么最终fast会为None，且退出while，返回False，
如果有环，fast和slow会在环中循环，由于fast比slow每次快一步，fast和slow一定会相遇，这时返回True。
'''