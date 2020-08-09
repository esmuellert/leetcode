package leetcode;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
public class MoneyExchange {
    private int min;
    public int coinChange(int[] coins, int amount) {
        min = amount + 1;
        Arrays.sort(coins);
        dfs(coins, amount, 0, coins.length - 1);
        return min == amount + 1 ? -1 : min;
    }

    private void dfs(int[] coins, int amount, int depth, int coinType) {
        if (amount == 0) {
            min = Math.min(min, depth);
            return;
        }
        if (coinType < 0) {
            return;
        }
        int maxCoins = amount / coins[coinType];
        if (maxCoins + depth < min) {
            for (int i = maxCoins; i >= 0 && i + depth < min; i--) {
                dfs(coins, amount - i * coins[coinType], depth + i, coinType - 1);
            }
        }

    }

    @Test
    public void test() {
        MoneyExchange me = new MoneyExchange();
        int res = me.coinChange(new int[]{125,146,125,252,226,25,24,308,50}, 8402);
        assertEquals(res, 20);
    }
}
