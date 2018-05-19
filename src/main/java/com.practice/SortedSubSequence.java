package com.practice;

import java.util.Arrays;

/**
 * Solution for @see <a href="https://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/"/>
 */
public class SortedSubSequence {

    public static void main(String[] args) {
        int arr[] = {12, 4, 10, 5, 6, 31, 30};
        printSequence(arr);
    }

    private static void printSequence(int arr[]) {
        System.out.println(Arrays.toString(arr));
        int[] smaller = getSmaller(arr);
        System.out.println(Arrays.toString(smaller));

        int[] greater = getBigger(arr);
        System.out.println(Arrays.toString(greater));

        for (int i = 0; i < arr.length; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                System.out.println(arr[smaller[i]]+" "+ arr[i]+" "+ arr[greater[i]]);
            }
        }
    }

    private static int[] getSmaller(int[] arr) {
        int[] smaller = new int[arr.length];
        int min = 0;
        smaller[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            System.out.println("Printing " + Arrays.toString(smaller));
            if (arr[i] <= arr[min]) {
                smaller[i] = -1;
                min = i;
            } else {
                smaller[i] = min;
            }
        }
        return smaller;
    }

    private static int[] getBigger(int[] arr) {
        int[] bigger = new int[arr.length];
        bigger[arr.length - 1] = -1;
        int max = arr.length - 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[max] <= arr[i]) {
                bigger[i] = -1;
                max = i;
            } else {
                bigger[i] = max;
            }
        }
        return bigger;
    }
}