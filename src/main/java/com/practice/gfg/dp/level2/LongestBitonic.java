package com.practice.gfg.dp.level2;

/**
 * Create a LIS and LDS to solve this problem
 * https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
 */
public class LongestBitonic {

    static int lbs(int[] arr) {
        int[] lisDB = new int[arr.length];
        int[] ldsDB = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    tempMax = Math.max(tempMax, lisDB[j]);
                }
            }
            lisDB[i] = tempMax + 1;
        }

        System.out.print("LIS: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(lisDB[i] + " ");
        }
        System.out.println(" ");

        for (int i = arr.length - 1; i >= 0; i--) {
            int tempMax = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tempMax = Math.max(tempMax, ldsDB[j]);
                }
            }
            ldsDB[i] = tempMax + 1;
        }

        System.out.print("LDS: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(ldsDB[i] + " ");
        }
        System.out.println(" ");

        int maxBitonic = 0;
        System.out.print("Bitonic: ");
        for (int i = 0; i < arr.length; i++) {
            maxBitonic = Math.max(maxBitonic, ldsDB[i] + lisDB[i] - 1);
            System.out.print((ldsDB[i] + lisDB[i] - 1) + " ");
        }
        System.out.println(" ");

        return maxBitonic;
    }

    public static void main(String[] args) {
        System.out.println(lbs(new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80, 3}));
        System.out.println(lbs(new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
}
