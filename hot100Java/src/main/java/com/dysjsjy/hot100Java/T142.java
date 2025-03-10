package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.ListNode;

public class T142 {

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            // 初始判断，如果链表中没有元素或者只有一个元素且未成环，就直接返回null
            if (fast == null || fast.next == null) {
                return null;
            }

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    break;
                }
            }

            if (fast != slow) {
                return null;
            }

            ListNode ans = head;
            while (ans != slow) {
                ans = ans.next;
                slow = slow.next;
            }
            return ans;
        }
        //时间复杂度（n），空间复杂度（1）。
    }
}
