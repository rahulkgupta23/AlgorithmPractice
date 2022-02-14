package com.practice.gfg.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures
 */
public class Temperature {
    public static int[] findTemp(int[] temp) {
        int[] res = new int[temp.length];
        Stack<Integer> st = new Stack<>();

        for (int i = temp.length - 1; i >= 0 ; i--) {
            if (!st.isEmpty() && temp[i] >= temp[st.peek()]) {
                while (!st.isEmpty() && temp[i] >= temp[st.peek()]) {
                    st.pop();
                }
            }

            if (!st.isEmpty()) {
                res[i] = st.peek() - i;
            }
            st.push(i);
            System.out.println(temp[i] + " -> Stack: " + st);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findTemp(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(findTemp(new int[] {89,62,70,58,47,47,46,76,100,70})));
    }
}
