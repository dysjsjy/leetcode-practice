package com.dysjsjy.hot100Java.review;

import java.util.HashMap;
import java.util.Map;

public class S146 {


}


class LRUCache {
    int capacity;
    Node dummy;
    Map<Integer, Node> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy = new Node(0, 0);
        dummy.next = dummy;
        dummy.prev = dummy;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        // 如果没有直接返回-1
        if (node == null) {
            return -1;
        }

        // 如果有则先将其移动到链表首部，再返回
        moveToFront(node);
        return node.val;
    }

    // put也分两种情况
    public void put(int key, int value) {
        Node node = map.get(key);
        // 有，有的话直接替换原来的就好，这时候一定是map没满的，
        if (node != null) {
            moveToFront(node);
            node.val = value;
            return;
        }

        // 没有
        int curSize = map.size();
        if (curSize < capacity) {
            node = new Node(key, value);
            moveToFront(node);
            map.put(key, node);
        } else {
            deleteLast();
            node = new Node(key, value);
            moveToFront(node);
            map.put(key, node);
        }
    }

    // 将老node移动到链表首部
    void moveToFront(Node node) {
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // 这里不要写反了先处理dymmy后就会丢失dummy的next
        node.next = dummy.next;
        node.prev = dummy;
        dummy.next.prev = node;
        dummy.next = node;
    }

    void deleteLast() {
        Node last = dummy.prev;
        dummy.prev = last.prev;
        last.prev.next = dummy;
        map.remove(last.key);
    }

    static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node(Node prev, Node next, int val) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }
}