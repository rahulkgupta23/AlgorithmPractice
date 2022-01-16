package com.practice.gfg.dp;

/**
 * Create a DP of k-rows & price.length columns and then solve.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 */
public class BuySellStockKTimes {
    static int maxProfitKTimes(int[] prices, int k) {
        if (prices.length == 0) return 0;
        int[][] profit = new int[k + 1][prices.length];
        for (int i = 1; i < profit.length; i++) {
            for (int j = 1; j < profit[0].length; j++) {

                int tempProfit = 0;
                for (int l = 0; l < j; l++) {
                    tempProfit = Math.max(tempProfit, profit[i - 1][l] + (prices[j] - prices[l]));
                }

                profit[i][j] = Math.max(profit[i][j - 1], tempProfit);
            }
        }

        for (int i = 0; i < profit.length; i++) {
            for (int j = 0; j < profit[0].length; j++) {
                System.out.print(profit[i][j] + "\t");
            }
            System.out.println(" ");
        }

        return profit[k][prices.length - 1];
    }

    static int maxProfitKTimes_Improved(int[] prices, int k) {
        if (prices.length == 0) return 0;

        int[][] profit = new int[k + 1][prices.length];
        for (int i = 1; i < profit.length; i++) {
            int maxForPreviousRow = Integer.MIN_VALUE;
            for (int j = 1; j < profit[0].length; j++) {
                maxForPreviousRow = Math.max(maxForPreviousRow, profit[i - 1][j - 1] - prices[j - 1]);
                profit[i][j] = Math.max(profit[i][j - 1], (prices[j] + maxForPreviousRow));
            }
        }

        for (int i = 0; i < profit.length; i++) {
            for (int j = 0; j < profit[0].length; j++) {
                System.out.print(profit[i][j] + "\t");
            }
            System.out.println(" ");
        }
        return profit[k][prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfitKTimes(new int[] {10, 22, 5, 75, 65, 80}, 2));  //87
        System.out.println(maxProfitKTimes(new int[] {9, 6, 7, 6, 3, 8}, 3));   //6

        System.out.println(maxProfitKTimes_Improved(new int[] {10, 22, 5, 75, 65, 80}, 2));  //87
        System.out.println(maxProfitKTimes_Improved(new int[] {9, 6, 7, 6, 3, 8}, 3));   //6
    }
}
