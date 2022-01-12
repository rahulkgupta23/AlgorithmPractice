package com.practice.gfg.dp;

/**
 * Create Include and Exclude Array via DP
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 */
public class NonAdjacentSum {
    static int nonAdjacentSum(int[] inputArr) {
        int[] includeSum = new int[inputArr.length];
        int[] excludeSum = new int[inputArr.length];

        includeSum[0] = inputArr[0];

        for (int i = 1; i < inputArr.length; i++) {
            includeSum[i] = excludeSum[i - 1] + inputArr[i];
            excludeSum[i] = Math.max(includeSum[i - 1], excludeSum[i - 1]);
        }

        return Math.max(includeSum[inputArr.length - 1], excludeSum[inputArr.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(nonAdjacentSum(new int[]{5, 5, 10, 100, 10, 5}));
    }
}
