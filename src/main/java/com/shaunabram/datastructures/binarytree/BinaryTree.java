package com.shaunabram.datastructures.binarytree;

public class BinaryTree {

    public static boolean isBalanced(Node node) {
        System.out.println("Determining isBalanced for " + node);
        if (node==null) return true;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int biggest = Math.max(leftHeight, rightHeight);
        int smallest = Math.min(leftHeight, rightHeight);
        boolean isBalanced = ((biggest - smallest) == 0) || ((biggest - smallest) == 1);
        if (isBalanced) {
            isBalanced = isBalanced(node.getLeft()) && isBalanced(node.getRight());
        }
        return isBalanced;
    }

    private static int getHeight(Node node) {
        System.out.println("Determining getHeight for " + node);
        if (node == null) return 0;
        if (node.height != null) {
            System.out.println("getHeight for node + " + node + " is cached: " + node.height);
            return node.height;
        }
        System.out.println("getHeight recursively for node + " + node);
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int biggest = Math.max(leftHeight, rightHeight);
        int height = biggest + 1;
        node.height = height;
        return height;
    }

}
