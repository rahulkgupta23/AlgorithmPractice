package com.practice.gfg.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderII {

    private class Node {
        String value;
        Node previous;

        public Node(String value) {
            this.value = value;
        }

        public Node(String value, Node previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return new ArrayList<>();

        List<List<String>> lol = new ArrayList<>();

        //removing so that we don't misintrepret this
        wordList.remove(beginWord);

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(beginWord));

        int minLevel = 0;
        int level = 0;
        while (!q.isEmpty()) {
            int currSize = q.size();

            for (int i = 0; i < currSize; i++) {
                Node tmpStr = q.poll();

                if (tmpStr.value.equals(endWord) && (minLevel == 0 || minLevel == level)) {
                    Node tmp = tmpStr;
                    List<String> tmpList = new ArrayList<>();
                    while (tmp.previous != null) {
                        tmpList.add(0, tmp.value);
                        tmp = tmp.previous;
                    }
                    tmpList.add(0, tmp.value);
                    lol.add(tmpList);
                    minLevel = level;
                }

                char[] charArr = tmpStr.value.toCharArray();
                for (int j = 0;  j < tmpStr.value.length(); j++) {
                    char tmpChar = tmpStr.value.charAt(j);
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (tmpChar == k) continue;
                        charArr[j] = k;
                        if (wordList.contains(String.valueOf(charArr))) {
                            System.out.println("Level" + level + " " + tmpStr.value + " -> " + String.valueOf(charArr));
                            q.add(new Node(String.valueOf(charArr), tmpStr));
                        }
                    }
                    charArr[j] = tmpChar;
                    wordList.remove(tmpStr.value);
                }
            }

            level++;
        }

        return lol;
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
        WordLadderII wordLadder = new WordLadderII();
        System.out.println(wordLadder.findLadders("hit", "cog", list));

        list = new ArrayList<>(){{
            add("a");
            add("b");
            add("c");
        }};
        //System.out.println(wordLadder.findLadders("a", "c", list));

        list = new ArrayList<>(){{
            add("hot");
            add("dot");
            add("dog");
            add("cog");
            add("tot");
            add("hog");
            add("hop");
            add("pot");
        }};
        //System.out.println(wordLadder.findLadders("hot", "dog", list));

        list = new ArrayList<>(){{
            add("ted");
            add("tex");
            add("red");
            add("tax");
            add("tad");
            add("den");
            add("rex");
            add("pee");
        }};
        //System.out.println(wordLadder.findLadders("red", "tax", list));
    }
}
