package leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int lowerDate = stack.pop();
                res[lowerDate] = i - lowerDate;
            }
            stack.push(i);
        }
        return res;
    }

    @Test
    public void test() {
        DailyTemperatures dt = new DailyTemperatures();
        dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
