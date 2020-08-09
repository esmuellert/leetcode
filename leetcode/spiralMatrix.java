package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class spiralMatrix {
    public int[] spiralOrder(int[][] matrix) {
        int iFirst = 0;
        int iLast = matrix.length - 1;
        int jFirst = 0;
        int jLast = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        while(iLast >= iFirst && jLast >= jFirst && index < res.length) {
            for (int i = jFirst; i <= jLast; i++) {
                res[index] = matrix[iFirst][i];
                index++;
            }
            iFirst++;
            if (index > res.length - 1) {
                break;
            }
            for (int i = iFirst; i <= iLast; i++) {
                res[index] = matrix[i][jLast];
                index++;
            }
            jLast--;
            if (index > res.length - 1) {
                break;
            }
            for (int i = jLast; i >= jFirst; i--) {
                res[index] = matrix[iLast][i];
                index++;
            }
            iLast--;
            if (index > res.length - 1) {
                break;
            }
            for (int i = iLast; i >= iFirst; i--) {
                res[index] = matrix[i][jFirst];
                index++;
            }
            jFirst++;

        }
        return res;
    }
    @Test
    public void test() {
        spiralMatrix sm = new spiralMatrix();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] res = {1,2,3,4,8,12,11,10,9,5,6,7};
        assertTrue(Arrays.equals(sm.spiralOrder(matrix), res));
    }
}
