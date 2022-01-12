package com.practice.gfg.dp;

/**
 * This solves same @{@link PaintHouse} problem in N^2 time.
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-many-colors-official/ojquestion
 */
public class PaintHouseNColors {

    static int minCost(int costs[][]) {
        int paintCostFinal[][] = new int[costs.length][costs[0].length];

        int minFirst = Integer.MAX_VALUE;
        int minSecond = Integer.MAX_VALUE;

        for (int i = 0; i < costs[0].length; i++) {
            if (minFirst >= costs[0][i]) {
                minSecond = minFirst;
                minFirst = costs[0][i];
            } else if (minSecond >= costs[0][i]) {
                minSecond = costs[0][i];
            }

            paintCostFinal[0][i] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {

            int prevMinFirst = minFirst;
            int prevMinSecond = minSecond;
            minFirst = Integer.MAX_VALUE;
            minSecond = Integer.MAX_VALUE;

            for (int j = 0; j < costs[i].length; j++) {
                if (costs[i - 1][j] == prevMinFirst) {
                    paintCostFinal[i][j] = costs[i][j] + prevMinSecond;
                } else {
                    paintCostFinal[i][j] = costs[i][j] + prevMinFirst;
                }

                if (minFirst >= paintCostFinal[i][j]) {
                    minSecond = minFirst;
                    minFirst = paintCostFinal[i][j];
                }
            }
        }

        for (int i = 0; i < paintCostFinal.length; i++) {
            for (int j = 0; j < paintCostFinal[0].length; j++) {
                System.out.print(paintCostFinal[i][j] + " \t");
            }
            System.out.println("");
        }

        return minFirst;
    }

    public static void main(String[] args) {
        int costs1[][] = { { 14, 2, 11 }, { 11, 14, 5 }, { 14, 3, 10 } };

        int costs2[][] = {  {1, 2, 3},
                            {1, 4, 6}};

        int costs3[][] = {  {1, 5, 7, 2, 1, 4},
                            {5, 8, 4, 3, 6, 1},
                            {3, 2, 9, 7, 2, 3},
                            {1, 2, 4, 9, 1, 7}};

        System.out.println(minCost(costs1));

        System.out.println(minCost(costs2));

        System.out.println(minCost(costs3));
    }
}
