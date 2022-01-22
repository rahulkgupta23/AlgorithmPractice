package com.practice.gfg.dp;

/**
 * https://leetcode.com/problems/maximal-square/
 */
public class LargestSquareSubMatrix {
    public static int maximalSquare(char[][] matrix) {
        int[][] maxSize = new int[matrix.length][matrix[0].length];
        int max = 0;

        for (int i = matrix.length - 1; i >= 0 ; i--) {
            for (int j = matrix[0].length - 1; j >= 0 ; j--) {
                if (matrix[i][j] == '1') {
                    if (i == matrix.length - 1 || j == matrix[0].length - 1) {
                        maxSize[i][j] = 1;
                    } else {
                        maxSize[i][j] = Math.min(maxSize[i + 1][j + 1], Math.min(maxSize[i + 1][j], maxSize[i][j + 1])) + 1;
                    }
                    max = Math.max(max, maxSize[i][j]);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(maxSize[i][j] + "\t");
            }
            System.out.println(" ");
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]
                {
                        {'1','0','1','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','0'}
                }));

        System.out.println(maximalSquare(new char[][]{
                {'0','1'},
                {'1','0'}
        }));

        System.out.println(maximalSquare(new char[][]{
                {'0','1'}
        }));
    }
}
