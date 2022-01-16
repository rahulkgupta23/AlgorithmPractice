package com.practice.gfg.dp;

/**
 * Keep track of Buy and Sell, increment Sell if Prices are increasing, else take Profit and reset Buy and Sell.
 * https://www.geeksforgeeks.org/stock-buy-sell/
 */
public class BuySellStock {
    static int totalProfit(int[] stockPrices) {
        int buyIndex = 0;
        int sellIndex = 0;
        int totalProfit = 0;

        for (int i = 1; i < stockPrices.length; i++) {
            if (stockPrices[i] >= stockPrices[i - 1]) {
                sellIndex++;
            } else {
                totalProfit += (stockPrices[sellIndex] - stockPrices[buyIndex]);
                buyIndex = i;
                sellIndex = i;
            }
        }

        if (sellIndex > buyIndex) totalProfit += (stockPrices[sellIndex] - stockPrices[buyIndex]);

        return totalProfit;
    }

    public static void main(String[] args) {
        System.out.println(totalProfit(new int[] {100, 180, 260, 310, 40, 535, 695}));
    }
}
