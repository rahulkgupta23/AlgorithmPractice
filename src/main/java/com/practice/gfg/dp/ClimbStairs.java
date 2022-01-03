package com.practice.gfg.dp;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair-using-step-1-2-3/
 */
public class ClimbStairs {
    public static int climbStairs(int n) {
        int[] steps = new int[n + 1];
        steps[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i >= 3)
                steps[i] = steps[i - 1] + steps[i - 2] + steps[i - 3];
            else if (i == 2)
                steps[i] = steps[i - 1] + steps[i - 2];
            else if (i == 1)
                steps[i] = steps[i - 1];
        }

        System.out.println(Arrays.toString(steps));
        return steps[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
