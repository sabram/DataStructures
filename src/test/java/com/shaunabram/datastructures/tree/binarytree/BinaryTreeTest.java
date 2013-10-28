package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.IntNode;
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

    @Test
    public void isBST_usingRecursion_true_for_bst() {
        IntNode bst = createBST();
        assertTrue(BinaryTree.isBST_usingRecursion(bst));
    }

    @Test
    public void isBST_usingRecursion_false_for_non_bst() {
        IntNode nonBst = createNonBST();
        assertFalse(BinaryTree.isBST_usingRecursion(nonBst));
    }

    @Test
    public void isBST_usingRecursion_false_for_tricky_non_bst() {
        IntNode nonBst = createTrickyNonBST();
        assertFalse(BinaryTree.isBST_usingRecursion(nonBst));
    }

    @Test
    public void isBST_usingRecursion_false_for_tricky_non_bst2() {
        IntNode nonBst = createTrickyNonBST2();
        assertFalse(BinaryTree.isBST_usingRecursion(nonBst));
    }

    @Test
    public void isBST_usingInorder_true_for_bst() {
        IntNode bst = createBST();
        assertTrue(BinaryTree.isBST_usingInorder(bst));
    }

    @Test
    public void isBST_usingInorder_false_for_non_bst() {
        IntNode nonBst = createNonBST();
        assertFalse(BinaryTree.isBST_usingInorder(nonBst));
    }

    @Test
    public void isBST_usingInorder_false_for_tricky_non_bst() {
        IntNode nonBst = createTrickyNonBST();
        assertFalse(BinaryTree.isBST_usingInorder(nonBst));
    }

    @Test
    public void isBST_usingInorder_false_for_tricky_non_bst2() {
        IntNode nonBst = createTrickyNonBST2();
        assertFalse(BinaryTree.isBST_usingInorder(nonBst));
    }

    /**
     *     4
     *    / \
     *   2   5
     *  / \   \
     * 1   3   6
     */
    private IntNode createBST() {
        IntNode n1 = new IntNode(1, null, null);
        IntNode n3 = new IntNode(3, null, null);
        IntNode n6 = new IntNode(6, null, null);
        IntNode n2 = new IntNode(2, n1, n3);
        IntNode n5 = new IntNode(5, null, n6);
        return new IntNode(4, n2, n5);
    }

    /**
     *     3
     *    / \
     *   1   2
     */
    private IntNode createNonBST() {
        IntNode n1 = new IntNode(1, null, null);
        IntNode n2 = new IntNode(2, null, null);
        IntNode n3 = new IntNode(3, n1, n2);
        return n3;
    }

    /**
     *     10
     *    / \
     *   5   15
     *      /  \
     *     6   20
     */
    private IntNode createTrickyNonBST() {
        IntNode n6 = new IntNode(6, null, null);
        IntNode n20 = new IntNode(20, null, null);
        IntNode n15 = new IntNode(15, n6, n20);
        IntNode n5 = new IntNode(5, null, null);
        IntNode n10 = new IntNode(10, n5, n15);
        return n10;
    }

    /**
     *     10
     *    / \
     *   5   15
     *      /  \
     *     13   20
     *    /  \
     *   9   14 -- 9 is the odd man out: should be >10 & < 15
     */
    private IntNode createTrickyNonBST2() {
        IntNode n9 = new IntNode(9, null, null);
        IntNode n14 = new IntNode(14, null, null);
        IntNode n13 = new IntNode(13, n9, n14);
        IntNode n20 = new IntNode(20, null, null);
        IntNode n15 = new IntNode(15, n13, n20);
        IntNode n5 = new IntNode(5, null, null);
        IntNode n10 = new IntNode(10, n5, n15);
        return n10;
    }
}
