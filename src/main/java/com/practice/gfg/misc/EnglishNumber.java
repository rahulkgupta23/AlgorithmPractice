package com.practice.gfg.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 */
class EnglishNumber {
    private static final String hundred = " Hundred";
    private static final String thousand = " Thousand";
    private static final String million = " Million";
    private static final String billion = " Billion";

    private static final Map<Integer, String> numberToEnglish = new HashMap<>() {{
        put(0, "Zero");
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
        put(10, "Ten");
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
        put(20, "Twenty");
        put(30, "Thirty");
        put(40, "Forty");
        put(50, "Fifty");
        put(60, "Sixty");
        put(70, "Seventy");
        put(80, "Eighty");
        put(90, "Ninety");
    }};


    public String numberToWords(int num) {
        String str;

        if (num < 21) {
            str = numberToEnglish.get(num);
        } else if (num < 100) {
            int tens = num / 10;
            str = numberToEnglish.get(tens * 10) + " " + ((num % 10 != 0) ? numberToEnglish.get(num % 10) : "");
        } else if (num < 1000) {
            int hund = num / 100;
            str = numberToEnglish.get(hund) + hundred + " " + ((num % 100 != 0) ? numberToWords(num % 100) : "");
        } else if (num < 1_000_000) {
            int thou = num / 1000;
            str = numberToWords(thou) + thousand + " " + ((num % 1000 != 0) ? numberToWords(num % 1000) : "");
        } else if (num < 1_000_000_000) {
            int mill = num / 1000_000;
            str = numberToWords(mill) + million + " " + ((num % 1000_000 != 0) ? numberToWords(num % 1000_000) : "");
        } else {
            int bill = num / 1000_000_000;
            str = numberToWords(bill) + billion + " " + ((num % 1000_000_000 != 0) ? numberToWords(num % 1000_000_000) : "");
        }

        return str.trim();
    }

    public static void main(String[] args) {
        EnglishNumber englishNumber = new EnglishNumber();
        System.out.println("99 " + englishNumber.numberToWords(99));
        System.out.println("23 " + englishNumber.numberToWords(23));

        System.out.println("123 " + englishNumber.numberToWords(123));
        System.out.println("999 " + englishNumber.numberToWords(999));

        System.out.println("9,999 " + englishNumber.numberToWords(9999));
        System.out.println("10,000 " + englishNumber.numberToWords(10000));
        System.out.println("999,999 " + englishNumber.numberToWords(999_999));

        System.out.println("1,000,000 " + englishNumber.numberToWords(1_000_000));
        System.out.println("9,999,999 " + englishNumber.numberToWords(9_999_999));

        System.out.println("1,234,000,000 " + englishNumber.numberToWords(1_234_000_000));
        System.out.println("2,000,123,000 " + englishNumber.numberToWords(2_000_123_000));
    }
}
