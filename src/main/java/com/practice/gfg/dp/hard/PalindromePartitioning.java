package com.practice.gfg.dp.hard;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class PalindromePartitioning {

    /**
     * checking if suffix is Palindrome or not and then calculating the cut count
     */
    static int minPalPartitionImproved(String str) {
        boolean[][] dpForIsPalindrome = new boolean[str.length()][str.length()];
        isPalindrome(str, dpForIsPalindrome);

        int[] dpForCuts = new int[str.length()];
        dpForCuts[0] = 0;
        for (int j = 1; j < str.length(); j++) {
            if (dpForIsPalindrome[0][j])
                dpForCuts[j] = 0;
            else {
                int minCuts = Integer.MAX_VALUE;
                for (int i = j; i > 0; i--) {
                    if (dpForIsPalindrome[i][j])
                        minCuts = Integer.min(minCuts, dpForCuts[i - 1]);
                }
                dpForCuts[j] = minCuts + 1;
            }
        }
        return dpForCuts[str.length() - 1];
    }

    static int minPalPartition(String str) {
        boolean[][] dpForIsPalindrome = new boolean[str.length()][str.length()];

        isPalindrome(str, dpForIsPalindrome);

        int[][] dpForCuts = new int[str.length()][str.length()];
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < str.length(); i++, j++) {
                if (g == 0)
                    dpForCuts[i][j] = 0;
                else if (g == 1)
                    dpForCuts[i][j] = (str.charAt(i) == str.charAt(j)) ? 0 : 1;
                else {
                    if (dpForIsPalindrome[i][j]) {
                        dpForCuts[i][j] = 0;
                        continue;
                    }
                    int minCuts = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minCuts = Math.min(minCuts, dpForCuts[i][k] + dpForCuts[k + 1][j] + 1);
                    }
                    dpForCuts[i][j] = minCuts;
                }
            }
        }

        /*for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                System.out.print(dpForCuts[i][j] + "\t");
            }
            System.out.println("");
        }*/

        return dpForCuts[0][str.length() - 1];
    }

    private static void isPalindrome(String str, boolean[][] dpForIsPalin) {
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < str.length(); i++, j++) {
                if (g == 0)
                    dpForIsPalin[i][j] = true;
                else if (g == 1) {
                    dpForIsPalin[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    dpForIsPalin[i][j] = (str.charAt(i) == str.charAt(j)) && dpForIsPalin[i + 1][j - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(minPalPartition("aab"));  //2
        System.out.println(minPalPartitionImproved("aab"));  //2
        System.out.println(minPalPartition("abccbc"));  //2
        System.out.println(minPalPartitionImproved("abccbc"));  //2
        System.out.println(minPalPartition("ababbbabbababa"));   //3
        System.out.println(minPalPartitionImproved("ababbbabbababa"));   //3
        System.out.println(minPalPartition("coder"));   //4
        System.out.println(minPalPartitionImproved("coder"));   //4
    }
}
