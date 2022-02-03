package com.practice.gfg.graphs;

import java.util.ArrayList;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        ArrayList<ArrayList<String>> islands = new ArrayList<>();
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ArrayList<String> tempArray = new ArrayList<>();
                countIslands(grid, isVisited, i, j, tempArray);

                if (!tempArray.isEmpty()) {
                    System.out.println("Here " + tempArray);
                    islands.add(tempArray);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(isVisited[i][j] + "\t");
            }
            System.out.println("");
        }
        return islands.size();
    }

    private static void countIslands(char[][] grid, boolean[][] isVisited, int i, int j, ArrayList<String> island) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || isVisited[i][j])
            return;

        isVisited[i][j] = true;

        if (grid[i][j] == '1')
            island.add(i + " " + j);
        else
            return;

        countIslands(grid, isVisited, i + 1, j, island);
        countIslands(grid, isVisited, i - 1, j, island);
        countIslands(grid, isVisited, i, j - 1, island);
        countIslands(grid, isVisited, i, j + 1, island);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid));

        char[][] grid1 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid1));
    }
}
