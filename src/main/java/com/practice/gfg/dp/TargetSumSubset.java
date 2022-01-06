package com.practice.gfg.dp;

/**
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 *
 * Create a 2D array of size [arr.length + 1][targetSum + 1]
 */
public class TargetSumSubset {
    public static boolean targetSumSubset(int[] arr, int targetSum) {
        boolean isAvailable = false;

        boolean[][] targetSumArr = new boolean[arr.length + 1][targetSum + 1];

        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < targetSum + 1; j++) {
                if (i == 0 && j == 0) {
                    targetSumArr[i][j] = true;
                } else if (i == 0) {
                    targetSumArr[i][j] = false;
                } else if (j == 0) {
                    targetSumArr[i][j] = true;
                } else {
                    if (targetSumArr[i - 1][j])
                        targetSumArr[i][j] = true;
                    else {
                        int currentVal = arr[i - 1];
                        if (j >= currentVal)
                            targetSumArr[i][j] = targetSumArr[i - 1][j - currentVal];
                    }
                }
            }
        }

        return targetSumArr[arr.length][targetSum];
    }

    public static void main(String[] args) {
        System.out.println(targetSumSubset(new int[]{3, 34, 4, 12, 5, 2}, 9));
        //System.out.println(targetSumSubset(new int[]{4,2, 3, 1}, 10));
    }
}
