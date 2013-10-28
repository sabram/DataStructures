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
     * A--B--F--G
     *    \
     *     \-E
     *  DFS tree should be a, b, c, d, e, f, g
     */
    public void dfs() {
        List<Node> emptyList = new ArrayList<>();

        Node d = new Node("D", emptyList);
        Node c = new Node("C", Lists.newArrayList(d));

        Node g = new Node("G", emptyList);
        Node f = new Node("F", Lists.newArrayList(g));

        Node e = new Node("E", emptyList);

        Node b = new Node("B", Lists.newArrayList(c, f, e));

        Node a = new Node("A", Lists.newArrayList(b));

        List<Node> expected = Lists.newArrayList(a, b, c, d, e, f, g);
        List<Node> dfsTree = Graph.dfs(a);
        assertThat(dfsTree).isEqualTo(expected);
    }
}
