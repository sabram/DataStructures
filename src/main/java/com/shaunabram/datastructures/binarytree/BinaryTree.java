package com.shaunabram.datastructures.binarytree;

public class BinaryTree {

    public static boolean isBalanced(Node node) {
        if (node==null) return true;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int height = Math.abs(leftHeight - rightHeight);
        if (height>1) {
            return false;
        } else {
            return isBalanced(node.getLeft()) && isBalanced(node.getRight());
        }
    }

    private static int getHeight(Node node) {
        if (node == null) return 0;
        if (node.getHeight() != null) {//used cached height, if available
            return node.getHeight();
        }
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int height = Math.max(leftHeight, rightHeight) + 1;
        node.setHeight(height); //cache height
        return height;
    }

}
