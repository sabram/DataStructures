package com.shaunabram.datastructures.binarytree;

import java.util.*;

public class BinaryTree {

    public static boolean isBalanced(Node root) {
        //Map<child, parent>; if parents.get(a)==b, b is a parent of a
        Map<Node, Node> parents = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        root.color = Node.Color.DISCOVERED;
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.remove();
            assert n.color == Node.Color.DISCOVERED;
            if (n.getLeft() != null) {
                if (n.getLeft().color == Node.Color.UNDISCOVERED) {
                    parents.put(n.getLeft(), n);
                    n.getLeft().color = Node.Color.DISCOVERED;
                    q.add(n.getLeft());
                }
            }
            if (n.getRight() != null) {
                if (n.getRight().color == Node.Color.UNDISCOVERED) {
                    parents.put(n.getRight(), n);
                    n.getRight().color = Node.Color.DISCOVERED;
                    q.add(n.getRight());
                }
            }
            n.color = Node.Color.PROCESSED;
        }
        List<Node> leaves = getAllLeafNodes(parents);
        int minDepth = Integer.MAX_VALUE;
        int maxDepth = 0;
        for (Node leaf : leaves) {
            int depth = 0;
            Node parent = leaf;
            while (!root.equals(parent)) {
                depth++;
                parent = parents.get(parent);
            }
            if (!parent.equals(root)) {
                throw new RuntimeException("No path to root from node " + leaf);
            }
            if (depth<minDepth) minDepth = depth;
            if (depth>maxDepth) maxDepth = depth;
        }
        boolean unbalanced = (maxDepth - minDepth)>1;
        return !unbalanced;
    }

    private static List<Node> getAllLeafNodes(Map<Node, Node> parents) {
        List<Node> leaves = new ArrayList<>();
        for (Node node : parents.keySet()) {
            if (node.getLeft()==null && node.getRight()==null) {
                leaves.add(node);
            }
        }
        return leaves;
    }
}
