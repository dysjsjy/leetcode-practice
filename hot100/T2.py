


from typing import Optional

from hot100.Type import ListNode

# chatgpt版
def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    ans = ListNode()  # 伪头节点
    head = ans
    cnt = 0  # 进位

    while l1 or l2 or cnt:  # 任何一个非空都要继续
        v1 = l1.val if l1 else 0
        v2 = l2.val if l2 else 0

        sum = v1 + v2 + cnt
        cnt = sum // 10  # 计算进位
        ans.next = ListNode(sum % 10)  # 余数作为当前节点值
        ans = ans.next  # 移动指针

        if l1: l1 = l1.next
        if l2: l2 = l2.next

    return head.next  # 跳过伪头节点
'''
设置虚拟头节点head，
记录进位cnt，
while循环中l1 or l2 or cnt任意一个非空都要继续，
v1, v2的赋值方式保证了就算l1或者l2为None，都能正常对sum进行计算，
整数除可以直接写成sum // 10而不是int(sum / 10)，
ans.next = ListNode(sum % 10)保证了，此轮循环结果的有效，同时避免创建额外的ListNode空节点，
l1, l2的移动处理，如l1: l1 = l1.next保证即使l1或者l2为None或者都为None，都能正常运行，
返回head.next，跳过伪头节点。
'''

def addTwoNumbers2(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    ans = ListNode()
    head = ans
    sum, cnt = 0, 0
    while l1 or l2 or cnt:
        v1 = l1.val if l1 else 0
        v2 = l2.val if l2 else 0
        sum = v1 + v2 + cnt
        cnt = 0
        cnt = sum // 10
        sum %= 10
        # 这里其实多余了，将当前的ans.val = sum导致要判断下一次还有没有l1 or l2 or cnt，
        # 可以直接写成ans.next = ListNode(sum % 10)，即本次判断的结果就是下一个节点的值，这样就不用判断l1 or l2 or cnt了，
        ans.val = sum
        l1 = l1.next if l1 else None
        l2 = l2.next if l2 else None
        if l1 or l2 or cnt:
            ans.next = ListNode()
            ans = ans.next
    return head

# 自己写的垃圾代码
# def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
#         ans = ListNode()
#         head = ans
#         cnt = 0
#         while l1 and l2:
#             sum = l1.val + l2.val + cnt
#             cnt = 0
#             if sum < 10:
#                 ans.val = sum
#             else:
#                 ans.val = sum % 10
#                 cnt = int(sum / 10)
#             if l1.next or l2.next:
#                 ans.next = ListNode()
#                 ans = ans.next
#             l1 = l1.next
#             l2 = l2.next
#         if l1:
#             while l1:
#                 sum = l1.val + cnt
#                 cnt = 0
#                 if sum < 10:
#                     ans.val = sum
#                 else:
#                     ans.val = sum % 10
#                     cnt = int(sum / 10)
#                 if l1.next:
#                     ans.next = ListNode()
#                     ans = ans.next
#                 l1 = l1.next
#         if l2:
#             while l2:
#                 sum = l1.val + cnt
#                 cnt = 0
#                 if sum < 10:
#                     ans.val = sum
#                 else:
#                     ans.val = sum % 10
#                     cnt = int(sum / 10)
#                 if l2.next:
#                     ans.next = ListNode()
#                     ans = ans.next
#                 l2 = l2.next
#         return head