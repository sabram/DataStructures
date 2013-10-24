package com.shaunabram.datastructures.graph.dfs;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class GraphTest {


    @Test
    /**
     *     /-C--D
     *    /
     * A--B--E
     *    \
     *     \-F--G
     *    Shorttest path from A to F is ACF
     */
    public void getShortestPaths_returns_shortest_path() {
        List<Node> emptyList = new ArrayList<>();

        Node d = new Node("D", emptyList);
        Node c = new Node("C", Lists.newArrayList(d));

        Node e = new Node("E", emptyList);

        Node g = new Node("G", emptyList);
        Node f = new Node("F", Lists.newArrayList(g));

        Node b = new Node("B", Lists.newArrayList(c, e, f));

        Node a = new Node("A", Lists.newArrayList(b));

        List<Node> expected = Lists.newArrayList(a, b, c, d, e, f, g);
        List<Node> dfsTree = Graph.dfs(a);
        assertThat(dfsTree).isEqualTo(expected);
    }
}
