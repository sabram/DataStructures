package com.shaunabram.datastructures.graph2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Graph {

    Map<Node, List<Node>> graph;

    public void addNode(Node node) {
        if (graph.containsKey(node)) throw new RuntimeException("Node already exists in graph");
        graph.put(node, new ArrayList<Node>());
    }

    public void connect(Node a, Node b) {
        List<Node> aNodeList = graph.get(a);
        if (!aNodeList.contains(b)) aNodeList.add(b);
        List<Node> bNodeList = graph.get(b);
        if (!bNodeList.contains(a)) bNodeList.add(a);
    }

    /**
     * Determines if components are connected using breadth-first search
     */
    public boolean isConnected() {
        return false;
    }
}
