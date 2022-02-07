package com.practice.gfg;

/**
 * https://leetcode.com/problems/implement-trie-ii-prefix-tree
 */
public class TrieII {
    private TrieNode rootNode;

    public TrieII() {
        rootNode = new TrieNode();
    }

    public void insert(String word) {
        TrieNode tmpNode = rootNode;
        for (char c : word.toCharArray()) {
            if (tmpNode.children[c - 'a'] == null) {
                tmpNode.children[c - 'a'] = new TrieNode();
            }
            tmpNode.children[c - 'a'].prefixWordCount++;
            tmpNode = tmpNode.children[c - 'a'];
        }
        tmpNode.endWordCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode tmpNode = rootNode;
        for (char c : word.toCharArray()) {
            if (tmpNode.children[c - 'a'] == null)
                return 0;

            tmpNode = tmpNode.children[c - 'a'];
        }
        return tmpNode.endWordCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode tmpNode = rootNode;
        for (char c : prefix.toCharArray()) {
            if (tmpNode.children[c - 'a'] == null)
                return 0;

            tmpNode = tmpNode.children[c - 'a'];
        }
        return tmpNode.prefixWordCount;
    }

    public void erase(String word) {
        TrieNode tmpNode = rootNode;
        for (char c : word.toCharArray()) {
            if (tmpNode.children[c - 'a'].prefixWordCount == 1) {
                tmpNode.children[c - 'a'] = null;
                return;
            } else {
                tmpNode.children[c - 'a'].prefixWordCount--;
                tmpNode = tmpNode.children[c - 'a'];
            }
        }

        tmpNode.endWordCount--;
    }

    private class TrieNode {
        TrieNode[] children;
        int endWordCount;
        int prefixWordCount;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        TrieII trieII = new TrieII();
        trieII.insert("apple");
        trieII.insert("apple");
        System.out.println(trieII.countWordsEqualTo("apple"));
        System.out.println(trieII.countWordsStartingWith("app"));

        trieII.insert("apple");
        trieII.erase("apple");
        System.out.println(trieII.countWordsEqualTo("apple"));
        trieII.insert("apple");
        System.out.println(trieII.countWordsEqualTo("apple"));
        System.out.println(trieII.countWordsStartingWith("app"));

        System.out.println();
        trieII = new TrieII();
        //["Trie","insert","insert","insert","countWordsEqualTo","countWordsEqualTo","insert","countWordsStartingWith"]
        //[[],["snty"],["snty"],["snty"],["snty"],["snty"],["snty"],["s"]]
        trieII.insert("snty");
        trieII.insert("snty");
        trieII.insert("snty");
        System.out.println(trieII.countWordsEqualTo("snty"));
        System.out.println(trieII.countWordsEqualTo("snty"));
        trieII.insert("snty");
        System.out.println(trieII.countWordsStartingWith("s"));

        System.out.println();
        trieII = new TrieII();
        //["Trie","countWordsStartingWith","countWordsStartingWith","countWordsStartingWith","countWordsStartingWith","insert","erase"]
        //[[],["d"],["dt"],["dtm"],["dtm"],["dtm"],["dtm"]]
        System.out.println(trieII.countWordsStartingWith("d"));
        System.out.println(trieII.countWordsStartingWith("dt"));
        System.out.println(trieII.countWordsStartingWith("dtm"));
        System.out.println(trieII.countWordsStartingWith("dtm"));
        trieII.insert("dtm");
        trieII.erase("dtm");

        System.out.println();
        trieII = new TrieII();
        //["Trie","countWordsEqualTo","insert","erase","countWordsStartingWith","insert"]
        //[[],["w"],["w"],["w"],["w"],["w"]]
        System.out.println(trieII.countWordsEqualTo("w"));
        trieII.insert("w");
        trieII.erase("w");
        System.out.println(trieII.countWordsStartingWith("w"));
        trieII.insert("w");
        System.out.println(trieII.countWordsEqualTo("w"));
    }


}
