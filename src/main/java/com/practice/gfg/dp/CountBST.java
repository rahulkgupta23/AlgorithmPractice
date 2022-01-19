package com.practice.gfg.dp;

/**
 * https://www.geeksforgeeks.org/total-number-of-possible-binary-search-trees-with-n-keys/
 * Catalan Number
 */
public class CountBST {
    static int countBST( int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int l = 0;
            int r = i - 1;

            while (l <= i - 1) {
                dp[i] += dp[l] * dp[r];

                l++;
                r--;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countBST(4));
    }
}
