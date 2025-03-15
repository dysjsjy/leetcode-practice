package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.ListNode;

import java.util.List;

public class T19 {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // dummy针对的是处理链表中只有一个节点的情况，保证就算移除的是head也可以正常返回。
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;

            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            while (fast != null && fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
        // 时间复杂度（n），空间复杂度（1）。
    }
}
