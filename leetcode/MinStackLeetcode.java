package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackLeetcode {
    private Deque<Node> stack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStackLeetcode() {
        stack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        min = Math.min(min, x);
        stack.push(new Node(x, min));
    }

    public void pop() {
        stack.pop();
        assert stack.peek() != null;
        min = stack.peek().getMin();
    }

    public int top() {
        assert stack.peek() != null;
        return stack.peek().getVal();
    }

    public int getMin() {
        return min;
    }

    private static class Node {
        private final int value;
        private final int min;

        public Node(int val, int minimum) {
            value = val;
            min = minimum;
        }

        public int getVal() {
            return value;
        }

        public int getMin() {
            return min;
        }
    }
}

