package leetcode;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PathsInMatrix {
    boolean[][] marked;
    char[] words;
    char[][] map;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        map = board;

        words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words[0]) {
                    marked = new boolean[board.length][board[0].length];
                    if (dfs(new int[]{i, j}, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int[] vertex, int wordMarked) {
        wordMarked++;
        if (wordMarked == words.length) {
            return true;
        }
        int i = vertex[0];
        int j = vertex[1];
        marked[i][j] = true;
        ArrayList<int[]> successor = next(vertex);
        for (int[] v : successor) {
            if (map[v[0]][v[1]] == words[wordMarked]) {
                if (dfs(v, wordMarked)) {
                    return true;
                }
            }
        }
        marked[i][j] = false;
        return false;
    }

    public ArrayList<int[]> next(int[] vertex) {
        ArrayList<int[]> successor = new ArrayList<>();
        int row = vertex[0];
        int col = vertex[1];
        if (row > 0 && !marked[row - 1][col]) {
            successor.add(new int[]{row - 1, col});
        }
        if (row < map.length - 1 && !marked[row + 1][col]) {
            successor.add(new int[]{row + 1, col});
        }
        if (col > 0 && !marked[row][col - 1]) {
            successor.add(new int[]{row, col - 1});
        }
        if (col < map[0].length - 1 && !marked[row][col + 1]) {
            successor.add(new int[]{row, col + 1});
        }
        return successor;
    }

    @Test
    public void test() {
        PathsInMatrix pim = new PathsInMatrix();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        assertEquals(pim.exist(board, word), true);
        assertEquals(pim.exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB"), true);
    }
}
