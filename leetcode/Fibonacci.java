package leetcode;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Fibonacci {
    private HashMap<Integer, Integer> map;

    public int fib(int n) {
        map = new HashMap<>();
        return fibHelper(n);
    }

    private int fibHelper(int n) {
        if (n == 0 || n == 1) {
            map.put(n, n);
            return n;
        } else {
            int nMinusOne = map.get(n - 1) != null ? map.get(n - 1) : fibHelper(n - 1);
            int nMinusTwo = map.get(n - 2) != null ? map.get(n - 2) : fibHelper(n - 2);
            int result = (nMinusOne + nMinusTwo) % 1000000007;
            map.put(n, result);
            return result;
        }
    }

    @Test
    public void test() {
        Fibonacci fib = new Fibonacci();
        assertEquals(fib.fib(45), 134903163);
    }
}

