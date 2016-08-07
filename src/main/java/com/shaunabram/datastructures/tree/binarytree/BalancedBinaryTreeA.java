package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.Node;

//Naive implementation
public class BalancedBinaryTreeA extends BalancedBinaryTree {

    public boolean isBalanced(Node node) {
        if (node==null) return true; //base case

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int difference = Math.abs(leftHeight-rightHeight);

        if (difference>1) return false;
        else return isBalanced(node.getLeft()) &&
                isBalanced(node.getRight());
    }

    int getHeight(Node node) {
        if (node == null) return 0;
        traversedNodeCount++;
        System.out.println(node.getValue());
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.abs(leftHeight - rightHeight) + 1;
    }

}
