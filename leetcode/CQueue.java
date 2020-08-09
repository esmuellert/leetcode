package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CQueue {
    private Deque<Integer> stack;
    private Deque<Integer> queue;

    public CQueue() {
        stack = new ArrayDeque<>();
        queue = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (queue.size() == 0) {
            while (stack.size() != 0) {
                queue.push(stack.pop());
            }
        }
        if (queue.size() == 0) {
            return -1;
        } else {
            return queue.pop();
        }
    }

//@Test
//    public void test() {
//        leetcode.CQueue cq = new leetcode.CQueue();
//        assertEquals(cq.deleteHead(), -1);
//        cq.appendTail(5);
//        cq.appendTail(2);
//        assertEquals(cq.deleteHead(), 5);
//        assertEquals(cq.deleteHead(), 2);
//}

}
