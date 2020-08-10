package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CutRope {
    private int[] product;
    // public int cuttingRope(int n) {
    //     product = new int[n];
    //     int max;
    //     product[0] = 1;
    //     for (int i = 1; i < n; i++) {
    //         max = 0;
    //         for (int j = 0; j < i; j++) {
    //             max = Math.max(Math.max(max, product[j] * (i - j)), (i - j) * (j + 1));
    //         }
    //         product[i] = max;
    //     }
    //     return product[n - 1];
    // }

    public int cuttingRope(int n) {
        product = new int[n + 1];
        return cuttingHelper(n);
    }


    private int cuttingHelper(int n) {
        if (n == 1) {
            product[1] = 1;
            return 1;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            int iMax;
            if (product[i] != 0) {
                iMax = product[i];
            } else {
                iMax = cuttingHelper(i);
            }
            max = Math.max(max, Math.max(i * (n - i), iMax * (n - i)));
        }
        product[n] = max;
        return max;
    }

    @Test
    public void test() {
        CutRope cr = new CutRope();
        assertEquals(cr.cuttingRope(6), 9);
    }
}
