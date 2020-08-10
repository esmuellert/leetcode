package leetcode;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RobotMoveDfs {
    int count = 0;
    boolean[][] marked;
    int M, N, K;

    public int movingCount(int m, int n, int k) {
        M = m;
        N = n;
        K = k;
        marked = new boolean[m][n];
        dfs(new int[]{0, 0});
        return count;
    }

    private void dfs(int[] vertex) {
        marked[vertex[0]][vertex[1]] = true;
        count++;
        ArrayList<int[]> successors = adjacent(vertex);
        for (int[] v : successors) {
            if (!marked[v[0]][v[1]]) {
                dfs(v);
            }

        }
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
        RobotMoveDfs rm = new RobotMoveDfs();
        assertEquals(rm.movingCount(3, 5, 2), 6);
    }
}
