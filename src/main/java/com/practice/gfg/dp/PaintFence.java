package com.practice.gfg.dp;

/**
 * https://www.geeksforgeeks.org/painting-fence-algorithm/
 *
 * paintWays[0] - contains last 2 same colors
 * paintWays[1] - contains last 2 different colors
 */
public class PaintFence {

    static long paintFence(int fences, int colors) {
        int[][] paintWays = new int[2][fences];

        paintWays[0][0] = colors;
        paintWays[1][0] = colors;

        paintWays[0][1] = colors * 1;
        paintWays[1][1] = colors * (colors - 1);

        for (int i = 2; i < fences; i++) {
            paintWays[0][i] = paintWays[1][i - 1];
            paintWays[1][i] = paintWays[0][i - 1] * (colors - 1) + paintWays[1][i - 1] * (colors - 1);
        }

        for (int i = 0; i < paintWays.length; i++) {
            for (int j = 0; j < paintWays[0].length; j++) {
                System.out.print(paintWays[i][j] + "\t");
            }
            System.out.println(" ");
        }

        return paintWays[0][fences - 1] + paintWays[1][fences - 1];
    }

    public static void main(String[] args) {
        System.out.println(paintFence(5, 3));
    }

}
