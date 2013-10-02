package com.shaunabram.datastructures.graph2;

import java.util.*;
import static com.shaunabram.datastructures.graph2.Node.Color.*;

public class Graph {

    Map<Node, List<Node>> graph = new HashMap<>();

    public Graph() {}

    public Graph(Node... nodes) {
        for (Node node : nodes) {
            addNode(node);
        }
    }

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
     * Determines if components are connected using breadth-first search,
     * given an arbitrary node.
     *
     */
    public boolean isConnected(Node n) {
        int totalNodes = graph.size();
        int connectedNodes = bfs(n).size();
        return totalNodes == connectedNodes;
    }

    public List<Node> bfs(Node source) {
        List<Node> bfs = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        source.setColor(GREY);
        q.add(source);
        bfs.add(source);
        while(!q.isEmpty()) {
            Node n = q.remove();
            List<Node> adjacentNodes = graph.get(n);
            for (Node adjacentNode : adjacentNodes) {
                if (adjacentNode.color == WHITE) {
                    adjacentNode.setColor(GREY);
                    q.add(adjacentNode);
                    bfs.add(adjacentNode);
                }
                n.setColor(BLACK);
            }
        }
        reset();
        return bfs;
    }

    //resets all node colors to WHITE
    private void reset() {
        Set<Node> keys = graph.keySet();
        for (Node key : keys) {
            key.setColor(WHITE);
        }
        Collection<List<Node>> allLists = graph.values();
        for (List<Node> list : allLists) {
            for (Node node : list) {
                node.setColor(WHITE);
            }
        }
    }
}
