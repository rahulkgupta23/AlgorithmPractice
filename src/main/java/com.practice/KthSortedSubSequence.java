package com.practice;

import java.util.Arrays;

public class KthSortedSubSequence {

    public static void main(String[] args) {
        int[] arr = {-4, 2, 8, 3, 1, 10};
        findPassArray(arr, 4);
    }
    private static int[][] findPassArray(int[] arr, int size) {
        int sequenceSize = size-1;
        System.out.println("Original Array: " + Arrays.toString(arr));
        int[][] passArray = new int[sequenceSize][arr.length];
        int min = 0;

        passArray[0][0] = -1;
        for (int j = 1; j < arr.length; j++) {
            if (arr[min] <= arr[j]) {
                passArray[0][j] = min;
            } else {
                passArray[0][j] = -1;
                min = j;
            }

        }

        for (int i = 1; i < sequenceSize; i++) {
            passArray[i][0] = -1;
            min = -1;
            for (int j = 1; j < arr.length; j++) {
                if (min != -1 && arr[min] <= arr[j]) {
                    passArray[i][j] = min;
                } else {
                    passArray[i][j] = -1;
                }

                if (passArray[i-1][j] != -1 && (min == -1 || arr[min] >= arr[j]))
                    min = j;

            }
        }

        for (int[] aPassArray : passArray) {
            System.out.println(Arrays.toString(aPassArray));
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (passArray[sequenceSize-1][i] != -1) {
                System.out.print("Sequence is: ");
                System.out.print(printValue(passArray, arr, passArray[sequenceSize-1][i], sequenceSize - 1));
                System.out.println(" " + arr[i]);
            }
        }
        return passArray;
    }

    private static String printValue(int[][] passArray, int[] arr, int index, int level) {
        StringBuilder sb = new StringBuilder();
        if (level > 0) {
            sb.append(printValue(passArray, arr, passArray[level-1][index], level-1));
        }
        sb.append(" ").append(arr[index]);
        return sb.toString();
    }
}
