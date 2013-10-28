package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.StrNode;

public class BinaryTreeTraverser {

    public static String preOrder(StrNode node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(node.getValue());
        sb.append(preOrder(node.getLeft()));
        sb.append(preOrder(node.getRight()));
        return sb.toString();
    }

    public static String inOrder(StrNode node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(inOrder(node.getLeft()));
        sb.append(node.getValue());
        sb.append(inOrder(node.getRight()));
        return sb.toString();
    }

    public static String postOrder(StrNode node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(postOrder(node.getLeft()));
        sb.append(postOrder(node.getRight()));
        sb.append(node.getValue());
        return sb.toString();
    }

}
