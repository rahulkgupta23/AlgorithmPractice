package com.practice.gfg.math;

import java.util.*;

/**
 * https://leetcode.com/problems/random-pick-index/
 */
public class RandomPickIndex {

    Map<Integer, List<Integer>> numberToIndexMap;
    Random random = new Random();

    public RandomPickIndex(int[] nums) {
        numberToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexList = numberToIndexMap.getOrDefault(nums[i], new ArrayList<>());
            indexList.add(i);
            numberToIndexMap.put(nums[i], indexList);
        }
    }

    public int pick(int target) {
        if (numberToIndexMap.get(target).size() == 1)
            return numberToIndexMap.get(target).get(0);
        else {
            return pickRandomIndex(numberToIndexMap.get(target));
        }
    }

    private int pickRandomIndex(List<Integer> indexList) {
        return indexList.get(random.nextInt(indexList.size()));
    }
}
