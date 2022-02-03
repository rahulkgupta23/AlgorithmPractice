package com.practice.gfg.tree.binarytree;

import com.sun.source.tree.Tree;

public class SerializeDeSerializeBinaryTree {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private static String serialize(TreeNode root) {
        if (root == null) return "";

        if (root.left == null && root.right == null) return root.data + ",$,$";

        if (root.left == null) return root.data + ",$" + serialize(root.right);

        if (root.right == null) return root.data + "," + serialize(root.left) + ",$";

        return root.data + "," + serialize(root.left) + "," + serialize(root.right);
    }

    static int index = 0;
    private static TreeNode deSerialize(String str) {
        String[] charArray = str.split(",");
        return helper(charArray);
    }

    private static TreeNode helper(String[] charArray) {
        if (charArray.length == 0) return null;
        if (charArray.length == 1) return new TreeNode(Integer.parseInt(charArray[index]));

        if (charArray[index].equals("$")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(charArray[index]));

        index++;
        root.left = helper(charArray);

        index++;
        root.right = helper(charArray);

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.right.left = new TreeNode(4);

        System.out.println(serialize(treeNode));
        System.out.println(serialize(deSerialize(serialize(treeNode))));
    }
}
