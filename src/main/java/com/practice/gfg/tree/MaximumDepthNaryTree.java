package com.practice.gfg.tree;

import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class MaximumDepthNaryTree {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int height = 0;

        for (Node child : root.children) {
            height = Math.max(height, maxDepth(child) + 1);
        }

        return height;
    }
}
