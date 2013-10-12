package com.shaunabram.datastructures.binarytree;

import java.util.*;

public class BinaryTree {

    public static boolean isBalanced(Node node) {
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int biggest = Math.max(leftHeight, rightHeight);
        int smallest = Math.min(leftHeight, rightHeight);
        boolean isBalanced = (biggest - smallest) > 1;
        if (isBalanced) {
            isBalanced = isBalanced(node.getLeft()) || isBalanced(node.getRight());
        }
        return isBalanced;
    }

    private static int getHeight(Node node) {
        if (node == null) return 0;

        return 0;  //To change body of created methods use File | Settings | File Templates.
    }

}
