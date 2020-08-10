package leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumOfIsland {
    public int numIslands(char[][] grid) {
        int numOfIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numOfIsland++;
                    dfs(grid, i, j);
                    // bfs(grid, i, j);
                }
            }
        }
        return numOfIsland;
    }

    private void bfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            if (x > 0 && grid[x - 1][y] == '1') {
                grid[x - 1][y] = '0';
                queue.offer(new int[]{x - 1, y});
            }
            if (y > 0 && grid[x][y - 1] == '1') {
                grid[x][y - 1] = '0';
                queue.offer(new int[]{x, y - 1});
            }
            if (x < grid.length - 1 && grid[x + 1][y] == '1') {
                grid[x + 1][y] = '0';
                queue.offer(new int[]{x + 1, y});
            }
            if (y < grid[0].length - 1 && grid[x][y + 1] == '1') {
                grid[x][y + 1] = '0';
                queue.offer(new int[]{x, y + 1});
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i > 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
    }

    @Test
    public void test() {
        char[][] gird = {{'1', '1', '1', '1', '1', '1', '1'}, {'0', '0', '0', '0', '0', '0', '1'}, {'1', '1', '1', '1', '1', '0', '1'}, {'1', '0', '0', '0', '1', '0', '1'}, {'1', '0', '1', '0', '1', '0', '1'}, {'1', '0', '1', '1', '1', '0', '1'}, {'1', '1', '1', '1', '1', '1', '1'}};
        NumOfIsland numOfIsland = new NumOfIsland();
        numOfIsland.numIslands(gird);
    }

}
