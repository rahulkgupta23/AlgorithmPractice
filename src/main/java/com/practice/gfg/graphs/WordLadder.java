package com.practice.gfg.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        wordList.add(endWord);
        Queue<String> pq = new LinkedList<>();
        pq.add(beginWord);

        int level = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();

            for (int i = 0; i < size; i++) {
                String currStr = pq.remove();

                if (currStr.equals(endWord)) return level + 1;

                for (int k = 0; k < currStr.length(); k++) {
                    char[] charArray = currStr.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        charArray[k] = j;
                        String word = new String(charArray);
                        if (!word.equals(currStr) && wordList.contains(word)) {
                            pq.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }

            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(){{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength("hit", "cog", list));
    }
}
