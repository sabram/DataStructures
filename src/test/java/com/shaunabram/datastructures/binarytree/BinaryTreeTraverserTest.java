package com.shaunabram.datastructures.binarytree;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BinaryTreeTraverserTest {

    Node tree;

    @Before
    public void setup() {
        Node c = new Node("c");
        Node e = new Node("e");
        Node h = new Node("h");

        Node a = new Node("a");
        Node d = new Node("d", c, e);
        Node i = new Node("i", h, null);

        Node b = new Node("b", a, d);
        Node g = new Node("g", null, i);

        Node f = new Node("f", b, g);
        tree = f;
    }

    @Test
    //http://en.wikipedia.org/wiki/File:Sorted_binary_tree_preorder.svg
    public void preOrder() {
        String preOrder = BinaryTreeTraverser.preOrder(tree);
        assertThat(preOrder).isEqualTo("fbadcegih");
    }

    @Test
    //http://en.wikipedia.org/wiki/File:Sorted_binary_tree_inorder.svg
    public void inOrder() {
        String inOrder = BinaryTreeTraverser.inOrder(tree);
        assertThat(inOrder).isEqualTo("abcdefghi");
    }

    @Test
    //http://en.wikipedia.org/wiki/File:Sorted_binary_tree_postorder.svg
    public void postOrder() {
        String postOrder = BinaryTreeTraverser.postOrder(tree);
        assertThat(postOrder).isEqualTo("acedbhigf");
    }
}
