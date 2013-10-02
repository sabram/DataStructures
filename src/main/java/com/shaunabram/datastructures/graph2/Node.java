package com.shaunabram.datastructures.graph2;

import java.util.ArrayList;
import java.util.List;

public class Node {
    enum Color {WHITE, GREY, BLACK};

    private final String value;
    List<Node> children = new ArrayList<>();
    Color color = Color.WHITE;

    public Node(String value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public String getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (!value.equals(node.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + "\n" +
                "color='" + color + "\n" +
                '}';
    }
}
