package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.ListNode;

import java.util.List;

public class F25 {

    public static void main(String[] args) {

    }

    // 来自灵神
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计节点个数
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;

        // k个一组处理
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }

            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }
    // 时间复杂度（n），空间复杂度（1）。n为链表节点数，每个节点会被使用两次，仅使用了常量的空间所以空间复杂度为1.

// 第一次做真做不出来
//    class Solution {
//        public ListNode reverseKGroup(ListNode head, int k) {
//            ListNode dummy = new ListNode(0);
//            dummy.next = head;
//            ListNode pre = dummy;
//            ListNode cur = head;
//            while (cur != null && cur.next != null) {
//                ListNode curStart = cur;
//                ListNode curEnd = cur.next;
//                int i = 0;
//                for ( ; cur.next != null && i < k; i++) {
//                    cur = cur.next;
//                    if (i == k - 2) {
//                        curEnd = cur;
//                    }
//                }
//
//                if (i != k) {
//                    continue;
//                }
//
//                ListNode nextTeam = cur;
//                cur = pre.next;
//
//                pre.next = curEnd;
//                pre = nextTeam;
//
//                reverse(curStart, k);
//            }
//
//            return dummy.next;
//        }
//
//        void reverse(ListNode head, int k) {
//            ListNode pre = head;
//            ListNode cur = head.next;
//            ListNode next = null;
//
//            for (int i = 0; i < k; i++) {
//                while (cur != null && cur.next != null) {
//                    next = cur.next;
//                    cur.next = pre;
//                    pre = cur;
//                    cur = next;
//                }
//            }
//        }
//    }
}
