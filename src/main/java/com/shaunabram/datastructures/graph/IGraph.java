package com.shaunabram.datastructures.graph;

import java.util.List;

public interface IGraph {

    public void addNode(Node v);

    public void addEdge(Node v1, Node v2);

    public boolean hasEdge(Node v1, Node v2);

    /**
     * Returns a list of nodes representing (one possible version of) a breadth first search tree.
     */
    public List<Node> bfs(Node s);

    /**
     * Returns the shortest path between source and destination.
     * If multiple paths with the same shortest distance exist, an arbitrary one will be returned,
     * specifically the first encountered in the BFS.
     */
    public List<Node> getShortestPath(Node source, Node destination);

}
