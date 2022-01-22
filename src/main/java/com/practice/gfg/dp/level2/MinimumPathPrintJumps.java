package com.practice.gfg.dp.level2;

public class MinimumPathPrintJumps {
    static void printPaths(int[] maxJumps) {
        Integer[] minPath = new Integer[maxJumps.length];
        minPath[maxJumps.length - 1] = 0;

        for (int i = maxJumps.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= maxJumps[i]; j++) {
                if (i + j < maxJumps.length && minPath[i + j] != null)
                    min = Integer.min(min, minPath[i + j] + 1);
            }
            if (min != Integer.MAX_VALUE)
                minPath[i] = min;
        }

        System.out.print("Min Paths: ");
        for (int i = 0; i < maxJumps.length; i++) {
            System.out.print(minPath[i] + " " );
        }
        System.out.println(" ");

        int startingIndex = 0;
        System.out.println("Path " + startingIndex);
        while (minPath[startingIndex] != null && startingIndex != maxJumps.length - 1) {
            int shortestPathIndex = -1;
            int shortestPath = Integer.MAX_VALUE;
            for (int i = 1; i <= maxJumps[startingIndex]; i++) {
                if ((startingIndex + i <= maxJumps.length - 1) && minPath[startingIndex + i] != null && shortestPath > minPath[startingIndex + i]) {
                    shortestPath = minPath[startingIndex + i];
                    shortestPathIndex = startingIndex + i;
                }
            }
            startingIndex = shortestPathIndex;
            System.out.println("Path " + startingIndex);
        }
    }

    public static void main(String[] args) {
        printPaths(new int[] {3, 3, 0, 2, 1, 2, 4, 2, 0, 0});
    }
}
