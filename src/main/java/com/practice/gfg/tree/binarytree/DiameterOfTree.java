package com.practice.gfg.tree.binarytree;

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

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
class DiameterOfTree {
    static class DiaPair {
        int d;
        int height;

        public DiaPair(int d, int height) {
            this.d = d;
            this.height = height;
        }
    }

    public static DiaPair findDiameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return new DiaPair(0, -1);
        }

        DiaPair ld = findDiameterOfBinaryTree(root.left);
        DiaPair rd = findDiameterOfBinaryTree(root.right);

        int rootd = Math.max(ld.height + rd.height + 2, Math.max(ld.d, rd.d));

        System.out.println(root.val  + " " + rootd + " " + (Math.max(ld.height, rd.height) + 1));
        return new DiaPair(rootd, Math.max(ld.height, rd.height) + 1);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        return findDiameterOfBinaryTree(root).d;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), //left
                new TreeNode(3, null, null));  //right

        System.out.println(diameterOfBinaryTree(root));
    }
}
