package com.practice.gfg.dp;

/**
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 */
public class TargetSumSubset {
    public static boolean targetSumSubset(int[] arr, int targetSum) {
        boolean isAvailable = false;

        boolean[][] targetSumArr = new boolean[targetSum + 1][arr.length + 1];

        for (int i = 0; i < targetSum + 1; i++) {
            for (int j = 0; j < arr.length + 1; j++) {
                if (i ==0 && j == 0) {
                    targetSumArr[i][j] = true;
                } else if (i == 0) {
                    targetSumArr[i][j] = true;
                } else if (j == 0) {
                    targetSumArr[i][j] = false;
                } else {

                }
            }
        }

        return isAvailable;
    }

    public static void main(String[] args) {
        targetSumSubset(new int[]{3, 34, 4, 12, 5, 2}, 9);
    }
}
