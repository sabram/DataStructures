package com.shaunabram.datastructures.graph.weighted;

import java.util.*;

//directed, weighted graph
public class Graph {

//    List<Node> nodes;
//    List<Edge> edges;
    Map<Node, List<Edge>> adjacencyList = new HashMap<>();
//
    public Graph(List<Node> nodes) {
        for (Node node : nodes) {
            if (adjacencyList.get(node)!=null) throw new RuntimeException("Node already exists: " + node);
            adjacencyList.put(node, new ArrayList<Edge>());
        }
//        this.edges = edges;
    }

    /**
     * Connect two nodes with an edge
     *
     * I think we should probably get rid of Node node
     * and just do
     * src = edge.getSource
     * destination = edge.getDestination()
     */
    public void addEdge(Node node, Edge edge) {
        if (!node.equals(edge.getSource())) throw new RuntimeException("source of Edge " + edge + " must equal source Node " + node);

        List<Edge> neighboursOfNode = adjacencyList.get(node);
        if (neighboursOfNode == null) throw new RuntimeException("Node " + node + " doesn't exist");
        if (!neighboursOfNode.contains(edge)) neighboursOfNode.add(edge);
    }


    public List<Node> shortestPath(Node source, Node destination) {
        Set<Node> visited = new HashSet<>();
        Set<Node> unvisited = new HashSet<>();
        unvisited.addAll(adjacencyList.keySet());
        Map<Node, Integer> distances = initDistances(unvisited);//distance from source to key
//        Map<Node, List<Node>> path = new HashMap<>();//path from source to key

        distances.put(source, 0);

        while (!unvisited.isEmpty()) {
            Node next = getSmallest(unvisited, distances);
            unvisited.remove(next);

            if (distances.get(next) == null) {
                break;
                // I don't fully understand this!
                // means all remaining vertices are inaccessible from source?
            }

            List<Edge> outgoingEdges = adjacencyList.get(next);
            for (Edge outgoingEdge : outgoingEdges) {
                Node neighbour = outgoingEdge.getDestination();
                int currentEstimatedShortestDistance = getShortestDistance(distances, neighbour);
                int newEstimatedShortestDistance =
                        getDistance(outgoingEdge) +
                        getShortestDistance(distances, next);
                if (currentEstimatedShortestDistance > newEstimatedShortestDistance) {
                    distances.put(neighbour, newEstimatedShortestDistance);
                    assert(next.equals(outgoingEdge.getSource()));
                    neighbour.setPredecessor(next);
                }
            }
            visited.add(next);
        }
        return getPath(destination);
    }

    public List<Node> getPath(Node destination) {
        Deque<Node> pathStack = new ArrayDeque<>();
        Node previous = destination;
        while (previous != null) {
            pathStack.push(previous);
            previous = previous.predecessor;
        }

        List<Node> path = new ArrayList<>();
        while (!pathStack.isEmpty()) {
            path.add(pathStack.pop());
        }
        return path;
    }


    private Map<Node, Integer> initDistances(Set<Node> nodes) {
        Map<Node, Integer> distances = new HashMap<>();
        for (Node node : nodes) {
            distances.put(node, Integer.MAX_VALUE);
        }
        return distances;
    }

    private int getShortestDistance(Map<Node, Integer> distances, Node next) {
        Integer distance = distances.get(next);
        return distance;
    }

    private int getDistance(Edge outgoingEdge) {
        Integer weight = outgoingEdge.getWeight();
        if (weight==null) {
            weight = Integer.MAX_VALUE;
        }
        return weight;
    }

    private Node getSmallest(Set<Node> unvisited, Map<Node, Integer> distances) {
        Node smallest = null;
        for (Node node : unvisited) {
            if (smallest==null) smallest=node;
            if (distances.get(node) < distances.get(smallest)) {
                smallest = node;
            }
        }
        return smallest;
    }
}
