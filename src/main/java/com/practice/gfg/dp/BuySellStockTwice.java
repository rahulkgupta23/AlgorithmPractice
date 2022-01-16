package com.practice.gfg.dp;

/**
 * Solved in 2 steps:
 * 1. Find a day to Sell to get maxProfit [have to be done in forward direction]
 * 2. Find a dat to Buy to get maxProfit [have to go in reverse direction]
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 */
public class BuySellStockTwice {
    static int maxProfit(int[] prices) {
        //First iterating to get Profit by fixing Sell Side
        int maxProfitFixingSell[] = new int[prices.length];
        maxProfitFixingSell[0] = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i])
                minPrice = prices[i];

            maxProfitFixingSell[i] = Math.max(maxProfitFixingSell[i - 1], prices[i] - minPrice);
        }

        //Second iteration to get Profit by fixing Buy Side from other side
        int maxProfitFixingBuy[] = new int[prices.length];
        int maxPrice = prices[prices.length - 1];

        for (int i = prices.length - 2; i >= 0 ; i--) {
            if (maxPrice < prices[i])
                maxPrice = prices[i];

            maxProfitFixingBuy[i] = Math.max(maxProfitFixingBuy[i + 1], maxPrice - prices[i]);
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxProfitFixingBuy[i] + maxProfitFixingSell[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {10, 22, 5, 75, 65, 80}));   //87
        System.out.println(maxProfit(new int[] {2, 30, 15, 10, 8, 25, 80}));    //100

    }
}
