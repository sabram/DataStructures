package com.shaunabram.datastructures.graph.dfs;

import java.util.List;

public class Node implements Comparable {

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
    /**
     * This method compares this object with o1 object. Returned int value has the following meanings.
     * positive – this object is greater than o1
     * zero – this object equals to o1
     * negative – this object is less than o1
     */
    public int compareTo(Object o) {
        Node o1 = (Node)o;
        return this.getValue().compareTo(o1.getValue());
    }
}
