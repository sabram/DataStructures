package com.shaunabram.datastructures.graph2;

import java.util.*;
import static com.shaunabram.datastructures.graph2.Node.Color.*;

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

    public List<Node> bfs(Node source) {
        List<Node> bfs = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()) {
            Node n = q.remove();
            if (n.color == WHITE) {
                List<Node> adjacentNodes = graph.get(n);
                for (Node adjacentNode : adjacentNodes) {
                    q.add(adjacentNode);
                    bfs.add(adjacentNode);
                    adjacentNode.setColor(GREY);
                }
                n.setColor(BLACK);
            }
        }
        return bfs;
    }
}
