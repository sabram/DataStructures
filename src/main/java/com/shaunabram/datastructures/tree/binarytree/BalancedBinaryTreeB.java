package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.Node;

//Better than "niave" implementation
public class BalancedBinaryTreeB {

    public static boolean isBalanced(Node node) {
        if (node==null) return true;
        int height = getHeight(node);
        if (height==-1)  {
            return false;
        } else {
            return true;
        }
    }

    private static int getHeight(Node node) {
        if (node == null) return 0;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        if (leftHeight==-1 || rightHeight==-1) {
            return -1;
        } else {
            int height = Math.abs(leftHeight - rightHeight);
            if (height>1) {
                return -1;
            } else {
                return height + 1;
            }
        }
    }

}
