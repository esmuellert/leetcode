package leetcode;

import org.junit.Test;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int num : nums) {
            if (set.contains(num)) {
                int counter = 1;
                int prev = num - 1;
                int next = num + 1;
                while (set.contains(prev)) {
                    set.remove(prev);
                    prev--;
                    counter++;
                }
                while (set.contains(next)) {
                    set.remove(next);
                    next++;
                    counter++;
                }
                res = Math.max(res, counter);
            }
        }
        return res;

    }

    @Test
    public void test() {
        String s = "123";
        String str = s.substring(3, 3);
        System.out.println("123".substring(3, 3));
    }
}
