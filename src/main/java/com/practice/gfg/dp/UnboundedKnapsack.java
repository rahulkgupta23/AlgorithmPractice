package com.practice.gfg.dp;

/**
 * Unbounded Knapsack i.e repetition of elements is allowed
 * https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
 */
public class UnboundedKnapsack {
    static int knapSack(int totalSum, int[] weights, int[] values) {
        int[] value = new int[totalSum + 1];
        value[0] = 0;

        for (int i = 1; i < totalSum + 1; i++) {
            for (int j = 0; j < weights.length; j++) {
                if (i >= weights[j]) {
                    value[i] = Math.max(value[i], value[i - weights[j]] + values[j]);
                }
            }
        }

        for (int i = 0; i < totalSum; i++) {
            System.out.print(value[i] + "\t");
        }
        return value[totalSum];
    }

    public static void main(String[] args) {
        int[] val = new int[] { 15, 14, 10, 45, 30 };
        int[] wt = new int[] { 2, 5, 1, 3, 4 };
        int w = 7;
        System.out.println(knapSack(w, wt, val));
    }
}
