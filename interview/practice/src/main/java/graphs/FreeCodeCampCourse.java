package graphs;

import java.util.*;

public class FreeCodeCampCourse {
    private final static List<Character> result = new ArrayList<>();
    public static Character[] depthFirstSearchIterative(Map<Character, Character[]> graph, Character start){
        Stack<Character> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()){
            Character current = stack.pop();
            System.out.println(current);
            result.add(current);
            Character[] neighbours = graph.get(current);
            if (neighbours!=null) {
                Arrays.stream(neighbours).forEach(stack::push);
            }

        }
        return result.toArray(new Character[0]);
    }


    public static Character[] depthFirstSearchRecursive(Map<Character, Character[]> graph, char start) {
        System.out.println(start);
        result.add(start);
        Character[] neighbours = graph.get(start);
        for (Character neighbour:neighbours){
            if(neighbour!=null) depthFirstSearchIterative(graph,neighbour);
        }
        return result.toArray(new Character[0]);
    }

    public static Character[] breadthFirstSearch(Map<Character, Character[]> graph, char start) {

        List<Character> results = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            Character current = queue.poll();
            System.out.println(current);
            results.add(current);
            Character[] neighbours = graph.get(current);
            if(neighbours!=null)  queue.addAll(Arrays.asList(neighbours));

        }
        return results.toArray(new Character[0]);
    }

    /**
     * Write a function, hasPath, that takes in an object representing the adjacency list of a
     * directed acyclic graph and two nodes (src, dst).
     * The function should return a boolean indicating if there exists a
     * directed path between the source and destination nodes.
     *
     * This is implemented using DFS here
     * Complexity
     * O(e) where e is edges as we will have to visit every node that the node directs to.
     * O(n) where n is the count of nodes as we will store up to n nodes on the stack or queue we work with.
     */
    public static boolean hasPathRecursive(Map<Character,Character[]> graph, Character start, Character destination){
        if (start.equals(destination)) return true;
        Character[] neighbours = graph.get(start);
        if(neighbours!=null && neighbours.length>0){
         for(Character neighbour:neighbours){
             if(hasPathRecursive(graph, neighbour,destination)) return true;
         }
        }
        return false;
    }

    /**
     * Write a function, hasPath, that takes in an object representing the adjacency list of a
     * directed acyclic graph and two nodes (src, dst).
     * The function should return a boolean indicating if there exists a
     * directed path between the source and destination nodes.
     *
     * This is implemented using BFS here
     * Complexity
     * O(e) where e is edges as we will have to visit every node that the node directs to.
     * O(n) where n is the count of nodes as we will store up to n nodes on the stack or queue we work with.
     */
    public static boolean hasPathIterative(Map<Character, Character[]> graph, Character start, Character destination){
        Queue<Character> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            char current = queue.poll();
            if(current ==destination) return true;
            Character[] neighbours = graph.get(current);
            if (neighbours!=null) queue.addAll(Arrays.asList(neighbours));
        }
        return false;

    }

    /**
     * Write a function, undirectedPath, that takes in an array of edges for an undirected graph
     * and two nodes (nodeA, nodeB).
     * The function should return a boolean indicating if there exists a path between nodeA and nodeB.
     *Convert the graph to an adjacency list first
     * This can be done using a Map
     * Graphs which are undirected can have a cycle. If we don't handle it, then we can end up with
     * an endless loop.
     * We handle this by marking the nodes as visited  for example using a set of visited nodes.
     * Complexity
     * Time O(e) and Space (n)
     */
    public static boolean hasPathUndirected(Character[][] edges, char start, char end){
        Map<Character, List<Character>> graph = buildGraph(edges);
        return hasPath(graph, start, end, new HashSet<>());
    }

    private static boolean hasPath(Map<Character, List<Character>> graph, char start, char end, Set<Character> visited) {
        if(visited.contains(start)) return false;
        if(start == end) return true;
        visited.add(start);
        List<Character> neighbours = graph.get(start);
        if(neighbours!=null) {
            for (char neighbour : neighbours) {
                if (hasPath(graph, neighbour, end, visited)) return true;
            }
        }
        return false;
    }

    private static Map<Character, List<Character>> buildGraph(Character[][] edges) {
        Map<Character, List<Character>> graph = new HashMap<>();
        for (Character[] edge:edges){
            if(edge!=null){
                if(graph.get(edge[0]) == null ) graph.put(edge[0], new ArrayList<>(List.of(edge[1])));
                else graph.get(edge[0]).add(edge[1]);

                if(graph.get(edge[1]) == null ) graph.put(edge[1], new ArrayList<>(List.of(edge[0])));
                else graph.get(edge[1]).add(edge[0]);
            }
        }
        return graph;
    }

    /**
     * Write a function, connectedComponentsCount,
     * that takes in the adjacency list of an undirected graph.
     * The function should return the number of connected components within the graph.
     * Complexity
     * Time - O(e)
     * Space - O(n) as we mark nodes as visited in a set
     * */

    public static int connectedComponentsCount(Map<Integer, Integer[]> graph){
        int count =0;
        Set<Integer> visited = new HashSet<>();
        for(Integer key: graph.keySet()) {
            if(explore(graph,key, visited)) count ++;
        }
        return count;
    }

    private static boolean explore(Map<Integer, Integer[]> graph, Integer node, Set<Integer> visited) {
        if (visited.contains(node)) return false;
        visited.add(node);
        for(Integer neighbour: graph.get(node)){
            explore(graph, neighbour, visited);
        }
        return true;
    }

    /**
     * Write a function, largestComponent, that takes in the adjacency list of an undirected graph.
     * The function should return the size of the largest connected component in the graph.
     * Time - O(e)
     * Space - O(n) as we mark nodes as visited in a set
     * */
    public static int largestComponent(Map<Integer, Integer[]> graph){
        Set<Integer> visited = new HashSet<>();
        int finalCount = 0;
        for(Integer node:graph.keySet()) {
            int newCount = exploreCount(node, graph, visited);
            if(newCount>finalCount) finalCount = newCount;
        }
        return finalCount;

    }

    private static int exploreCount(Integer node, Map<Integer, Integer[]> graph, Set<Integer> visited) {
        int visitedCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Integer current = queue.poll();
            if(!visited.contains(current)){
                visited.add(current);
                visitedCount ++;
                Integer[] neighbours = graph.get(current);
                if (neighbours!=null) Collections.addAll(queue, neighbours);
            }
        }
        return visitedCount;
    }

    /**
     * Write a function, shortestPath, that takes in an array of edges for an undirected graph
     * and two nodes (nodeA, nodeB).
     * The function should return the length of the shortest path between A and B.
     * Consider the length as the number of edges in the path, not the number of nodes.
     * If there is no path between A and B, then return -1.
     * */

    public static int shortestPath(Character[][] edges, char startChar, char endChar){
        //create graph
        //bfs over neighbours of start node,
        // checking for access to the end node through the neighbours
        //(each neighbour is a new path - restart)
        //compare the count of path to the end and return the shortest

        record Node(char id, int distance) {
        }
        Map<Character, List<Character>> graph = buildGraph(edges);
        Set<Character> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(startChar,0);
        queue.add(start);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            if(current.id==endChar) return current.distance;
            for(char neighbour: graph.get(current.id)){
                if(!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(new Node(neighbour, current.distance+1));
                }
            }
        }
        return -1;
    }

    /**
     * Write a function, islandCount, that takes in a grid containing Ws and Ls.
     * W represents water and L represents land.
     * The function should return the number of islands on the grid.
     * An island is a vertically or horizontally connected region of land.
     * */
    public static int islandCount(char[][] grid){

        Set<String> visited = new HashSet<>();
        int count = 0;
        for(int i=0;i<=grid.length-1;i++){
            System.out.println(Arrays.toString(grid[i]));
            for(int j=0;j<=grid[i].length-1;j++){
                    int size =0;
                    int neighbourLength = islandCountHelper(grid,i, j, size, visited);
                    if (neighbourLength > 0) count ++;
                }

        }
        return count;
    }

    private static int islandCountHelper(char[][] grid, int rowIndex, int columnIndex, int size, Set<String> visited) {
        boolean inbounds = (rowIndex >= 0 && rowIndex <= grid.length-1 && columnIndex>= 0 && columnIndex <= grid[rowIndex].length-1);

        if(inbounds && !visited.contains(rowIndex+"-"+columnIndex)) {
            visited.add(rowIndex + "-" + columnIndex);
            if (grid[rowIndex][columnIndex] == 'L') {
                size+=1;
                size = islandCountHelper(grid, rowIndex - 1, columnIndex, size, visited);
                size = islandCountHelper(grid, rowIndex + 1, columnIndex, size, visited);
                size = islandCountHelper(grid, rowIndex, columnIndex - 1, size, visited);
               size = islandCountHelper(grid, rowIndex, columnIndex + 1, size, visited);
                }
            }

        return size;
    }


}
