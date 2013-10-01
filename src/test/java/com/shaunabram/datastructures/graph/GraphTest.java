package com.shaunabram.datastructures.graph;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class GraphTest {
    Node nodeA = new Node("A");
    Node nodeB = new Node("B");

    @Test
    public void addEdge_results_in_hasEdge_being_true() {
        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addEdge(nodeA, nodeB);
        assertThat(graph.hasEdge(nodeA, nodeB)).isTrue();
    }

    @Test(expected = RuntimeException.class)
    public void addEdge_throws_ex_for_unknown_source_node() {
        Graph graph = new Graph();
        graph.addNode(nodeB);
        graph.addEdge(nodeA, nodeB);
    }

    @Test(expected = RuntimeException.class)
    public void addEdge_throws_ex_for_unknown_destination_node() {
        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addEdge(nodeA, nodeB);
    }

    @Test
    public void hasEdge_returns_false_for_non_node() {
        Graph graph = new Graph();
        assertThat(graph.hasEdge(nodeA, nodeB)).isFalse();
    }

    @Test
    public void hasEdge_returns_false_for_non_edge() {
        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        assertThat(graph.hasEdge(nodeA, nodeB)).isFalse();
    }

    @Test
    /**   |--C
     *    |   \
     * A--B--D \
     *    |    /
     *    |--E
     *    Shorttest path from A to E is ABE or ACE
     */
    public void getShortestPaths_returns_one_of_the_shortest_paths() {
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeB, nodeC);
        graph.addEdge(nodeB, nodeD);
        graph.addEdge(nodeB, nodeE);
        graph.addEdge(nodeC, nodeE);
        List<Node> shortestPath1 = Lists.newArrayList(nodeA, nodeB, nodeE);
        List<Node> shortestPath2 = Lists.newArrayList(nodeA, nodeC, nodeE);
        List<List<Node>> shortestPaths = new ArrayList<>();
        shortestPaths.add(shortestPath1);
        shortestPaths.add(shortestPath2);
        List<Node> returnedPath = graph.getShortestPath(nodeA, nodeE);
        assertThat(shortestPaths).contains(returnedPath);
    }

    @Test
    public void getShortestPaths_returns_shortest_path() {
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeA, nodeC);
        graph.addEdge(nodeB, nodeD);
        graph.addEdge(nodeB, nodeE);
        graph.addEdge(nodeE, nodeF);
        graph.addEdge(nodeC, nodeF);
        List<Node> shortestPath = Lists.newArrayList(nodeA, nodeC, nodeF);
        List<Node> returnedPath = graph.getShortestPath(nodeA, nodeF);
        assertThat(returnedPath).isEqualTo(shortestPath);
    }
}
