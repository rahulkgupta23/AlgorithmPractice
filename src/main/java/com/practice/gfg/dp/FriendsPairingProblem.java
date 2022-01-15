package com.practice.gfg.dp;

/**
 * https://www.geeksforgeeks.org/friends-pairing-problem/
 */
public class FriendsPairingProblem {

    static int findNoOfWays(int n) {
        int[] ways = new int[n + 1];

        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + (i - 1) * ways[i - 2];
        }

        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(findNoOfWays(5));
    }
}
