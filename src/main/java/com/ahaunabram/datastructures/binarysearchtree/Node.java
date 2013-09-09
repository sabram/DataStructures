package com.ahaunabram.datastructures.binarysearchtree;

public class Node {
    Integer value;
    Node left;
    Node right;

    Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
