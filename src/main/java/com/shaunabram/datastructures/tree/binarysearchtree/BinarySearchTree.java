package com.shaunabram.datastructures.tree.binarysearchtree;

import com.shaunabram.datastructures.tree.IntNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    IntNode root;

    public IntNode getRoot() {
        return root;
    }

    public void add(Integer... nums) {
        for (Integer num : nums) {
            IntNode newNode = new IntNode(num);

            if (root==null) {
                root = newNode;
            } else {
                IntNode nextNode = root;
                IntNode parent = null;
                while (nextNode!=null) {
                    parent = nextNode;
                    if (nextNode.getValue() < num) {
                        nextNode = nextNode.getRight();
                    } else {
                        nextNode = nextNode.getLeft();
                    }
                }

                if (parent.getValue() < num) {
                   parent.setRight(newNode);
                } else {
                    parent.setLeft(newNode);
                }
            }
        }
    }

    public List<Integer> inOrder() {
        List<Integer> inOrder = new ArrayList<>();
        return inOrder(root, inOrder);
    }

    private List<Integer> inOrder(IntNode node, List<Integer> list) {
        if (node.getLeft() != null) {
            inOrder(node.getLeft(), list);
        }
        list.add(node.getValue());
        if (node.getRight() != null) {
            inOrder(node.getRight(), list);
        }
        return list;
    }

    public IntNode predecessor(Integer i) {
        return null;
    }
}
