package leetcode;

public class No309 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        int rest = 0;
        for (int i = 1; i < prices.length; i++) {
            int preBuy = buy;
            int preSell = sell;
            int preRest = rest;
            buy = Math.max(preBuy, preRest - prices[i]);
            sell = prices[i] + preBuy;
            rest = Math.max(preSell, preRest);
        }
        return Math.max(sell, rest);
    }


}
