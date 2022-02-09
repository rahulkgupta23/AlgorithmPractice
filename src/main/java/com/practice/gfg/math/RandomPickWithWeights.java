package com.practice.gfg.math;

/**
 * https://leetcode.com/problems/random-pick-with-weight/
 */
public class RandomPickWithWeights {
    //using a Prefix Sum array
    private final int[] weights;

    public RandomPickWithWeights(int[] w) {
        weights = new int[w.length];
        weights[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            weights[i] = weights[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int random = (int) (Math.random() * weights[weights.length - 1]) + 1;
        /*for (int i = 0; i < weights.length; i++) {
            if (random < weights[i]) {
                return i;
            }
        }*/

        int low = 0;
        int high = weights.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (random == weights[mid])
                return mid;
            else if (random > weights[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
