package com.practice.gfg.math;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class FindSingleElement {
    public int singleNonDuplicate(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        FindSingleElement findSingleElement = new FindSingleElement();
        System.out.println(findSingleElement.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
    }
}
