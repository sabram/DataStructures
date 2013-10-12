package com.shaunabram.datastructures.binarytree;

import org.junit.Test;
import static com.shaunabram.datastructures.binarytree.BinaryTree.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    @Test
    public void isBalanced_true_for_single_node() {
        Node root = new Node("A");
        assertTrue(isBalanced(root));
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
        assertTrue(isBalanced(root));
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
        Node root = new Node("a", b, c);
        assertTrue(isBalanced(root));
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
        Node root = new Node("a", b, null);
        assertFalse(isBalanced(root));
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

        Node root = new Node("a", b, c);

        assertFalse(isBalanced(root));
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

        assertTrue(isBalanced(a));
    }

}
