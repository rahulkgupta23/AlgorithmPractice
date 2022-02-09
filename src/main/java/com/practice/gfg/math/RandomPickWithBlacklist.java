package com.practice.gfg.math;

import java.util.*;

/**
 * https://leetcode.com/problems/random-pick-with-blacklist/
 */
public class RandomPickWithBlacklist {

    Map<Integer, Integer> m;
    Random r;
    int wlen;

    public RandomPickWithBlacklist(int n, int[] b) {
        m = new HashMap<>();
        r = new Random();
        wlen = n - b.length;
        Set<Integer> w = new HashSet<>();
        for (int i = wlen; i < n; i++) w.add(i);
        for (int x : b) w.remove(x);
        Iterator<Integer> wi = w.iterator();
        for (int x : b)
            if (x < wlen)
                m.put(x, wi.next());
    }

    public int pick() {
        int k = r.nextInt(wlen);
        return m.getOrDefault(k, k);
    }

    public static void main(String[] args) {
        RandomPickWithBlacklist randomPickWithBlacklist = new RandomPickWithBlacklist(7, new int[] {2, 3, 5});
        System.out.println(randomPickWithBlacklist.pick());
        System.out.println(randomPickWithBlacklist.pick());
        System.out.println(randomPickWithBlacklist.pick());
        System.out.println(randomPickWithBlacklist.pick());
        System.out.println(randomPickWithBlacklist.pick());
    }
}
