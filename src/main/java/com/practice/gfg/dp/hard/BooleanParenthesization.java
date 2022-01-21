package com.practice.gfg.dp.hard;

/**
 * https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/
 */
public class BooleanParenthesization {

    static int countParenthesis(char[] symbol, char[] opr) {
        int[][] dpTrue = new int[symbol.length][symbol.length];
        int[][] dpFalse = new int[symbol.length][symbol.length];

        //Gap Strategy, for loops are important
        for (int g = 0; g < symbol.length; g++) {
            for (int i = 0, j = g; j <= symbol.length - 1; i++, j++) {
                if (g == 0) {
                    dpTrue[i][j] = (symbol[i] == 'T') ? 1 : 0;
                    dpFalse[i][j] = (symbol[i] == 'F') ? 1 : 0;
                } else {
                    for (int k = i; k < j; k++) {
                        if (opr[k] == '&') {
                            dpTrue[i][j] += dpTrue[i][k] * dpTrue[k + 1][j];
                            dpFalse[i][j] += dpTrue[i][k] * dpFalse[k + 1][j] + dpFalse[i][k] * dpTrue[k + 1][j] + dpFalse[i][k] * dpFalse[k + 1][j];
                        } else if (opr[k] == '|') {
                            dpTrue[i][j] += dpTrue[i][k] * dpFalse[k + 1][j] + dpFalse[i][k] * dpTrue[k + 1][j] + dpTrue[i][k] * dpTrue[k + 1][j];
                            dpFalse[i][j] += dpFalse[i][k] * dpFalse[k + 1][j];
                        } else {    //case of '^'
                            dpTrue[i][j] += dpTrue[i][k] * dpFalse[k + 1][j] + dpFalse[i][k] * dpTrue[k + 1][j];
                            dpFalse[i][j] += dpFalse[i][k] * dpFalse[k + 1][j] + dpTrue[i][k] * dpTrue[k + 1][j];
                        }
                    }
                }
            }
        }

        return dpTrue[0][symbol.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(countParenthesis(new char[] {'T', 'F', 'T'}, new char[] {'^', '&'}));   //2
        System.out.println(countParenthesis(new char[] {'T', 'F', 'F'}, new char[] {'^', '|'}));   //2
        System.out.println(countParenthesis(new char[] {'T', 'T', 'F', 'T'}, new char[] {'|', '&', '^'}));   //4
    }
}
