package com.practice.gfg.dp.hard;

/**
 * A[20, 40] * B[40, 30] = C[20, 30] and total Multiplication would be 20 * 40 * 30
 * https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
 */
public class MatrixChainMultiplication {
    static int matrixChainOrder(int[] inputArr) {
        int[][] minCost = new int [inputArr.length - 1][inputArr.length - 1];

        for (int g = 0; g < inputArr.length - 1; g++) {
            for (int i = 0, j = g; j < inputArr.length - 1; i++, j++) {
                if (g == 0)
                    minCost[i][j] = 0;
                else if (g == 1)
                    minCost[i][j] = inputArr[i] * inputArr[j] * inputArr[j + 1];
                else {
                    int minC = Integer.MAX_VALUE;
                    //running this loop from i to j, so subset would [i, k] & [k + 1, j]
                    for (int k = i; k < j; k++) {
                        int tempCost = minCost[i][k] + minCost[k + 1][j] + (inputArr[i] * inputArr[k + 1] * inputArr[j + 1]);
                        minC = Math.min(minC, tempCost);
                    }

                    minCost[i][j] = minC;
                }
            }
        }

        return minCost[0][inputArr.length - 2];
    }

    public static void main(String[] args) {
        System.out.println(matrixChainOrder(new int[] {40, 20, 30, 10, 30}));
    }
}
