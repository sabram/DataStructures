package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.StrNode;
import org.junit.Test;
import static com.shaunabram.datastructures.tree.binarytree.BinaryTree.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    @Test
    public void isBalanced_true_for_null_node() {//empty tree
        assertTrue(isBalanced(null));
    }

    @Test
    public void isBalanced_true_for_single_node() {
        StrNode root = new StrNode("A");
        assertTrue(isBalanced(root));
    }

    @Test
    /**
     *           a
     *          /
     *         b
     */
    public void isBalanced_true_for_root_plus_one_child() {
        StrNode b = new StrNode("b");
        StrNode root = new StrNode("a", b, null);
        assertTrue(isBalanced(root));
    }

    @Test
    /**
     *           a
     *          / \
     *         b   c
     */
    public void isBalanced_true_for_root_plus_two_child() {
        StrNode b = new StrNode("b");
        StrNode c = new StrNode("c");
        StrNode root = new StrNode("a", b, c);
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
        StrNode c = new StrNode("c");
        StrNode b = new StrNode("b", c, null);
        StrNode root = new StrNode("a", b, null);
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
        StrNode i = new StrNode("i");
        StrNode g = new StrNode("g", i, null);
        StrNode d = new StrNode("d", g, null);
        StrNode e = new StrNode("e");
        StrNode b = new StrNode("b", d, e);

        StrNode h = new StrNode("h");
        StrNode f = new StrNode("f", h, null);
        StrNode c = new StrNode("c", f, null);

        StrNode root = new StrNode("a", b, c);

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
        StrNode h = new StrNode("h");
        StrNode i = new StrNode("i");
        StrNode d = new StrNode("d", h, i);

        StrNode e = new StrNode("e");
        StrNode b = new StrNode("b", d, e);

        StrNode f = new StrNode("f");
        StrNode g = new StrNode("g");
        StrNode c = new StrNode("c", f, g);

        StrNode a = new StrNode("a", b, c);

        assertTrue(isBalanced(a));
    }

}
