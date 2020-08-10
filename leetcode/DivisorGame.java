package leetcode;

public class DivisorGame {
    public boolean divisorGame(int N) {
        int[] win = new int[N + 1];
        return divisorGame(N, win);
    }

    public boolean divisorGame(int N, int[] win) {

        if (N == 1) {
            win[N] = 1;
            return false;
        }
        if (N == 2) {
            win[N] = 2;
            return true;
        } else {
            for (int x = 1; x < N; x++) {
                if (N % x == 0) {
                    if (win[N - x] == 1 || !divisorGame(N - x, win)) {
                        win[N] = 2;
                        return true;
                    }
                }
            }
            win[N] = 1;
            return false;
        }
    }

//    public static void main(String[] args) {
//        leetcode.divisorGame hello = new leetcode.divisorGame();
//        boolean a = hello.leetcode.divisorGame(10);
//    }
}
