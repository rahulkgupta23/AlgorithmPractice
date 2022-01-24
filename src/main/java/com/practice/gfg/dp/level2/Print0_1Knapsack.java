package com.practice.gfg.dp.level2;

import java.util.ArrayDeque;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */
public class Print0_1Knapsack {
    static void knapsack(int w, int[] wt, int[] val) {
        int[][] knapsackDP = new int[val.length + 1][w + 1];

        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0) {
                    knapsackDP[i][j] = 0;
                } else if (j == 0) {
                    knapsackDP[i][j] = 0;
                } else {
                    if (j >= val[i - 1])
                        knapsackDP[i][j] = Math.max(knapsackDP[i - 1][j], wt[i - 1] + knapsackDP[i - 1][j - val[i - 1]]);
                    else
                        knapsackDP[i][j] = knapsackDP[i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= w; j++) {
                System.out.print(knapsackDP[i][j] + "\t\t");
            }
            System.out.println(" ");
        }

        ArrayDeque<Pair> pairArrayDeque = new ArrayDeque<>();
        pairArrayDeque.add(new Pair(val.length, w, knapsackDP[val.length][w], ""));

        while (pairArrayDeque.size() > 0) {
            Pair rem = pairArrayDeque.removeFirst();

            if (rem.i == 0 || rem.j == 0) {
                System.out.println(rem.psf);
            } else {
                int includedWeight = rem.totalWeight - wt[rem.i - 1];
                int excludedWeight = rem.totalWeight;

                if (knapsackDP[rem.i - 1][rem.j] == excludedWeight) {
                    pairArrayDeque.add(new Pair(rem.i - 1, rem.j, excludedWeight, rem.psf + ""));
                }

                if (rem.j - val[rem.i - 1] >=0 && knapsackDP[rem.i - 1][rem.j - val[rem.i - 1]] == includedWeight) {
                    pairArrayDeque.add(new Pair(rem.i - 1, rem.j - val[rem.i - 1], includedWeight, rem.psf + " " + val[rem.i - 1]));
                }
            }
        }
    }

    private static class Pair {
        int i;
        int j;
        int totalWeight;
        String psf;

        public Pair(int i, int j, int totalWeight, String psf) {
            this.i = i;
            this.j = j;
            this.totalWeight = totalWeight;
            this.psf = psf;
        }
    }


    public static void main(String[] args) {
        int[] val = new int[] {2, 5, 1, 3, 4};
        int[] wt = new int[] {15, 14, 10, 45, 30};
        int w = 7;
        knapsack(w, wt, val);

        wt = new int[] { 60, 100, 120 };
        val = new int[] { 10, 20, 30 };
        w = 50;
        knapsack(w, wt, val);
    }
}
