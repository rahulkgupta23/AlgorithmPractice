package com.practice;

import java.lang.*;

/**
 * Solution for @see <a href="https://www.geeksforgeeks.org/counts-paths-point-reach-origin/"/>
 */
public class CountPaths {
    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main (String[] args) {
        System.out.println(findTotalPaths(new Point(3,2)));
        System.out.println(findTotalPaths(new Point(3,6)));
        System.out.println(findTotalPaths(new Point(3,0)));
    }

    private static int findTotalPaths(Point point) {
        if (point.y == 0 || point.x == 0) { //Only one way to reach (0,0)
            return 1;
        } else {
            Point left = new Point(point.x - 1, point.y);
            Point down = new Point(point.x, point.y - 1);
            return findTotalPaths(left) + findTotalPaths(down);
        }
    }
}