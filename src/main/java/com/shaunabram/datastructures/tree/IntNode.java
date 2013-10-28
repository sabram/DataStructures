package com.shaunabram.datastructures.tree;

public class IntNode {
    private final Integer value;
    IntNode left;
    IntNode right;

    public IntNode(Integer value) {
        this.value = value;
    }

    public IntNode(Integer value, IntNode left, IntNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
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

    public void setRight(IntNode right) {
        this.right = right;
    }

    public void setLeft(IntNode left) {
        this.left = left;
    }
}
