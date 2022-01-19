package com.practice.gfg.dp.hard;

/**
 * https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
 */
public class OptimalBST {

    static int optimalBST(int[] freq) {
        int nodes = freq.length;
        int[][] optimalCost = new int[nodes][nodes];

        for (int g = 0; g < nodes; g++) {
            for (int i = 0, j = g; j < nodes; i++, j++) {
                if (g == 0)
                    optimalCost[i][j] = freq[i];
                else if (g == 1)
                    optimalCost[i][j] = Math.min(freq[i] * 2 + freq[j], freq[i] + freq[j] * 2);
                else {
                    int minCost = Integer.MAX_VALUE;

                    int fixedCost = 0;
                    for (int k = i; k <= j; k++) {
                        fixedCost += freq[k];
                    }

                    for (int k = i; k <= j; k++) {
                        int leftSum = k == i ? 0 : optimalCost[i][k - 1];
                        int rightSum = k == j ? 0 : optimalCost[k + 1][j];
                        minCost = Math.min(minCost, leftSum + rightSum + fixedCost);
                    }

                    optimalCost[i][j] = minCost;
                }
            }
        }

        return optimalCost[0][nodes - 1];
    }

    public static void main(String[] args) {
        System.out.println(optimalBST(new int[] {34, 50}));  //118
        System.out.println(optimalBST(new int[] {34, 8, 50}));  //142
    }

}
