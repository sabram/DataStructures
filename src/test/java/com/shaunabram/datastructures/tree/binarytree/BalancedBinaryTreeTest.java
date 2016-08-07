package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.Node;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedBinaryTreeTest {

    //can be used to test any of the BalancedBinaryTree implementations: A, B, C
    BalancedBinaryTree tree = new BalancedBinaryTreeC();
    
    @Test
    public void isBalanced_true_for_null_node() {//empty tree
        assertTrue(tree.isBalanced(null));
    }

    @Test
    public void isBalanced_true_for_single_node() {
        Node root = new Node("A");
        assertTrue(tree.isBalanced(root));
    }

    @Test
    /**
     *           a
     *          /
     *         b
     */
    public void isBalanced_true_for_root_plus_one_child() {
        Node b = new Node("b");
        Node root = new Node("a", b, null);
        assertTrue(tree.isBalanced(root));
    }

    @Test
    /**
     *           a
     *          / \
     *         b   c
     */
    public void isBalanced_true_for_root_plus_two_child() {
        Node b = new Node("b");
        Node c = new Node("c");
        Node a = new Node("a", b, c);
        System.out.println("Tree size = " + Node.getSize(a));
        assertTrue(tree.isBalanced(a));
        System.out.println("Nodes traversed = " + BalancedBinaryTree.traversedNodeCount);
    }

    @Test
    /**
     *           a
     *          /
     *         b
     *        /
     *       c
     */
    public void isBalanced_false_for_root_plus_child_plus_child() {
        Node c = new Node("c");
        Node b = new Node("b", c, null);
        Node a = new Node("a", b, null);
        System.out.println("Tree size = " + Node.getSize(a));
        assertFalse(tree.isBalanced(a));
        System.out.println("Nodes traversed = " + BalancedBinaryTree.traversedNodeCount);
    }

    @Test
    /**
     *           a
     *          / \
     *        b    c
     *       / \    \
     *     d    e    f
     *    /           \
     *   g             h
     *  /
     * i
     *
     */
    public void isBalanced_false_for_complex_unbalanced() {
        Node i = new Node("i");
        Node g = new Node("g", i, null);
        Node d = new Node("d", g, null);
        Node e = new Node("e");
        Node b = new Node("b", d, e);

        Node h = new Node("h");
        Node f = new Node("f", h, null);
        Node c = new Node("c", f, null);

        Node a = new Node("a", b, c);

        System.out.println("Tree size = " + Node.getSize(a));
        assertFalse(tree.isBalanced(a));
        System.out.println("Nodes traversed = " + BalancedBinaryTree.traversedNodeCount);
    }

    @Test
    /**
     *           a
     *         /   \
     *        b     c
     *       / \   / \
     *     d    e f   g
     *    / \
     *   h   i
     *
     */
    public void isBalanced_true_for_complex_balanced() {
        Node h = new Node("h");
        Node i = new Node("i");
        Node d = new Node("d", h, i);

        Node e = new Node("e");
        Node b = new Node("b", d, e);

        Node f = new Node("f");
        Node g = new Node("g");
        Node c = new Node("c", f, g);

        Node a = new Node("a", b, c);

        System.out.println("Tree size = " + Node.getSize(a));
        assertTrue(tree.isBalanced(a));
        System.out.println("Nodes traversed = " + BalancedBinaryTree.traversedNodeCount);
    }

    @Test
    /**
     *            a
     *         /     \
     *        b        c
     *       / \      /  \
     *     d    e    f    g
     *    / \  / \  / \  / \
     *   h  i j  k l  m n   o
     *
     */
    public void isBalanced_true_for_full_balanced() {
        Node h = new Node("h");
        Node i = new Node("i");
        Node j = new Node("j");
        Node k = new Node("k");
        Node l = new Node("l");
        Node m = new Node("m");
        Node n = new Node("n");
        Node o = new Node("o");

        Node d = new Node("d", h, i);
        Node e = new Node("e", j, k);
        Node f = new Node("f", l, m);
        Node g = new Node("g", n, o);

        Node b = new Node("b", d, e);
        Node c = new Node("c", f, g);

        Node a = new Node("a", b, c);
        System.out.println("Tree size = " + Node.getSize(a));
        assertTrue(tree.isBalanced(a));
        System.out.println("Nodes traversed = " + BalancedBinaryTree.traversedNodeCount);
    }

    @Test
    /**
     *                 a
     *           /          \
     *        b                  c
     *       /    \           /     \
     *     d       e         f       g
     *    /  \    /  \      /   \    /   \
     *   h   i   j    k    l    m   n    o
     * / \  / \  / \ / \   / \  / \ / \ / \
     *p  q r  s t  u v  w x  y z  A B C D E
     *
     */
    public void isBalanced_true_for_big_full_balanced() {
        Node p = new Node("p");
        Node q = new Node("q");
        Node r = new Node("r");
        Node s = new Node("s");
        Node t = new Node("t");
        Node u = new Node("u");
        Node v = new Node("v");
        Node w = new Node("w");
        Node x = new Node("x");
        Node y = new Node("y");
        Node z = new Node("z");
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        Node h = new Node("h", p, q);
        Node i = new Node("i", r, s);
        Node j = new Node("j", t, u);
        Node k = new Node("k", v, w);
        Node l = new Node("l", x, y);
        Node m = new Node("m", z, A);
        Node n = new Node("n", B, C);
        Node o = new Node("o", D, E);

        Node d = new Node("d", h, i);
        Node e = new Node("e", j, k);
        Node f = new Node("f", l, m);
        Node g = new Node("g", n, o);

        Node b = new Node("b", d, e);
        Node c = new Node("c", f, g);

        Node a = new Node("a", b, c);
        System.out.println("Tree size = " + Node.getSize(a));
        assertTrue(tree.isBalanced(a));
        System.out.println("Nodes traversed = " + BalancedBinaryTree.traversedNodeCount);
    }

}
