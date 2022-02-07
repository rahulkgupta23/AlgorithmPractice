package com.practice.gfg.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombination {
    private Map<Integer, List<String>> letterCombination = new HashMap<>() {{
        put(2, new ArrayList<>() {{
            add("a");
            add("b");
            add("c");
        }});

        put(3, new ArrayList<>() {{
            add("d");
            add("e");
            add("f");
        }});

        put(4, new ArrayList<>() {{
            add("g");
            add("h");
            add("i");
        }});

        put(5, new ArrayList<>() {{
            add("j");
            add("k");
            add("l");
        }});

        put(6, new ArrayList<>() {{
            add("m");
            add("n");
            add("o");
        }});

        put(7, new ArrayList<>() {{
            add("p");
            add("q");
            add("r");
            add("s");
        }});

        put(8, new ArrayList<>() {{
            add("t");
            add("u");
            add("v");
        }});

        put(9, new ArrayList<>() {{
            add("w");
            add("x");
            add("y");
            add("z");
        }});
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();

        if (digits.length() == 1)
            return letterCombination.get(Integer.parseInt(String.valueOf(digits.charAt(0))));

        char[] digitArray = digits.toCharArray();
        List<String> tmpList = letterCombinations(digits.substring(1));
        List<String> characterList = letterCombination.get(Integer.parseInt(String.valueOf(digitArray[0])));
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < characterList.size(); i++) {
            int finalI = i;
            tmpList.iterator().forEachRemaining(s -> newList.add(characterList.get(finalI) + s));
        }
        return newList;
    }

    public static void main(String[] args) {
        LetterCombination letterCombination = new LetterCombination();
        System.out.println(letterCombination.letterCombinations("23"));
        System.out.println(letterCombination.letterCombinations("234"));
    }
}
