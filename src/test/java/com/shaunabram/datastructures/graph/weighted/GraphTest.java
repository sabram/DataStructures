package com.shaunabram.datastructures.graph.weighted;

import com.google.common.collect.Lists;
import org.junit.Test;
import java.util.List;
import static org.fest.assertions.Assertions.assertThat;

public class GraphTest {

    @Test
    /**
     *      B
     *  1 / | \ 6
     *   /  |  \
     *  /   |   \
     * A    |2   D
     *  \   |   /
     * 4 \  |  / 3
     *    \ | /
     *     \|/
     *      C
     * Shortest path from A to D is A, B, C, D with distance of 6.
     */
    public void shortestPath() {
        Node a = new Node(1, "A");
        Node b = new Node(1, "B");
        Node c = new Node(1, "C");
        Node d = new Node(1, "D");
        List<Node> nodes = Lists.newArrayList(a, b, c, d);

        Edge ab = new Edge(a, b, 1);
        Edge ac = new Edge(a, c, 4);
        Edge bc = new Edge(b, c, 2);
        Edge bd = new Edge(b, d, 6);
        Edge cd = new Edge(c, d, 3);

        Graph graph = new Graph(nodes);
        graph.addEdge(a, ab);
        graph.addEdge(a, ac);
        graph.addEdge(b, bc);
        graph.addEdge(b, bd);
        graph.addEdge(c, cd);
        List<Node> shortestPath = graph.shortestPath(a, d);
        assertThat(shortestPath).containsExactly(a, b, c, d);
        int distance = ab.getWeight() + bc.getWeight() + cd.getWeight();
        assertThat(distance).isEqualTo(6);
    }

    @Test
    /**
     * ! represents down arrow.
     *
     *     4
     *  A----->B
     *  |      |
     * 1|      | 5
     *  !      !
     *  C      D
     *   \    ^
     *  2 !  / 3
     *     E
     * Shortest path from A to D is A, C, E, D with distance of 6.
     */
    public void shortestPath2() {
        Node a = new Node(1, "A");
        Node b = new Node(1, "B");
        Node c = new Node(1, "C");
        Node d = new Node(1, "D");
        Node e = new Node(1, "E");
        List<Node> nodes = Lists.newArrayList(a, b, c, d, e);

        Edge ac = new Edge(a, c, 1);
        Edge ce = new Edge(c, e, 2);
        Edge ed = new Edge(e, d, 3);
        Edge bd = new Edge(b, d, 5);
        Edge ab = new Edge(a, b, 4);

        Graph graph = new Graph(nodes);

        graph.addEdge(a, ac);
        graph.addEdge(c, ce);
        graph.addEdge(e, ed);
        graph.addEdge(b, bd);
        graph.addEdge(a, ab);
        List<Node> shortestPath = graph.shortestPath(a, d);
        assertThat(shortestPath).containsExactly(a, c, e, d);
        int distance = ac.getWeight() + ce.getWeight() + ed.getWeight();
        assertThat(distance).isEqualTo(6);

    }
}
