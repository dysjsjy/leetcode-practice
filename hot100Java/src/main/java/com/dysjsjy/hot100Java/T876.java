package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.ListNode;

public class T876 {

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
