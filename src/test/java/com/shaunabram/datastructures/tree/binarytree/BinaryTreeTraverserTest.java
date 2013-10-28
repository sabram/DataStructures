package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.StrNode;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BinaryTreeTraverserTest {

    StrNode tree;

    @Before
    public void setup() {
        StrNode c = new StrNode("c");
        StrNode e = new StrNode("e");
        StrNode h = new StrNode("h");

        StrNode a = new StrNode("a");
        StrNode d = new StrNode("d", c, e);
        StrNode i = new StrNode("i", h, null);

        StrNode b = new StrNode("b", a, d);
        StrNode g = new StrNode("g", null, i);

        StrNode f = new StrNode("f", b, g);
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
