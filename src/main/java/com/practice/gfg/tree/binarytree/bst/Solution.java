package com.practice.gfg.tree.binarytree.bst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left != null && root.right != null) {
                int max = findMax(root.left);
                root.val = max;
                root.left = deleteNode(root.left, max);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {
                return null;
            }
        }

        return root;
    }

    public int findMax(TreeNode root) {
        while(root.right != null) {
            root = root.right;
        }

        return root.val;
    }
}
