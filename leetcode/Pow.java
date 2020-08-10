package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Pow {
/*     public double myPow(double x, int n) {
         long N = (long) (n);
         N = - N;
         if (n == 0 || x == 1.0) {
             return 1.0;
         }
         double sum = 1.0;
         if (n > 0) {
             for (int i = 0; i < n; i++) {
                 sum *= x;
             }
             return sum;
         } else {
             for (long i = 0; i < N; i++) {
                 sum /= x;
             }
             return sum;
         }
     }

     public double myPow(double x, int n) {
         long N = (long) (n);
         double result = 1;
         x = N >= 0? x : 1 / x;
         N = Math.abs(N);
         while(N != 0) {
             if ((N & 1) != 0) {
                 result *= x;
             }
             x *= x;
             N >>>= 1;
         }
         return result;
     }

     public double myPow(double x, int n) {
         long N = (long) n;
         double result = 1;
         x = N >= 0 ? x : 1 / x;
         N = Math.abs(N);
         while (N > 0) {
             if (N % 2 == 0) {
                 x *= x;
                 N /= 2;
             } else {
                 result *= x;
                 x *= x;
                 N = (N - 1) / 2;
             }
         }
         return result;
     }*/

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long N = (long) n;
        N = Math.abs(N);
        double result = 1;
        if (N % 2 == 0) {
            result = myPow(x * x, (int) (N / 2));
        } else {
            result = x * myPow(x * x, (int) ((N - 1) / 2));
        }
        return n > 0 ? result : 1 / result;
    }

    @Test
    public void test() {
        Pow p = new Pow();
        assertEquals(p.myPow(2.0, -2147483648), 0, 0.0001);
    }
}
