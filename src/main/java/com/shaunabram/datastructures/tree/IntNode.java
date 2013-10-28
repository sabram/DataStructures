package com.shaunabram.datastructures.tree;

public class IntNode {
    Integer value;
    IntNode left;
    IntNode right;

    IntNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public IntNode getLeft() {
        return left;
    }

    public IntNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "IntNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
