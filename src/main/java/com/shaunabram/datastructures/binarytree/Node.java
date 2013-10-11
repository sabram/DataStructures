package com.shaunabram.datastructures.binarytree;

public class Node {
    public enum Color {UNDISCOVERED, DISCOVERED, PROCESSED}

    private final String value;
    private final Node left;
    private final Node right;
    public Color color = Color.UNDISCOVERED;

    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (value != null ? !value.equals(node.value) : node.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", color=" + color +
                '}';
    }
}
