package com.practice.gfg.dp;

public class HighwayBillboard {
    static int maxRevenueWithBoards(int m, int[] boardDistance, int[] boardRevenue, int t) {
        int maxRevenue = Integer.MIN_VALUE;

        int[] revenueTillNow = new int[boardRevenue.length];
        revenueTillNow[0] = boardRevenue[0];

        for (int i = 1; i < boardDistance.length; i++) {
            int maxTillNow = boardRevenue[i];
            for (int j = 0; j < i; j++) {
                if (boardDistance[i] - boardDistance[j] > t)
                    maxTillNow = Math.max(maxTillNow, boardRevenue[i] + revenueTillNow[j]);
            }
            revenueTillNow[i] = maxTillNow;

            if (maxRevenue < revenueTillNow[i])
                maxRevenue = revenueTillNow[i];
        }
        return maxRevenue;
    }

    static int maxRevenueWithDistance(int roadDistance, int[] boardDistance, int[] boardRevenue, int t) {
        int maxRevenue = Integer.MIN_VALUE;
        int[] revenueTillNow = new int[roadDistance + 1];
        int boardCounter = 0;

        for (int i = 1; i < revenueTillNow.length; i++) {
            revenueTillNow[i] = revenueTillNow[i - 1];
            if (boardCounter < boardDistance.length && boardDistance[boardCounter] == i) {
                if (i - t - 1 >= 0)
                    revenueTillNow[i] = Math.max(boardRevenue[boardCounter] + revenueTillNow[i - t - 1], revenueTillNow[i - 1]);
                maxRevenue = Math.max(maxRevenue, revenueTillNow[i]);
                boardCounter++;
            }
        }

        return maxRevenue;

    }

    public static void main(String[] args) {
        System.out.println(maxRevenueWithBoards(20, new int[]{6, 7, 12, 13, 14}, new int[]{5, 6, 5, 3, 1}, 5));
        System.out.println(maxRevenueWithDistance(20, new int[]{6, 7, 12, 13, 14}, new int[]{5, 6, 5, 3, 1}, 5));
    }
}
