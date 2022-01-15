package com.practice.gfg.dp;

/**
 * Tiling with 2*1 tiles
 * f(n) = f(n-1) + f(n-2)
 * https://www.geeksforgeeks.org/tiling-problem/
 */
public class TilingProblem {

    static int getNoOfWays(int length) {

        int n2 = 1;
        int n1 = 2;

        for (int i = 3; i <= length; i++) {
            int temp = n1;
            n1 = n2 + n1;
            n2 = temp;
        }

        return n1;
    }

    public static void main(String[] args) {
        System.out.println(getNoOfWays(4));
    }
}
