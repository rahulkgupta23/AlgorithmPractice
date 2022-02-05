package com.practice.gfg.greedy;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    // brute force way
    /*public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return maxArea;

    }*/

    //improve version
    public int maxArea(int[] height) {
        int maxArea = 0;
        int leftP = 0;
        int rightP = height.length - 1;

        while (leftP < rightP) {
            boolean moveLeft = height[leftP] < height[rightP];
            maxArea = Math.max(maxArea, Math.min(height[leftP], height[rightP]) * (rightP - leftP));
            if (moveLeft)
                leftP++;
            else
                rightP--;
        }

        return maxArea;
    }
}
