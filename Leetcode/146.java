package Leetcode;

import java.util.HashMap;

class LRUCache {
    class ListNode {
        int key, val;
        ListNode prev, next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    HashMap<Integer, ListNode> map;
    ListNode oldest = new ListNode(0, 0);
    ListNode latest = new ListNode(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        oldest.next = latest;
        latest.prev = oldest;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
            addToFront(node);

            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        } else {
            ListNode node = map.get(key);
            node.val = value;
            remove(node);
            addToFront(node);
        }

        if (map.size() > capacity) {
            map.remove(oldest.next.key);
            remove(oldest.next);
        }
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(ListNode node) {
        latest.prev.next = node;
        node.prev = latest.prev;
        node.next = latest;
        latest.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */