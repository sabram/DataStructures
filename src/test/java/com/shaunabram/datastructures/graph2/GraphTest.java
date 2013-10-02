package com.shaunabram.datastructures.graph2;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest {

    @Test
    /**
     * A--B
     */
    public void bfs_for_2Node_connected_graph() {
        Node a = new Node("A");
        Node b = new Node("B");
        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(b);
        graph.connect(a, b);
        List<Node> bfs = graph.bfs(a);
        assertThat(bfs).containsExactly(a, b);
    }

    @Test
    /**
     * A--B--C
     *    |
     *    |--D
     */
    public void bfs_for_4Node_connected_graph() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Graph graph = new Graph(a, b, c, d);
        graph.connect(a, b);
        graph.connect(b, c);
        graph.connect(b, d);
        assertThat(graph.bfs(a)).containsExactly(a, b, c, d);
        assertThat(graph.bfs(b)).containsExactly(b, a, c, d);
    }

    @Test
    /**
     * A  B
     */
    public void bfs_for_2Node_unconnected_graph() {
        Node a = new Node("A");
        Node b = new Node("B");
        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(b);
        assertThat(graph.bfs(a)).containsExactly(a);
        assertThat(graph.bfs(b)).containsExactly(b);
    }

    @Test
    /**
     * A--B--C
     *
     * D--E
     */
    public void bfs_for_5Node_2_component_unconnected_graph() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Graph graph = new Graph(a, b, c, d, e);
        graph.connect(a, b);
        graph.connect(b, c);
        graph.connect(d, e);
        assertThat(graph.bfs(a)).containsExactly(a, b, c);
        assertThat(graph.bfs(b)).containsExactly(b, a, c);
        assertThat(graph.bfs(c)).containsExactly(c, b, a);
        assertThat(graph.bfs(d)).containsExactly(d, e);
        assertThat(graph.bfs(e)).containsExactly(e, d);
    }

    @Test
    /**
     * A--B
     */
    public void connected_returns_true_for_simple_connected_graph() {
        Node a = new Node("A");
        Node b = new Node("B");
        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(b);
        graph.connect(a, b);
        assertTrue(graph.isConnected(a));
        assertTrue(graph.isConnected(b));
    }

    @Test
    /**
     * A--B--C
     *    |
     *    |--D
     */
    public void connected_returns_true_for_4Node_connected_graph() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.connect(a, b);
        graph.connect(b, c);
        graph.connect(b, d);
        assertTrue(graph.isConnected(a));
        assertTrue(graph.isConnected(b));
        assertTrue(graph.isConnected(c));
        assertTrue(graph.isConnected(d));
    }

    @Test
    /**
     * A  B
     */
    public void connected_returns_false_for_2Node_unconnected_graph() {
        Node a = new Node("A");
        Node b = new Node("B");
        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(b);
        assertFalse(graph.isConnected(a));
        assertFalse(graph.isConnected(b));
    }

    @Test
    /**
     * A--B--C
     *
     * D--E
     */
    public void connected_returns_false_for_5Node_2_component_unconnected_graph() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.connect(a, b);
        graph.connect(b, c);
        graph.connect(d, e);
        assertFalse(graph.isConnected(a));
        assertFalse(graph.isConnected(b));
        assertFalse(graph.isConnected(c));
        assertFalse(graph.isConnected(d));
        assertFalse(graph.isConnected(e));
    }
}
