package graphs;

import java.util.*;

public class FreeCodeCampCourse {
    private static List<Character> result = new ArrayList<>();
    public static Character[] depthFirstSearchIterative(Map<Character, Character[]> graph, Character start){
        Stack<Character> stack = new Stack();
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
        return result.toArray(new Character[result.size()]);
    }


    public static Character[] depthFirstSearchRecursive(Map<Character, Character[]> graph, char start) {
        System.out.println(start);
        result.add(start);
        Character[] neighbours = graph.get(start);
        for (Character neighbour:neighbours){
            if(neighbour!=null) depthFirstSearchIterative(graph,neighbour);
        }
        return result.toArray(new Character[result.size()]);
    }
}
