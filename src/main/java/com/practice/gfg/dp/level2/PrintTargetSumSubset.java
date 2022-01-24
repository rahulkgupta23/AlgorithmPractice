package com.practice.gfg.dp.level2;

import java.util.ArrayDeque;

/**
 * https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
 */
public class PrintTargetSumSubset {
    public static void printTargetSumSubset(int[] arr, int targetSum) {
        boolean[][] targetSumExists = new boolean[arr.length + 1][targetSum + 1];

        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= targetSum; j++) {
                if (i == 0 && j == 0) {
                    targetSumExists[i][j] = true;
                } else if (i == 0) {
                    targetSumExists[i][j] = false;
                } else if (j == 0) {
                    targetSumExists[i][j] = true;
                } else {
                    if (targetSumExists[i - 1][j])
                        targetSumExists[i][j] = true;
                    else if ((j - arr[i - 1] >= 0) && targetSumExists[i - 1][j - arr[i - 1]])
                        targetSumExists[i][j] = true;
                }
            }
        }

        /*for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= targetSum; j++) {
                System.out.print(targetSumExists[i][j] + "\t");
            }
            System.out.println(" ");
        }*/

        ArrayDeque<Pair> pairArrayDeque = new ArrayDeque<>();
        if (targetSumExists[arr.length][targetSum])
            pairArrayDeque.add(new Pair(arr.length, targetSum, ""));

        while (!pairArrayDeque.isEmpty()) {
            Pair remaining = pairArrayDeque.removeFirst();

            if (remaining.i == 0 || remaining.j == 0) {
                System.out.println(remaining.psf);
            } else {
                if ((remaining.j - arr[remaining.i - 1] >= 0) && targetSumExists[remaining.i - 1][remaining.j - arr[remaining.i - 1]])
                    pairArrayDeque.add(new Pair(remaining.i - 1, remaining.j - arr[remaining.i - 1], arr[remaining.i - 1] + " " + remaining.psf));

                if (targetSumExists[remaining.i - 1][remaining.j])
                    pairArrayDeque.add(new Pair(remaining.i - 1, remaining.j, remaining.psf));
            }
        }
    }

    private static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3};
        int n = arr.length;
        int sum = 10;
        printTargetSumSubset(arr, sum);
    }
}
