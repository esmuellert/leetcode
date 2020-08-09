package leetcode;

import org.junit.Test;

import java.util.HashMap;
public class LRU {
    private HashMap<Integer, LinkedList> hashmap;
    private int CAPACITY;
    private LinkedList firstSentinel;
    private LinkedList lastSentinel;
    private int size;
    public LRU(int capacity) {
        firstSentinel = new LinkedList(-1, -1, null, new LinkedList(- 1, -1, null, null));
        lastSentinel = firstSentinel.next;
        lastSentinel.prev = firstSentinel;
        CAPACITY = capacity;
        size = 0;
        hashmap = new HashMap<>();
    }

    public int get(int key) {
        if (!hashmap.containsKey(key)) {
            return -1;
        }
        LinkedList curr = hashmap.get(key);
        moveToLast(key, curr);
        hashmap.put(key, curr);
        return curr.value;

    }
    private void moveToLast(int key, LinkedList curr) {
        hashmap.remove(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.prev = lastSentinel.prev;
        curr.next = lastSentinel;
        curr.prev.next = curr;
        lastSentinel.prev = curr;
    }
    public void put(int key, int value) {
        LinkedList curr = new LinkedList(-1, -1, null, null);
        if (size == CAPACITY && !hashmap.containsKey(key)) {
            curr = firstSentinel.next;
            moveToLast(curr.key, curr);
            curr.key = key;
            curr.value = value;
        } else if (size == CAPACITY) {
            curr = hashmap.get(key);
            moveToLast(key, curr);
            curr.value = value;
        } else if (hashmap.containsKey(key)) {
            curr = hashmap.get(key);
            hashmap.remove(key);
            curr.value = value;
        } else {
            curr = new LinkedList(key, value, lastSentinel.prev, lastSentinel);
            lastSentinel.prev.next = curr;
            lastSentinel.prev = curr;
            size++;
        }
        hashmap.put(key, curr);
    }

    private class LinkedList {
        int key;
        int value;
        LinkedList next;
        LinkedList prev;
        LinkedList(int K, int V, LinkedList P, LinkedList N) {
            value = V;
            key = K;
            next = N;
            prev = P;
        }
    }

//    public static void main(String[] str) {
//        leetcode.LRU lru = new leetcode.LRU(10);
//        lru.put(10, 13);
//        lru.put(3, 17);
//        lru.put(6, 11);
//        lru.put(10, 5);
//        lru.put(9, 10);
//        lru.get(13);
//        lru.put(2, 19);
//        lru.get(2);
//        lru.get(3);
//        lru.put(5, 25);
//        lru.get(8);
//        lru.put(9, 22);
//        lru.put(5, 5);
//        lru.put(1, 30);
//        lru.get(11);
//        lru.put(9,12);
//        lru.get(7);
//        lru.get(5);
//        lru.get(8);
//        lru.get(9);
//        lru.put(4, 30);
//        lru.put(9, 3);
//        lru.get(9);
//        lru.get(10);
//        lru.get(10);
//    }
}
