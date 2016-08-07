package com.shaunabram.datastructures.tree.binarytree;

import com.shaunabram.datastructures.tree.Node;

public abstract class BalancedBinaryTree {

    static int traversedNodeCount = 1;

    abstract public boolean isBalanced(Node node);

    abstract int getHeight(Node node);

}
