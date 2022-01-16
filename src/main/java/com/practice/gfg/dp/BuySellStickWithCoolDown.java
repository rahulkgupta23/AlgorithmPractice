package com.practice.gfg.dp;

/**
 * Maintain 3 states: BuyStateProfit, SellStateProfit, CollDownStateProfit
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BuySellStickWithCoolDown {
    static int calculateProfit(int[] stockPrices) {
        int buyStateProfit = -stockPrices[0];
        int sellStateProfit = 0;
        int coolDownStateProfit = 0;

        System.out.println(buyStateProfit + "\t" + sellStateProfit + "\t" + coolDownStateProfit);

        for (int i = 1; i < stockPrices.length; i++) {
            int nextBuyStateProfit = Math.max(buyStateProfit, coolDownStateProfit - stockPrices[i]);
            int nextSellStateProfit = Math.max(sellStateProfit, buyStateProfit + stockPrices[i]);
            int nextCoolDownStateProfit = Math.max(sellStateProfit, coolDownStateProfit);
            buyStateProfit = nextBuyStateProfit;
            sellStateProfit = nextSellStateProfit;
            coolDownStateProfit = nextCoolDownStateProfit;

            System.out.println(buyStateProfit + "\t" + sellStateProfit + "\t" + coolDownStateProfit);
        }

        return Math.max(sellStateProfit, coolDownStateProfit);
    }

    public static void main(String[] args) {
        System.out.println(calculateProfit(new int[] {1,2,3,0,2}));
    }
}
