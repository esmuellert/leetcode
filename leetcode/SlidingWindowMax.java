package leetcode;

import org.junit.Test;

import java.util.ArrayDeque;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> monotonicQueue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int start = 1;
        int end = k;
        int resIndex = 1;
        for (int i = 0; i < k; i++) {
            add(monotonicQueue, nums[i]);
        }
        res[0] = monotonicQueue.peek();
        while (end < nums.length) {
            if (nums[start - 1] == monotonicQueue.peek()) {
                monotonicQueue.poll();
            }
            add(monotonicQueue, nums[end]);
            res[resIndex] = monotonicQueue.peek();
            start++;
            resIndex++;
            end++;
        }
        return res;
    }

    private void add(ArrayDeque<Integer> queue, int n) {
        if (queue.isEmpty()) {
            queue.offer(n);
        } else if (queue.peek() < n){
            queue.clear();
            queue.offer(n);
        } else {
            while (queue.getLast() < n) {
                queue.removeLast();
            }
            queue.offer(n);
        }
    }

    @Test
    public void test() {
        SlidingWindowMax swm = new SlidingWindowMax();
        swm.maxSlidingWindow(new int[]{1,3,-1,-3,7,5,2,6}, 6);

    }
}
