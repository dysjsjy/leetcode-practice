package com.dysjsjy.hot100Java;

import java.util.HashMap;
import java.util.Map;

public class S146 {

}
/*
我以为lru是那种根据使用次数排名的，但实际上是只要使用一次节点就把该节点放到头部，
关键词：Node, map, dummy, capacity,
 */
class LRUCache {
    static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node dummy;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy = new Node();
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 将节点移到最前面
        remove(node);
        pushFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        // 分为在map中和不在map中两种情况
        Node node = map.get(key);
        if (node != null) {
            // 如果键已存在，更新值并移到最前面
            remove(node);
            node.val = value;
            pushFront(node);
            return;
        }

        // 分为lru满了和没满两种情况
        if (map.size() >= capacity) {
            Node last = dummy.prev;
            remove(last);
            map.remove(last.key);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        pushFront(newNode);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void pushFront(Node node) {
        node.prev = dummy;
        node.next = dummy.next;
        dummy.next.prev = node;
        dummy.next = node;
    }
}