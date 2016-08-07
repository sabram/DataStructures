package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.Node;

//Better than "niave" implementation, uses memoization
public class BalancedBinaryTreeB extends BalancedBinaryTree {

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
        //System.out.println(node.getValue());
        if (node.getHeight() != null) return node.getHeight();
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int height = Math.abs(leftHeight - rightHeight) + 1;
        node.setHeight(height);
        return height;
    }

}
