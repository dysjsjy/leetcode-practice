package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.ListNode;

public class T206 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = head;
            ListNode cur = head.next;
            head.next = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
        //时间复杂度（n），空间复杂度（1）。
    }
}
