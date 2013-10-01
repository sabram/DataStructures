package com.shaunabram.datastructures.graph;

public class Node {

    //stored as an Object for convenience; could use generic Type
    private final Object value;
    private boolean explored = false;

    public Node(Object v) {
        this.value = v;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    public boolean isExplored() {
        return explored;
    }

    public Object getValue() {
        return value;
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
                "value=" + value +
                ", explored=" + explored +
                '}';
    }
}
