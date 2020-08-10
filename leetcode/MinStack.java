package leetcode;

import org.junit.Test;

public class MinStack {

    private class Node {
        int val;
        int min;
        Node next;

        Node(int x, int y, Node node) {
            val = x;
            min = y;
            next = node;
        }
    }

    private Node sentinel;
    private Node last;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        sentinel = new Node(0, 0, null);
    }

    public void push(int x) {
        if (sentinel.next == null) {
            sentinel.next = new Node(x, x, null);
        } else {
            Node first = sentinel.next;
            sentinel.next = new Node(x, Math.min(x, first.min), first);
        }
    }

    public void pop() {
        if (sentinel.next == null) {
            return;
        }
        Node first = sentinel.next;
        sentinel.next = sentinel.next.next;
        first.next = null;
    }

    public int top() {
        return sentinel.next.val;
    }

    public int min() {
        return sentinel.next.min;
    }

    @Test
    public void test() {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        ms.min();
        ms.pop();
        ms.top();
        ms.min();
    }
}
