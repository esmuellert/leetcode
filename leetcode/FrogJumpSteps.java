package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrogJumpSteps {
    public int numWays(int n) {
        int[] methods = new int[n + 1];
        methods[0] = 0;
        methods[1] = 1;
        methods[2] = 2;
        int max = 0;
        for (int i = 3; i < n + 1; i++) {
            methods[i] = methods[i - 1] + methods[i - 2];
        }
        return methods[n];

    }

    @Test
    public void test() {
        FrogJumpSteps fjs = new FrogJumpSteps();
        assertEquals(fjs.numWays(2), 2);
        assertEquals(fjs.numWays(7), 21);
    }
}
