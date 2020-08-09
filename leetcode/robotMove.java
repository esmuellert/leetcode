package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class robotMove {
    private boolean[][] marked;
    private int M, N, K;

    public int movingCount(int m, int n, int k) {
        marked = new boolean[m][n];
        int count = 1;
        M = m;
        N = n;
        K = k;
        Queue<int[]> fringe = new ArrayDeque<>();
        ArrayList<int[]> successors;
        fringe.add(new int[]{0, 0});
        marked[0][0] = true;

        while (!fringe.isEmpty()) {
            successors = adjacent(fringe.remove());
            for (int[] vertex : successors) {
                fringe.add(vertex);
                marked[vertex[0]][vertex[1]] = true;
                count++;
            }
        }
        return count;
    }

    private ArrayList<int[]> adjacent(int vertex[]) {
        ArrayList<int[]> successors = new ArrayList<>();
        int m = vertex[0];
        int n = vertex[1];
        int[] up = {m - 1, n};
        int[] down = {m + 1, n};
        int[] left = {m, n - 1};
        int[] right = {m, n + 1};
        if (isNext(up)) {
            successors.add(up);
        }
        if (isNext(down)) {
            successors.add(down);
        }
        if (isNext(left)) {
            successors.add(left);
        }
        if (isNext(right)) {
            successors.add(right);
        }
        return successors;

    }

    private boolean isNext(int[] vertex) {
        return vertex[0] >= 0 && vertex[0] < M && vertex[1] >= 0 && vertex[1] < N && bitSum(vertex[0]) + bitSum(vertex[1]) <= K && !marked[vertex[0]][vertex[1]];
    }

    private int bitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    @Test
    public void test() {
        robotMove rm = new robotMove();
        assertEquals(rm.movingCount(11, 8, 16), 88);
    }
}
