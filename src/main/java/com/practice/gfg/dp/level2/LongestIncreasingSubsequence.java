package com.practice.gfg.dp.level2;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    static int lengthOfLIS(int[] nums) {
        int[] lisDP = new int[nums.length];
        int maxLIS = 0;
        ArrayDeque<Pair> pairArrayDeque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            int tempMax = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    tempMax = Math.max(tempMax, lisDP[j] + 1);
                }
            }
            lisDP[i] = tempMax;
            if (maxLIS <= lisDP[i]) {
                maxLIS = lisDP[i];
                if (!pairArrayDeque.isEmpty() && pairArrayDeque.getFirst().length < maxLIS)
                    pairArrayDeque.clear();
                pairArrayDeque.add(new Pair(i, maxLIS, nums[i] + ""));
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(lisDP[i] + " ");
        }

        System.out.println();

        //printing elements of LIS
        while (!pairArrayDeque.isEmpty()) {
            Pair rem = pairArrayDeque.removeFirst();

            if (rem.length == 1)
                System.out.println("LIS: " + rem.psf);

            for (int i = rem.index - 1; i >= 0; i--) {
                if (lisDP[i] == rem.length - 1 && nums[i] < nums[rem.index]) {
                    pairArrayDeque.add(new Pair(i, rem.length - 1, nums[i] + " " + rem.psf));
                }
            }
        }

        return maxLIS;
    }

    private static class Pair {
        int index;
        int length;
        String psf;

        public Pair(int index, int length, String psf) {
            this.index = index;
            this.length = length;
            this.psf = psf;
        }
    }

    public static void main(String[] args) {
        System.out.println("LIS Length: " + lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));

        System.out.println(" ");
        System.out.println("LIS Length: " + lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));

        System.out.println(" ");
        System.out.println("LIS Length: " + lengthOfLIS(new int[] {10, 22, 43, 33, 21, 50, 41, 60, 59, 3}));
    }
}
