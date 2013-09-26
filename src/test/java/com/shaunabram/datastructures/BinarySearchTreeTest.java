package com.shaunabram.datastructures;

import com.shaunabram.datastructures.binarysearchtree.BinarySearchTree;
import com.shaunabram.datastructures.binarysearchtree.Node;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

public class BinarySearchTreeTest {

    @Test
    public void add_simple_unbalanced() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(1,2,3);
        Node root = bst.getRoot();
        assertThat(root.getLeft()).isNull();
        assertThat(root.getRight().getValue()).isEqualTo(2);
        assertThat(root.getRight().getLeft()).isNull();
        assertThat(root.getRight().getRight().getValue()).isEqualTo(3);
    }

    @Test
    public void add_simple_balanced() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(2,1,3);
        Node root = bst.getRoot();
        assertThat(root.getValue()).isEqualTo(2);
        assertThat(root.getLeft().getValue()).isEqualTo(1);
        assertThat(root.getRight().getValue()).isEqualTo(3);
    }

    @Test
    public void inOrder() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(8,1,7,6,4,2,5,3);
        List<Integer> inOrder = bst.inOrder();
        List<Integer> expected = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(inOrder).isEqualTo(expected);
    }

    @Test
    public void predecessor() {
        fail();
    }

    @Test
    public void delete() {
        fail();
    }

//    @Test
//    public void select() {
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.add(1,4,2,3);
//        for (int i=1; i<=4; i++) {
//            Node node = bst.select(i);
//            assertThat(node.getValue()).isEqualTo(i);
//        }
//    }
//
//    @Test
//    public void select2() {
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.add(2,8,4,6);
//        for (int i=1; i<=4; i++) {
//            Node node = bst.select(i);
//            assertThat(node.getValue()).isEqualTo(i*2);
//        }
//    }
//
//    @Test
//    public void select3() {
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.add(8,1,7,6,4,2,5,3);
//        for (int i=1; i<=8; i++) {
//            Node node = bst.select(i);
//            assertThat(node.getValue()).isEqualTo(i);
//        }
//    }
//
//    @Test
//    public void rank() {
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.add(1,4,2,3);
//        int expectedRank = 4;
//        for (int i=1; i<=4; i++) {
//            Node node = bst.rank(i);
//            assertThat(node.getValue()).isEqualTo(expectedRank--);
//        }
//    }
}
