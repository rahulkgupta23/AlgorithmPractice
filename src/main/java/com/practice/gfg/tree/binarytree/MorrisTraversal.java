package com.practice.gfg.tree.binarytree;

/**
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 */
public class MorrisTraversal {
    tNode root;

    public static void main(String[] args) {

        /* Constructed binary tree is
               1
             /   \
            2      3
          /   \
         4     5

         4 2 5 1 3
        */

        MorrisTraversal tree = new MorrisTraversal();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);

        tree.morrisTraversal(tree.root);
    }

    private void morrisTraversal(tNode root) {
        tNode currNode = root, prev;

        if (root == null)
            return;
        else if (root.left == null && root.right == null) {
            System.out.println(root.data);
            return;
        }

        while (currNode != null) {
            if (currNode.left == null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.right;
            } else {
                prev = currNode.left;
                while (prev.right != null && prev.right != currNode) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = currNode;
                    currNode = currNode.left;
                } else {
                    prev.right = null;
                    System.out.print(currNode.data + " ");
                    currNode = currNode.right;
                }
            }
        }
    }
}

class tNode {
    int data;
    tNode left, right;

    tNode(int item)
    {
        data = item;
        left = right = null;
    }
}
