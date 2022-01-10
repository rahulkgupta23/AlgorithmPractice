package com.practice.gfg.dp;

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * This is a combination problem, here CoinType is looped first so that we count the Combinations(not ht permutations)
 */
public class CoinChangeCombination {
    static int coinCombination(int[] coinTypes, int totalSum) {
        int[] sumArr = new int[totalSum + 1];
        sumArr[0] = 1;

        for (int i = 0; i < coinTypes.length; i++) {
            for (int j = coinTypes[i]; j <= totalSum; j++) {
                int diffToBeChecked = j - coinTypes[i];
                sumArr[j] = sumArr[j] + sumArr[diffToBeChecked];
            }
        }

        return sumArr[totalSum];
    }

    public static void main(String[] args) {
        System.out.println(coinCombination(new int[]{1, 2, 3}, 4)); //4
        System.out.println(coinCombination(new int[]{2, 3, 5, 6}, 10)); //5
    }
}
