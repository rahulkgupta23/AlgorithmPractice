package com.practice.gfg.math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/ugly-number-ii
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        List<Integer> nums = new ArrayList<>();

        int lastIndexA = 0; //index for 2
        int lastIndexB = 0; //index for 3
        int lastIndexC = 0; //index for 5

        nums.add(1);

        while (nums.size() < n) {
            int nextNum = Math.min(nums.get(lastIndexA) * 2, Math.min(nums.get(lastIndexB) * 3, nums.get(lastIndexC) * 5));

            if(nextNum == nums.get(lastIndexA) * 2) lastIndexA++;
            if(nextNum == nums.get(lastIndexB) * 3) lastIndexB++;
            if(nextNum == nums.get(lastIndexC) * 5) lastIndexC++;

            nums.add(nextNum);
        }

        System.out.println(nums);

        return nums.get(n - 1);
    }

    public static void main(String[] args) {
        UglyNumberII uglyNumerII = new UglyNumberII();
        System.out.println(uglyNumerII.nthUglyNumber(10));
        System.out.println(uglyNumerII.nthUglyNumber(1));
        System.out.println(uglyNumerII.nthUglyNumber(485));
    }
}
