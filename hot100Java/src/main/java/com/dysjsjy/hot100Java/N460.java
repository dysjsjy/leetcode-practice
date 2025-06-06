package com.dysjsjy.hot100Java;

import java.util.*;
import java.util.function.Function;

public class N460 {

    public static void main(String[] args) {

    }
}

class LFUCache {

    static class Node {
        int key, value, freq = 1;
        Node prev, next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> keyToNode = new HashMap<>();
    private final Map<Integer, Node> freqToDummy = new HashMap<>();
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = keyToNode.get(key);
        // 已经有这本书了
        if (node != null) {
            node.value = value;
            node.freq += 1;
            pushFront(node.freq, node);
        }

        // 书太多了
        if (keyToNode.size() == capacity) {
            Node dummy = freqToDummy.get(minFreq);
            Node backNode = dummy.prev;
            remove(backNode);
            if (dummy.prev == dummy) {
                freqToDummy.remove(minFreq);
            }
        }

        node = new Node(key, value);
        keyToNode.put(key, node);
        pushFront(1, node);
        minFreq = 1;
    }

    protected Node getNode(int key) {
        if (!keyToNode.containsKey(key)) {
            return null;
        }

        Node node = keyToNode.get(key);
        remove(node);
        Node dummy = freqToDummy.get(node.freq);
        if (dummy.prev == dummy) { // 抽出来后，这摞书是空的
            freqToDummy.remove(node.freq); // 移除空链表
            if (minFreq == node.freq) { // 这摞书是最左边的
                minFreq++;
            }
        }
        pushFront(++node.freq, node); // 放在右边这摞书的最上面
        return node;
    }

    // 创建一个新的双向链表
    private Node newList() {
        Node dummy = new Node(0, 0); // 哨兵节点
        dummy.prev = dummy;
        dummy.next = dummy;
        return dummy;
    }

    // 在链表头添加一个节点（把一本书放在最上面）
    private void pushFront(int freq, Node x) {
        Node dummy = freqToDummy.computeIfAbsent(freq, k -> newList());
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class LFUCache2 {
    private static class Node {
        int key, value, freq = 1; // 新书只读了一次
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> keyToNode = new HashMap<>();
    private final Map<Integer, Node> freqToDummy = new HashMap<>();
    private int minFreq;

    public LFUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) { // 有这本书
            node.value = value; // 更新 value
            return;
        }
        if (keyToNode.size() == capacity) { // 书太多了
            Node dummy = freqToDummy.get(minFreq);
            Node backNode = dummy.prev; // 最左边那摞书的最下面的书
            keyToNode.remove(backNode.key);
            remove(backNode); // 移除
            if (dummy.prev == dummy) { // 这摞书是空的
                freqToDummy.remove(minFreq); // 移除空链表
            }
        }
        node = new Node(key, value); // 新书
        keyToNode.put(key, node);
        pushFront(1, node); // 放在「看过 1 次」的最上面
        minFreq = 1;
    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) { // 没有这本书
            return null;
        }
        Node node = keyToNode.get(key); // 有这本书
        remove(node); // 把这本书抽出来
        Node dummy = freqToDummy.get(node.freq);
        if (dummy.prev == dummy) { // 抽出来后，这摞书是空的
            freqToDummy.remove(node.freq); // 移除空链表
            if (minFreq == node.freq) { // 这摞书是最左边的
                minFreq++;
            }
        }
        pushFront(++node.freq, node); // 放在右边这摞书的最上面
        return node;
    }

    // 创建一个新的双向链表
    private Node newList() {
        Node dummy = new Node(0, 0); // 哨兵节点
        dummy.prev = dummy;
        dummy.next = dummy;
        return dummy;
    }

    // 在链表头添加一个节点（把一本书放在最上面）
    private void pushFront(int freq, Node x) {
        Node dummy = freqToDummy.computeIfAbsent(freq, k -> newList());
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

    // 删除一个节点（抽出一本书）
    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }
}

/*
class LFUCache {
    PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>() {
        @Override
        public Comparator comparator() {
            return new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return ((Node) o2).cnt - ((Node) o1).cnt;
                }
            };
        }
    };

    Map<Integer, Node> map = new HashMap<>();

    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        node.cnt += 1;

        return node.value;
    }

    public void put(int key, int value) {
        int size = map.size();
        Node node = map.get(key);

        if (size >= capacity) {
            if (node == null) {
                Node remove = priorityQueue.remove();
                map.remove(remove.key, remove);
                node = new Node(key, value, 1);
                map.put(key, node);
                priorityQueue.offer(node);
            } else {
                node.cnt += 1;
            }
        }

        if (node == null) {
            node = new Node(key, value, 1);
            priorityQueue.offer(node);
            map.put(key, node);
        } else {
            node.cnt += 1;
            node.value = value;
        }
    }

    static class Node {
        int key;
        int value;
        int cnt;

        public Node() {
        }

        public Node(int key, int value, int cnt) {
            this.key = key;
            this.value = value;
            this.cnt = cnt;
        }
    }
}
 */

