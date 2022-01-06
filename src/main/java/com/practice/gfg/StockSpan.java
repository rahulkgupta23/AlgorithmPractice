package com.practice.gfg;

import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/stock-span-problem
 *
 * Solution:
 * 1. Pop
 * 2. Answer
 * 3. Push
 */
public class StockSpan {
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int[] price, int n) {
        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while(stack.size() > 0 && price[i] > price[stack.peek()]) {
                stack.pop();
            }

            if (stack.size() == 0)
                span[i] = i + 1;
            else
                span[i] = i - span[stack.peek()];

            stack.push(i);
        }

        return span;
    }
}
