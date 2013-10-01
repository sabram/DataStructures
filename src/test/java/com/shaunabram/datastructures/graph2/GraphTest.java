package com.shaunabram.datastructures.graph2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest {

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
        assertTrue(graph.isConnected());
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
        assertTrue(graph.isConnected());
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
        assertTrue(graph.isConnected());
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
        assertFalse(graph.isConnected());
    }
}
