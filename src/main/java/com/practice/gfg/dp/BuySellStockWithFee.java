package com.practice.gfg.dp;

/**
 * Maintain 2 states: BuyStateProfit, SellStateProfit
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class BuySellStockWithFee {
    static int calculateProfit(int[] stockPrices, int fee) {
        int buyStateProfit = -stockPrices[0];
        int sellStateProfit = 0;

        for (int i = 1; i < stockPrices.length; i++) {
            int nextBuyStateProfit = Math.max(buyStateProfit, - stockPrices[i] + sellStateProfit);
            int nextSellStateProfit = Math.max(sellStateProfit, buyStateProfit + stockPrices[i] - fee);
            buyStateProfit = nextBuyStateProfit;
            sellStateProfit = nextSellStateProfit;
        }

        return sellStateProfit;
    }

    public static void main(String[] args) {
        System.out.println(calculateProfit(new int[] {1, 3, 2, 8, 4, 9}, 2));
    }
}
