package com.shaunabram.datastructures.graph.weighted;

import java.util.*;

//directed, weighted graph
public class Graph {

    Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public Graph(List<Node> nodes) {
        for (Node node : nodes) {
            if (adjacencyList.get(node)!=null) throw new RuntimeException("Node already exists: " + node);
            adjacencyList.put(node, new ArrayList<Edge>());
        }
    }

    /**
     * Connect two nodes with an edge
     *
     * I think we should probably get rid of Node node
     * and just do
     * src = edge.getSource
     * destination = edge.getDestination()
     */
    public void addEdge(Edge edge) {
        Node source = edge.getSource();
        List<Edge> neighboursOfSource = adjacencyList.get(source);
        if (neighboursOfSource == null) throw new RuntimeException("Node " + source + " doesn't exist");
        if (!neighboursOfSource.contains(edge)) neighboursOfSource.add(edge);
    }


    public List<Node> shortestPath(Node source, Node destination) {
        Set<Node> visited = new HashSet<>();
        Set<Node> unvisited = new HashSet<>();
        unvisited.addAll(adjacencyList.keySet());
        Map<Node, Integer> distances = initDistances(unvisited);//distance from source to key

        distances.put(source, 0);

        while (!unvisited.isEmpty()) {
            Node next = getSmallest(unvisited, distances);
            unvisited.remove(next);

            Integer d = distances.get(next);
            if (d == null || d == Integer.MAX_VALUE) {
                break;//all remaining vertices are inaccessible from source?
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
        List<Node> path = getPath(destination);
        if (!path.get(0).equals(source) || !path.get(path.size()-1).equals(destination)) {
            throw new RuntimeException("Unable to find a path!");
        }
        return path;
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
