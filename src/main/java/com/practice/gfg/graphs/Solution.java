package com.practice.gfg.graphs;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Union and Find - Disjoint Set
 * https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 */
public class Solution {

    public int earliestAcq(int[][] logs, int n) {
        int time = 0;

        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));

        int[] parentArr = new int[n];

        /**
         * Initialize the Disjoint set represent in an Array
         * 1. Initially everything is -1 meaning all are disjoint sets
         * 2. on Union, we merge the Set and update the corresponding Array values
         */
        Arrays.fill(parentArr, -1);

        for (int[] log : logs) {
            int tempTime = log[0];
            int a = log[1];
            int b = log[2];

            int parentA = parentArr[a] < 0 ? a : parentArr[a];
            while (parentArr[parentA] >= 0)
                parentA = parentArr[parentA];

            int parentB = parentArr[b] < 0 ? b : parentArr[b];
            while (parentArr[parentB] >= 0)
                parentB = parentArr[parentB];

            //this means that we need to do union of two sets
            if (parentA != parentB || (parentA == -1 && parentB == -1)) {
                if (parentA < parentB) {
                    parentArr[parentA] = parentArr[parentA] + parentArr[parentB];
                    parentArr[parentB] = a;
                } else {
                    parentArr[parentB] = parentArr[parentB] + parentArr[parentA];
                    parentArr[parentA] = b;
                }
                System.out.println(tempTime + " " + a + "-> " + b + " " + Arrays.toString(parentArr));
                time = tempTime;
            }
        }

        //if count is greater than 1, that means disconnect graph
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parentArr[i] < 0)
                count++;
        }

        return count > 1 ? -1: time;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.earliestAcq(new int[][] {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}}, 6));
        System.out.println(solution.earliestAcq(new int[][] {{9,0,3},{0,2,7},{12,3,1},{5,5,2},{3,4,5},{1,5,0},{6,2,4},{2,5,3},{7,7,3}}, 8));
    }
}
