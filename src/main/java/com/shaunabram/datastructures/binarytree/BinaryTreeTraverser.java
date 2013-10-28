package com.shaunabram.datastructures.binarytree;

public class BinaryTreeTraverser {

    public static String preOrder(Node node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(node.getValue());
        sb.append(preOrder(node.getLeft()));
        sb.append(preOrder(node.getRight()));
        return sb.toString();
    }

    public static String inOrder(Node node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(inOrder(node.getLeft()));
        sb.append(node.getValue());
        sb.append(inOrder(node.getRight()));
        return sb.toString();
    }

    public static String postOrder(Node node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(postOrder(node.getLeft()));
        sb.append(postOrder(node.getRight()));
        sb.append(node.getValue());
        return sb.toString();
    }

}
