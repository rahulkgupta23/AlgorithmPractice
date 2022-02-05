package com.practice.gfg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/solution/
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode tempList = null;
        int size = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        pq.addAll(Arrays.asList(lists));

        while(!pq.isEmpty()) {
            ListNode temp = pq.remove();
            if (tempList == null)
                tempList = temp;
            else
                tempList.next = temp;

            if (temp.next != null) pq.add(temp.next);
        }

        return tempList;
    }
}
