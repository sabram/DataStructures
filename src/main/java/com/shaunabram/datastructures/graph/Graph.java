package com.shaunabram.datastructures.graph;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

import static com.shaunabram.datastructures.graph.Node.Color.*;

public class Graph implements IGraph {
    /**
     * Our graph is stored as an adjacency list - A collection of all the Nodes where
     * each node is associated with a list of all its edges
     */
    Map<Node, List<Node>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    @Override
    public void addNode(Node v) {
        if (adjacencyList.containsKey(v)) throw new RuntimeException("Node already exists in graph");
        adjacencyList.put(v, new ArrayList<Node>());
    }

    @Override
    /**
     * Connect two nodes with an edge
     */
    public void addEdge(Node v1, Node v2) {
        List<Node> neighboursOfv1 = adjacencyList.get(v1);
        if (neighboursOfv1 == null) throw new RuntimeException("Node " + v1 + " doesn't exist");
        if (!neighboursOfv1.contains(v2)) neighboursOfv1.add(v2);

        List<Node> neighboursOfv2 = adjacencyList.get(v2);
        if (neighboursOfv2 == null) throw new RuntimeException("Node " + v2 + " doesn't exist");
        if (!neighboursOfv2.contains(v1)) neighboursOfv2.add(v1);
    }

    @Override
    /**
     * Determines if 2 nodes have a direct connection
     */
    public boolean hasEdge(Node v1, Node v2) {
        //get linked list for v1
        List<Node> neighbours = adjacencyList.get(v1);
        if (neighbours == null) return false;
        //return true if v2 found in n1's neighbours
        return neighbours.contains(v2);
    }

    @Override
    public List<Node> getShortestPath(Node source, Node destination) {

        //start initialization
        /**
         * if (parents.get(A) = B, then B is a parent of A.
         */
        Map<Node, Node> parents = new HashMap<>();

        /**
         * Each Integer represents the distance from source to each Node
         */
        Map<Node, Integer> distances = Maps.newHashMap();
        for (Node node : adjacencyList.keySet()) {
            distances.put(node, null);
        }
        distances.put(source, 0);
        //end initialization

        //we track which nodes have been explored by using a boolean in Node itself.
        source.setExplored(true);
        Queue<Node> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            Node v = q.poll();

            //here, can do 'process v early'

            List<Node> neighouringNodes = adjacencyList.get(v);
            for (Node neighouringNode : neighouringNodes) {
                if (!neighouringNode.isExplored()) {
                    neighouringNode.setExplored(true);
                    parents.put(neighouringNode, v);
                    q.add(neighouringNode);
                    Integer distance = distances.get(v) + 1;
                    distances.put(neighouringNode, distance);
                }
            }

            //here, can do 'process v late'

        }

        return getPath(source, destination, parents);
    }

    //Given a map of each node to it's parent, finds the path from source to destination
    private List<Node> getPath(Node source, Node destination, Map<Node, Node> parents) {
        Deque<Node> reversePath = getReversePath(source, destination, parents);
        List<Node> path = getPath(reversePath);
        displayPath(source, destination, path);
        return path;
    }

    //Get path from destination -> source
    //Since this is effectively backwards (we want source -> destination)
    //we store it in a stack for easy reversal later.
    private Deque<Node> getReversePath(Node source, Node destination, Map<Node, Node> parents) {
        Deque<Node> stack = new ArrayDeque<>();
        Node next = destination;
        stack.addFirst(next);
        while (next != source) {
            next = parents.get(next);
            stack.addFirst(next);
        }
        return stack;
    }

    //just reverses the stack into a list
    private List<Node> getPath(Deque<Node> stack) {
        List<Node> path = Lists.newArrayList();
        int size = stack.size();
        for (int i=0; i<size; i++) {
            Node node = stack.removeFirst();
            path.add(node);
        }
        return path;
    }

    private void displayPath(Node source, Node destination, List<Node> path) {
        System.out.printf("Shortest path from %s to %s is %d hops: ", source.getValue(), destination.getValue(), path.size() - 1);
        for (Node node : path) {
            System.out.print(node.getValue());
        }
        System.out.print("\n");
    }

    public List<Node> bfs(Node s) {
        List<Node> bfs = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        s.setColor(GREY);
        q.add(s);
        bfs.add(s);
        while(!q.isEmpty()) {
            Node node = q.poll();
            List<Node> adjacentNodes = adjacencyList.get(node);
            for (Node a : adjacentNodes) {
                if (a.getColor() == WHITE) {
                    a.setColor(GREY);
                    q.offer(a);
                    bfs.add(a);
                }
            }
            node.setColor(BLACK);
        }
        return bfs;
    }
}
