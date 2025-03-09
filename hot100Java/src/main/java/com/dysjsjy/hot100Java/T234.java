package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T234 {

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode middleNode = middleNode(head);
            ListNode headB = reverse(middleNode);

//            while (head != null && headB != null && head.val == headB.val) {
//                head = head.next;
//                headB = headB.next;
//            }
//
//            return head != null && headB != null;
            while (headB != null) {
                if (headB.val != head.val) {
                    return false;
                }
                headB = headB.next;
                head = head.next;
            }
            return true;
        }

        ListNode reverse(ListNode head) {
            ListNode pre = head;
            ListNode cur = pre.next;
            head.next = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public boolean isPalindrome2(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode cur = head;

            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }

            Collections.reverse(list);

            cur = head;
            int i = 0;
            while (cur != null) {
                if (cur.val != list.get(i)) {
                    return false;
                }
                cur = cur.next;
                i++;
            }

            return true;
        }
    }
}
