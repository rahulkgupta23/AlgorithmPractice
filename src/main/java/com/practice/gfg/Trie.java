package com.practice.gfg;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree
 */
public class Trie {

    private static class TrieNode {
        public TrieNode[] children;
        public boolean endOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }

    public Trie() {
        rootNode = new TrieNode();
    }

    private TrieNode rootNode;

    public void insert(String word) {
        insert(word, 0, rootNode);
    }

    private void insert(String word, int index, TrieNode node) {
        if (index == word.length()) {
            node.endOfWord = true;
            return;
        }

        char strChar = word.charAt(index);

        if (node.children[strChar - 'a'] == null) {
            TrieNode trieNode = new TrieNode();
            node.children[strChar - 'a'] = trieNode;
        }
        insert(word, index + 1, node.children[strChar - 'a']);
    }

    public boolean search(String word) {
        return searchWord(word, 0, rootNode);
    }

    private boolean searchWord(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.endOfWord;
        }

        char strChar = word.charAt(index);
        if (node.children[strChar - 'a'] != null)
            return searchWord(word, index + 1, node.children[strChar - 'a']);
        else
            return false;
    }

    public boolean startsWith(String prefix) {
        return findPrefix(prefix, 0, rootNode);
    }

    private boolean findPrefix(String prefix, int index, TrieNode node) {
        if (index == prefix.length())
            return true;

        char strChar = prefix.charAt(index);
        if (node.children[strChar - 'a'] != null)
            return findPrefix(prefix, index + 1, node.children[strChar - 'a']);
        else
            return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("rahul");
        System.out.println(trie.startsWith("ra"));
        System.out.println(trie.startsWith("rah"));

        System.out.println(trie.search("ra"));
        System.out.println(trie.search("rah"));
        System.out.println(trie.search("rahul"));
    }
}

/*
  Your Trie object will be instantiated and called as such:
  Trie obj = new Trie();
  obj.insert(word);
  boolean param_2 = obj.search(word);
  boolean param_3 = obj.startsWith(prefix);
 */
