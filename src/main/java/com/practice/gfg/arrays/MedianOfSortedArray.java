package com.practice.gfg.arrays;

public class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;

        int totalSize = nums1.length + nums2.length;

        double median1 = 0;
        double median2 = 0;

        while(p1 + p2 <= totalSize / 2) {
            median1= median2;
            if (p1 == nums1.length) {
                median2 = nums2[p2];
                p2++;
            } else if (p2 == nums2.length) {
                median2 = nums1[p1];
                p1++;
            } else if (nums1[p1] < nums2[p2]) {
                median2 = nums1[p1];
                p1++;
            } else {
                median2 = nums2[p2];
                p2++;
            }

        }

        if (totalSize % 2 == 0)
            return (median1 + median2) / 2D;
        else
            return median2;
    }

    public static void main(String[] args) {
        MedianOfSortedArray medianFinder = new MedianOfSortedArray();
        System.out.println(medianFinder.findMedianSortedArrays(new int[] {1, 3}, new int[] {2, 4}));
        System.out.println(medianFinder.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));

    }
}
