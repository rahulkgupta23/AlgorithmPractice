package com.practice.gfg.dp;

/**
 * https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
 *
 * Count of 'a' = a + a' + 1;
 * Count of 'ab' = ab + ab' + a;
 * Count of 'abc' = abc + abc' + ab;
 */
public class NumberOfSubsequences {
    public static int findNoOfSubSeq(String str) {
        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                a = a + a + 1; // a = 2 * a + 1;
            } else if (str.charAt(i) == 'b') {
                ab = ab + ab + a; // ab = ab + ab + a;
            } else if (str.charAt(i) == 'c') {
                abc = abc + abc + ab; //abc = abc + abc + ab;
            }
        }
        return abc;
    }

    public static void main(String[] args) {
        System.out.println(findNoOfSubSeq("abcabc"));
    }
}
