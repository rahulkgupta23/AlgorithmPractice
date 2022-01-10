package com.practice.gfg.dp;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */
public class Knapsack {
    static int knapSack(int w, int wt[], int val[]) {
        int[][] value = new int[wt.length + 1][w + 1];

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (i == 0 || j == 0)
                    value[i][j] = 0;
                else {
                    if (j >= wt[i - 1])
                        value[i][j] = Math.max(value[i - 1][j], val[i - 1] + value[i - 1][j - wt[i - 1]]);
                    else
                        value[i][j] = value[i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                System.out.print(value[i][j] + "\t");
            }
            System.out.println(" ");
        }
        return value[wt.length][w];
    }

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int w = 50;
        System.out.println(knapSack(w, wt, val));;
    }
}
