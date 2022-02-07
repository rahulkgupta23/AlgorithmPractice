package com.practice.gfg.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    if (findString(board, visited, word, i, j, 1)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean findString(char[][] board, boolean[][] visited, String word, int lastI, int lastJ, int charIndex) {
        boolean found = false;
        if (charIndex < word.length()) {
            char charToBeFound = word.charAt(charIndex);
            if (lastI > 0 && !visited[lastI - 1][lastJ] && board[lastI - 1][lastJ] == charToBeFound) {
                visited[lastI - 1][lastJ] = true;
                found = findString(board, visited, word, lastI - 1, lastJ, charIndex + 1);
                visited[lastI - 1][lastJ] = false;
            }

            if (lastI < board.length - 1 && !visited[lastI + 1][lastJ] && board[lastI + 1][lastJ] == charToBeFound) {
                visited[lastI + 1][lastJ] = true;
                found = found || findString(board, visited, word, lastI + 1, lastJ, charIndex + 1);
                visited[lastI + 1][lastJ] = false;
            }

            if (lastJ > 0 && !visited[lastI][lastJ - 1] && board[lastI][lastJ - 1] == charToBeFound) {
                visited[lastI][lastJ - 1] = true;
                found = found || findString(board, visited, word, lastI, lastJ - 1, charIndex + 1);
                visited[lastI][lastJ - 1] = false;
            }

            if (lastJ < board[0].length - 1 && !visited[lastI][lastJ + 1] && board[lastI][lastJ + 1] == charToBeFound) {
                visited[lastI][lastJ + 1] = true;
                found = found || findString(board, visited, word, lastI, lastJ + 1, charIndex + 1);
                visited[lastI][lastJ + 1] = false;
            }
        } else
            return true;

        return found;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
//        System.out.println(wordSearch.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
//        System.out.println(wordSearch.exist(new char[][] {{'A','B'}}, "BA"));
//        System.out.println(wordSearch.exist(new char[][] {{'A','A','A'}}, "AAAA"));
//        System.out.println(wordSearch.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(wordSearch.exist(new char[][] {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}}, "ABCESEEEFS"));
    }
}
