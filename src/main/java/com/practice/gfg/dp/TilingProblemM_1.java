package com.practice.gfg.dp;

/**
 * https://www.geeksforgeeks.org/count-number-ways-tile-floor-size-n-x-m-using-1-x-m-size-tiles/
 */
public class TilingProblemM_1 {

    static int getNoOfWays(int length, int m) {

        int[] ways = new int[length + 1];

        for (int i = 1; i < m; i++) {
            ways[i] = 1;
        }

        ways[m] = 2;

        for (int i = m + 1; i <= length; i++) {
            ways[i] = ways[i - 1] + ways[i - m];
        }

        return ways[length];
    }

    public static void main(String[] args) {
        System.out.println(getNoOfWays(8, 3));
    }
}
