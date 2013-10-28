package com.shaunabram.datastructures.graph.dfs;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {

    public static List<Node> dfs(Node node) {
        List<Node> dfsTree = new ArrayList<>();
        if (node == null) return null;
        List<Node> children = node.getChildren();
        dfsTree.add(node);

        if (children != null && children.size()>=0) {
            for (Node child : children) {
                List<Node> subTree = dfs(child);
                Collections.sort(subTree);
                dfsTree.addAll(subTree);
            }
        }
        return dfsTree;
    }
}
