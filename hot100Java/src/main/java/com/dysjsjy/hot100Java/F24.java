package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.ListNode;

public class F24 {

    class Solution {

        // 不使用dummy虚拟节点
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode cur = head;
            ListNode pre = cur;
            head = head.next;

            while (cur != null && cur.next != null) {
                ListNode next = cur.next;
                pre.next = next;
                cur.next = next.next;
                next.next = cur;
                pre = cur;
                cur = cur.next;
            }

            return head;
        }

        // 使用dummy虚拟节点
        public ListNode swapPairs2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(0); // 使用 dummy 节点简化操作
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = head;

            while (cur != null && cur.next != null) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = cur;
                pre.next = next;

                pre = cur;
                cur = cur.next;
            }

            return dummy.next;
        }

        /*
            不使用dummy虚拟节点在第一轮的循环中需要注意对cur和pre的处理，要考虑链表的奇偶性，比较麻烦，
            使用虚拟节点第一轮循环中就是正常的进入模式，
            时间复杂度（n），空间复杂度（1）。
         */
    }
}
