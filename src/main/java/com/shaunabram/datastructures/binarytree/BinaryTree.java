package com.shaunabram.datastructures.binarytree;

public class BinaryTree {

    public static boolean isBalanced(Node node) {
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
        if (node == null) return 0;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int biggest = Math.max(leftHeight, rightHeight);
        return biggest + 1;
    }

}
