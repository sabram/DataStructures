package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.StrNode;

//Naive implementation
public class BalancedBinaryTreeA {

    public static boolean isBalanced(StrNode node) {
        if (node==null) return true;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int difference = Math.abs(leftHeight-rightHeight);
        if (difference>1)
            return false;
        else return isBalanced(node.getLeft()) &&
                isBalanced(node.getRight());
    }

    private static int getHeight(StrNode node) {
        if (node == null) return 0;
        System.out.println(node.getValue());
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.abs(leftHeight - rightHeight) + 1;
    }

}
