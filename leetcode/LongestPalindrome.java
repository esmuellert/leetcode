package leetcode;

import org.junit.Test;

public class LongestPalindrome {
    public String longestSolver(String s) {
        if (s.length() == 0) {
            return s;
        }
        int maxIndex = 0;
        int[] maxPalindrome = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int oneCenterLength = expandTwoDirection(s, i - 1, i + 1, 1);
            int twoCenterLength = 0;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                twoCenterLength = expandTwoDirection(s, i - 1, i + 2, 2);
            }
            maxPalindrome[i] = Math.max(oneCenterLength, twoCenterLength);
            maxIndex = maxPalindrome[i] > maxPalindrome[maxIndex] ? i : maxIndex;
        }
        return maxPalindrome[maxIndex] % 2 == 1 ? s.substring(maxIndex - maxPalindrome[maxIndex] / 2,
                maxIndex + 1 + maxPalindrome[maxIndex] / 2) : s.substring(maxIndex - maxPalindrome[maxIndex] / 2 + 1,
                maxIndex + 1 + maxPalindrome[maxIndex] / 2);
    }

    private int expandTwoDirection(String s, int left, int right, int length) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            length += 2;
        }
        return length;
    }

    @Test
    public void test() {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestSolver("cccccc"));
    }
}
