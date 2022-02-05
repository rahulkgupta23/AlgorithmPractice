package com.practice.gfg.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream
 */
public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        int minSize = minHeap.size();
        int maxSize = maxHeap.size();

        while (maxSize > minSize + 1) {
            int removeNum = maxHeap.remove();
            minHeap.add(removeNum);
            minSize = minHeap.size();
            maxSize = maxHeap.size();
        }

        while (maxSize + 1 <= minSize) {
            int removeNum = minHeap.remove();
            maxHeap.add(removeNum);
            minSize = minHeap.size();
            maxSize = maxHeap.size();
        }
    }

    public double findMedian() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();

        if (minSize == maxSize)
            return ((double) (maxHeap.peek() + minHeap.peek()) / 2D);
        else
            return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
    }
}
