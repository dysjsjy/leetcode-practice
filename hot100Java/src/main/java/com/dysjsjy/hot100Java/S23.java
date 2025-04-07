package com.dysjsjy.hot100Java;

import com.dysjsjy.hot100Java.Sample.ListNode;

import java.util.*;

public class S23 {

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            for (ListNode l : lists) {
                if (l != null) {
                    pq.offer(l);
                }
            }

            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                if (node.next != null) {
                    pq.offer(node.next);
                }
                cur.next = node;
                cur = cur.next;
            }

            return dummy.next;
        }
    }

}
