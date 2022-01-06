package com.bukuwarung;

import java.util.*;


/*

input: array of integers with some duplicates
find TOP K frequent elements from the array

example: {7, 4, 6, 5, 4, 5, 4, 5, 3, 2, 2, 4}
k = 3
7 1 times
4 4 times
6 1 times

5 3 times
2 2 times

result [4, 5, 2]

N = 10^6 elements
1 <= k <= N

Time Complexity:
- Build Hash Map O(N)
- Tree Map (RB tree) : log k
overall:
= n + logk or n * log k 

*/

public class Solution {

    static class CustomPair {
        int number;
        int numberOfTimes;

        CustomPair(int i, int j) {
            number = i;
            numberOfTimes = j;
        }
    }

    static List<Integer> topKElements(int[] arr, int b) {
        Map<Integer, CustomPair> occurrences = new HashMap<>(); //(7,1) , (4,4)

        //Map<Integer, List<Integer>> topKElements = new TreeMap<Integer, List<Integer>>();  //(numOfTimes, Integer) (1,7) (3,[5,6])

        PriorityQueue<CustomPair> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.numberOfTimes > o2.numberOfTimes)
                return -1;
            else
                return 1;
        });

        if (arr.length == 0)
            return new ArrayList<>();

        for (int j : arr) {
            CustomPair occurred = occurrences.get(j);
            if (occurred == null) {
                occurrences.put(j, new CustomPair(j, 1));
            } else {
                occurred.numberOfTimes++;
            }
        }

        if (b > occurrences.size())
            return new ArrayList<>();

        occurrences.forEach((integer, customPair) -> queue.add(customPair));

        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < b; i++) {
            if (!queue.isEmpty())
                integerList.add(queue.poll().number);
        }

        return integerList;
    }

    public static void main(String[] args) {
        topKElements(new int[]{7, 4, 6, 5, 4, 5, 4, 5, 3, 2, 2, 4}, 3).forEach(System.out::println);
    }
}