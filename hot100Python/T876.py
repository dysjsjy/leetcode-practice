

from typing import Optional

from hot100.Type import ListNode


def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
    fast = slow = head
    while fast.next and fast.next.next:
        fast = fast.next.next
        slow = slow.next
    
    return slow