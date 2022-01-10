Most common algorithm interview question topics.
================================================
1. Depth first search and Breadth first search algorithms.

Concept
-------
Both depth first search and breadth first search help us to find relationships.
Relationships exist in graphs which can be used to provide recommendations of products to a client.

Depth first search
When to use it: When we need to do exhaustive searches and all paths. Goes deep into a path.
Time complexity: O(v+e) T and O(n) S where
v is the vertex/node and e is the edge - connecting the vertices/nodes.
The edge can be a follow or a friendship on social media.
A follow is one direction while the friendship is undirected and goes both ways.
Representation: A graph can be represented as a two-dimensional array. However, this has a quadratic
time complexity.
An adjacency list is a better alternative, where each element in the list has a list of its connections.
Implementation: The implementation we use here
uses a stack to process the nodes in LIFO order and a set of seen items.
We first add the node we have been provided onto the stack.
Then we start processing nodes that are on the stack in a while loop as follows:
  - If the node has not been seen, we add to the seen set
  - We process the node e.g. print out or add to an array.
  - We then add the adjacent nodes to the stack.



Breadth first search
We use breadth first search to help us determine the quickest path to a node. We go level by level down.
We use a queue to implement it.
Implementation: The implementation we use here
uses a queue to process the nodes in FIFO order the process is similar to the Depth first search.