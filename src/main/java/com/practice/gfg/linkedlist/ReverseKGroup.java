package com.practice.gfg.linkedlist;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "(" +
                "val=" + val +
                ") -> " + next;
    }
}

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group
 */
class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode origHead = head;

        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }

        System.out.println("Original: " + origHead);
        ListNode th = null;
        ListNode tt = null;
        ListNode oh = null;
        ListNode ot = null;

        head = origHead;
        while (size >= k) {
            tt = head;
            th = head;
            head = head.next;
            tt.next = null;
            th.next = null;
            for (int i = 1; i < k; i++) {
                ListNode next = head;
                head = head.next;
                next.next = th;
                th = next;
            }

            size = size - k;

            if (ot == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }

            System.out.println("th: " + th);
            System.out.println("oh: " + oh);
        }

        ot.next = head;

        return oh;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        System.out.println("Result: " + reverseKGroup.reverseKGroup(head, 2));

        System.out.println();

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Result: " + reverseKGroup.reverseKGroup(head, 3));

        System.out.println();

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Result: " + reverseKGroup.reverseKGroup(head, 4));
    }
}
