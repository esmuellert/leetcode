package leetcode;

import java.util.PriorityQueue;

public class MedianFromStream {
    private PriorityQueue<Integer> A;
    private PriorityQueue<Integer> B;

    /**
     * initialize your data structure here.
     */
    public MedianFromStream() {
        A = new PriorityQueue<>((x, y) -> (y - x));
        B = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (A.size() == B.size()) {
            B.offer(num);
            A.offer(B.poll());
        } else {
            A.offer(num);
            B.offer(A.poll());
        }
    }

    public double findMedian() {
        if (A.size() == B.size()) {
            return (A.peek() + B.peek()) / 2.0;
        } else {
            return A.peek();
        }
    }
}
