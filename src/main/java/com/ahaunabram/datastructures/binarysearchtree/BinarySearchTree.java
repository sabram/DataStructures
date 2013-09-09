package com.ahaunabram.datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    Node root;

    public Node getRoot() {
        return root;
    }

    public void add(Integer... nums) {
        for (Integer num : nums) {
            Node newNode = new Node(num);

            if (root==null) {
                root = newNode;
            } else {
                Node nextNode = root;
                Node parent = null;
                while (nextNode!=null) {
                    parent = nextNode;
                    if (nextNode.value < num) {
                        nextNode = nextNode.right;
                    } else {
                        nextNode = nextNode.left;
                    }
                }

                if (parent.value < num) {
                   parent.right = newNode;
                } else {
                    parent.left = newNode;
                }
            }
        }
    }

    public List<Integer> inOrder() {
        List<Integer> inOrder = new ArrayList<>();
        return inOrder(root, inOrder);
    }

    private List<Integer> inOrder(Node node, List<Integer> list) {
        if (node.getLeft() != null) {
            inOrder(node.getLeft(), list);
        }
        list.add(node.getValue());
        if (node.getRight() != null) {
            inOrder(node.getRight(), list);
        }
        return list;
    }
}
