package com.practice.gfg.dp;

/**
 * Max Profit by Buying and Selling only once
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuySellStockOneTime {
    static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i])
                minPrice = prices[i];

            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
    }
}
