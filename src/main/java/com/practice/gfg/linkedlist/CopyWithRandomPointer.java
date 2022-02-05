package com.practice.gfg.linkedlist;

/**
 * Insert a copy of pointer b/w Nodes and then set up the Random Node.
 * https://leetcode.com/problems/copy-list-with-random-pointer
 */
public class CopyWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node currNode = head;

        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = new Node(currNode.val);
            currNode.next.next = nextNode;
            currNode = nextNode;
        }

        Node newHead = head.next;

        currNode = head;
        while (currNode != null) {
            Node randomNode = currNode.random;
            if (randomNode != null) {
                currNode.next.random = randomNode.next;
            }
            currNode = currNode.next.next;
        }

        currNode = head;
        while (currNode != null) {
            Node tmpNode = currNode.next;
            currNode.next = currNode.next.next;
            tmpNode.next = tmpNode.next != null ? tmpNode.next.next : null;

            currNode = currNode.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random
                = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        print(start);

        System.out.println();
        CopyWithRandomPointer copyWithRandomPointer = new CopyWithRandomPointer();
        print(copyWithRandomPointer.copyRandomList(start));
    }

    static void print(Node start) {
        Node ptr = start;
        System.out.println(start);
        while (ptr != null) {
            System.out.println("Data = " + ptr.val
                    + ", Random = "
                    + ptr.random.val);
            ptr = ptr.next;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
