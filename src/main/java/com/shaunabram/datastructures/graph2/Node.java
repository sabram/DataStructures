package com.shaunabram.datastructures.graph2;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String value;
    List<Node> children = new ArrayList<>();

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
}
