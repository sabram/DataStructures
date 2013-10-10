Question: Given a graph G, determine if the graph is connected.

For example:
A--B--C
   |
   |--D
is connected.

A--B--C

D--E
is not.

First question is how to store a graph.
Assume an adjacency list for now.

Adjacency list for first graph would be
A -> B
B -> A -> C -> D
C -> B
D -> B

Adjacency list for second graph would be
A -> B
B -> A -> C
C -> B
D -> E

How to implement an Adjacent list in Java?
Possibilities:
Array, with each array containing a List (also need a map of Node, or Node value, to the corresponding array index)
List of Lists (also need a map of Node, or Node value, to the corresponding list index)
Map of Node, or Node value, to a list of connected nodes.



