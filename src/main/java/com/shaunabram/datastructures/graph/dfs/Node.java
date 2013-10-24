package com.shaunabram.datastructures.graph.dfs;

import java.util.List;

public class Node {

    String value;
    List<Node> children;

    public Node(String value, List<Node> children) {
        this.value = value;
        this.children = children;
    }

    public String getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return children;
    }


}
