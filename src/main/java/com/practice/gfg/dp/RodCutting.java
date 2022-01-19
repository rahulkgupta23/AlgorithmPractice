package com.practice.gfg.dp;

public class RodCutting {
    static int cutRod(int[] price, int n) {
        int[] maxPrice = new int[n + 1];
        maxPrice[0] = 0;
        maxPrice[1] = price[0];

        System.out.println("1 " + maxPrice[1]);
        for (int i = 2; i < maxPrice.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                tempMax = Math.max(tempMax, maxPrice[j] + price[i - j - 1]);
            }
            maxPrice[i] = tempMax;
            System.out.println(i + " " + maxPrice[i]);
        }
        return maxPrice[n];
    }

    public static void main(String[] args) {
        System.out.println(cutRod(new int[] {1, 5, 8, 9, 10, 17, 17, 20}, 8));
    }
}
