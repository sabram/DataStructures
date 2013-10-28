package com.shaunabram.datastructures.graph.weighted;

public class Node {

    private final int id;
    private final Object value;

    Node predecessor;

    public Node(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        return "IntNode{" +
                "id=" + getId() +
                ", value=" + getValue() +
                '}';
    }
}
