package com.practice.gfg.dp.level2;

/**
 * From Price Number, count = n, for all other scenarios it is equal to sum of its prime factors
 *
 * https://leetcode.com/problems/2-keys-keyboard/
 */
public class Keyboard_2Keys {
    static int minSteps(int n) {
        int minSteps = 0;

        for (int i = 2; i * i <= n;) {
            if (n % i == 0) {
                minSteps += i;
                n = n / i;
            } else {
                i++;
            }
        }

        //n != 1 means that the number is Prime and has to be added back to the minSteps
        if (n != 1)
            minSteps += n;

        return minSteps;
    }

    public static void main(String[] args) {
        System.out.println(minSteps(8));
    }
}
