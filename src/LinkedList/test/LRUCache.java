package Leetcode;

import java.util.HashMap;

class LRUCache {

    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1);
    int capacity;
    Node tail = new Node(-1);
    int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            Node hnext = head.next;
            head.next = node;
            node.next = hnext;
            node.pre = head;
            hnext.pre = node;
            return node.value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            Node hnext = head.next;
            head.next = node;
            node.next = hnext;
            node.pre = head;
            hnext.pre = node;
        }
        else {
            Node node = new Node(value);
            node.key = key;
            Node hnext = head.next;
            head.next = node;
            node.next = hnext;
            node.pre = head;
            hnext.pre = node;
            map.put(key, node);
            size ++;
            if (size > capacity) {
                map.remove(tail.pre.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                size --;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);
    }
}

class Node {
    int value;
    int key;
    Node pre;
    Node next;
    public Node(int value) {
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */