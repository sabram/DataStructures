package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.Node;

//Better than "niave" implementation
public class BalancedBinaryTreeC extends BalancedBinaryTree {

    public boolean isBalanced(Node node) {
        if (node==null) return true;
        int height = getHeight(node);
        return (height !=- 1);
    }

    int getHeight(Node node) {
        if (node == null) return 0;
        traversedNodeCount++;
        System.out.println(node.getValue());
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        if (leftHeight==-1 || rightHeight==-1) {
            return -1;
        } else {
            int heightDifference = Math.abs(leftHeight - rightHeight);
            if (heightDifference>1) {
                return -1;
            } else {
                int height = heightDifference + 1;
                return height;
            }
        }
    }

}
