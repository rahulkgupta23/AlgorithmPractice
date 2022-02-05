package com.practice.gfg.string;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";

        //keep count of all characters in t
        HashMap<Character, Integer> charCounter = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charCounter.put(t.charAt(i), charCounter.getOrDefault(t.charAt(i), 0) + 1);
        }

        int right = 0;
        int left = 0;

        //has count of unique number of characters
        int uniqueChars = charCounter.size();
        int formedWindow = 0;

        //Keeps track of count of all characters in the window
        HashMap<Character, Integer> windowCounter = new HashMap<>();

        int[] result = {-1, 0, 0};

        while (right < s.length()) {
            char sKey = s.charAt(right);
            windowCounter.put(sKey, windowCounter.getOrDefault(sKey, 0) + 1);

            if (charCounter.containsKey(sKey)
                    &&
                    charCounter.get(sKey).intValue() == windowCounter.get(sKey).intValue()) {
                formedWindow++;
            }

            while (left <= right && formedWindow == uniqueChars) {
                sKey = s.charAt(left);

                if (result[0] == -1 || result[0] > (right - left + 1)) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                windowCounter.put(sKey, windowCounter.get(sKey) - 1);

                if (charCounter.containsKey(sKey)
                        &&
                        windowCounter.get(sKey) < charCounter.get(sKey)) {
                    formedWindow--;
                }
                left++;
            }

            right++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring substring = new MinimumWindowSubstring();
        System.out.println("Result " + substring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("Result " + substring.minWindow("A", "A"));
        System.out.println("Result " + substring.minWindow("A", "AA"));
        System.out.println("Result " + substring.minWindow("AA", "AA"));
        System.out.println("Result " + substring.minWindow("A", "B"));
        System.out.println("Result " + substring.minWindow("aaflslflsldkalskaaa", "aaa"));
        System.out.println("Result " + substring.minWindow("abcabdebac", "cda"));
        System.out.println("Result " + substring.minWindow("acbba", "aab"));
    }
}
