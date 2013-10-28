package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.StrNode;

public class BinaryTree {

    public static boolean isBalanced(StrNode node) {
        if (node==null) return true;
        int height = getHeight(node);
        if (height==-1)  {
            return false;
        } else {
            return true;
        }
    }

    private static int getHeight(StrNode node) {
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