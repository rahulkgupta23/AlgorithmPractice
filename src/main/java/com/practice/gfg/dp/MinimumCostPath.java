package com.practice.gfg.dp;

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 */
public class MinimumCostPath {
    /**
     *  Returns cost of minimum cost path from (0,0) to (m, n) in mat[R][C]
     */
    public static int minCost(int cost[][], int m, int n) {
        int[][] minCost = new int[m][n];

        minCost[m - 1][n - 1] = cost[m - 1][n - 1];

        for (int i = m - 2; i >= 0 ; i--) {
            minCost[i][n -1] = cost[i][n - 1] + minCost[i + 1][n -1];
        }

        for (int j = n - 2; j >= 0 ; j--) {
            minCost[m -1][j] = cost[m - 1][j] + minCost[m - 1][j + 1];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(minCost[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");

        for (int i = m - 2; i >= 0 ; i--) {
            for (int j = n - 2; j >= 0 ; j--) {
                minCost[i][j] = cost[i][j] + Math.min(Math.min(minCost[i][j + 1], minCost[i + 1][j]), minCost[i + 1][j + 1]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(minCost[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        return minCost[0][0];
    }

    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3} };
        System.out.print(minCost(cost, 3, 3) + "\n");
    }
}
