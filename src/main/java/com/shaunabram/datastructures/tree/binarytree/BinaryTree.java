package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.IntNode;
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

    public static boolean isBSTold(IntNode node) {
        if (node == null) return true;
        if ( (node.getLeft() == null || node.getLeft().getValue() < node.getValue()) &&
             (node.getRight() == null || node.getRight().getValue() > node.getValue()) ) {
            return isBST_usingRecursion(node.getLeft()) && isBST_usingRecursion(node.getRight());
        } else {
            return false;
        }
    }

    public static boolean isBST_usingRecursion(IntNode node) {
        if (node == null) return true;
        final int min = 0;
        final int max = Integer.MAX_VALUE;
        return isBST_usingRecursion(node, min, max);
    }

    private static boolean isBST_usingRecursion(IntNode node, int min, int max) {
        if (node == null) return true;
        int val = node.getValue();
        if (min < val && val < max) {
            return isBST_usingRecursion(node.getLeft(), min, val) &&
                   isBST_usingRecursion(node.getRight(), val, max);
        } else {
            return false;
        }
    }

    public static boolean isBST_usingInorder(IntNode node) {
        return isBST_usingInorder(node.getLeft(), 0);
    }

    public static boolean isBST_usingInorder(IntNode node, int prevValue) {
        if (node == null) return true;
        if (isBST_usingInorder(node.getLeft(), prevValue)) {
            if (node.getValue() > prevValue) {
                prevValue = node.getValue();
                return isBST_usingInorder(node.getRight(), prevValue);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
