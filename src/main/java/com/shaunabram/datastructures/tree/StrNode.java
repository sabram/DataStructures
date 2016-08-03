package com.shaunabram.datastructures.tree;

public class StrNode {

    private final String value;
    private final StrNode left;
    private final StrNode right;

    public StrNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public StrNode(String value, StrNode left, StrNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public StrNode getLeft() {
        return left;
    }

    public StrNode getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StrNode node = (StrNode) o;

        if (value != null ? !value.equals(node.value) : node.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "StrNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
