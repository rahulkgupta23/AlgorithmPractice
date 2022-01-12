package com.practice.gfg.dp;

/**
 * Keep calculating prevRed, prevBlue, prevGreen
 * https://www.geeksforgeeks.org/minimize-cost-of-painting-n-houses-such-that-adjacent-houses-have-different-colors/
 */
public class PaintHouse {

    static int minCost(int costs[][]) {
        int prevRed = costs[0][0];
        int prevBlue = costs[0][1];
        int prevGreen = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int currRed = Math.min(prevBlue, prevGreen) + costs[i][0];
            int currBlue = Math.min(prevRed, prevGreen) + costs[i][1];
            int currGreen = Math.min(prevRed, prevBlue) + costs[i][2];

            prevRed = currRed;
            prevBlue = currBlue;
            prevGreen = currGreen;
        }

        return Math.min(prevRed, Math.min(prevBlue, prevGreen));
    }

    public static void main(String[] args) {
        int costs1[][] = { { 14, 2, 11 }, { 11, 14, 5 }, { 14, 3, 10 } };
        int costs2[][] = {{1, 2, 3}, {1, 4, 6}};

        System.out.println(minCost(costs1));

        System.out.println(minCost(costs2));
    }
}
