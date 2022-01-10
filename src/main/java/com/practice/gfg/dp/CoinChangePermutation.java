package com.practice.gfg.dp;

public class CoinChangePermutation {
    static int coinPermutation(int[] coinTypes, int totalSum) {
        int[] numberOfWays = new int[totalSum + 1];
        numberOfWays[0] = 1;


        for (int amount = 1; amount <= totalSum; amount++) {
            for (int coinType : coinTypes) {
                if (amount >= coinType) {
                    int diffToBeChecked = amount - coinType;
                    numberOfWays[amount] = numberOfWays[amount] + numberOfWays[diffToBeChecked];
                }
            }
        }

        for (int i = 0; i < numberOfWays.length; i++) {
            System.out.print(numberOfWays[i] + " ");
        }
        System.out.println("");
        return numberOfWays[totalSum];
    }

    public static void main(String[] args) {
        //System.out.println(coinPermutation(new int[]{1, 2, 3}, 4));
        System.out.println(coinPermutation(new int[]{2, 3, 5}, 7));

        //System.out.println(coinPermutation(new int[]{2, 3, 5, 6}, 10));
    }
}
