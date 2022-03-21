package graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FreeCodeCampCourseTest {
    private Map<Character, Character[]> conceptGraph;
    @BeforeEach
    void setUp() {
        conceptGraph = new HashMap<>();
        conceptGraph.put('a',new Character[]{'b', 'c'});
        conceptGraph.put('b', new Character[]{'d'});
        conceptGraph.put('c', new Character[]{'e'});
        conceptGraph.put('d', new Character[]{'f'});
        conceptGraph.put('e', null);
        conceptGraph.put('f', null);


    }

//    @Test
//    void testDepthFirstSearchIterative() {
//
//        assertArrayEquals(new Character[]{'a', 'c','e', 'b', 'd', 'f'}, FreeCodeCampCourse.depthFirstSearchIterative(conceptGraph, 'a'));
//    }

    @Test
    void testDepthFirstSearchRecursive() {
        assertArrayEquals(new Character[]{'a', 'b', 'd', 'f', 'c','e'}, FreeCodeCampCourse.depthFirstSearchRecursive(conceptGraph, 'a'));
    }

    @Test
    void testBreadthFirstSearch() {

        assertArrayEquals(new Character[]{'a', 'b','c', 'd', 'e', 'f'}, FreeCodeCampCourse.breadthFirstSearch(conceptGraph, 'a'));
    }

    @Test
    void testHasPathRecursive(){

        Map<Character, Character[]> graph = new HashMap<>();
        graph.put('f', new Character[]{'g', 'i'});
        graph.put('g', new Character[]{'h'});
        graph.put('h', new Character[0]);
        graph.put('i', new Character[]{'g', 'k'});
        graph.put('j', new Character[]{'i'});
        graph.put('k', new Character[0]);
        assertTrue(FreeCodeCampCourse.hasPathRecursive(graph, 'f', 'k'));
    }

    @Test
    void testHasPathIterative(){

        Map<Character, Character[]> graph = new HashMap<>();
        graph.put('f', new Character[]{'g', 'i'});
        graph.put('g', new Character[]{'h'});
        graph.put('h', new Character[0]);
        graph.put('i', new Character[]{'g', 'k'});
        graph.put('j', new Character[]{'i'});
        graph.put('k', new Character[0]);
        assertTrue(FreeCodeCampCourse.hasPathIterative(graph, 'f', 'k'));
    }

    @Test
    void testHasPathUndirected(){

        Character[][] graph = new Character[][]{
                new Character[]{'i', 'j'},
                new Character[]{'k', 'i'},
                new Character[]{'m', 'k'},
                new Character[]{'k', 'l'},
                new Character[]{'o', 'n'}};
        assertTrue(FreeCodeCampCourse.hasPathUndirected(graph, 'j', 'm'));
    }

    @Test
    void testConnectedComponentsCount(){
        Map<Integer,Integer[]> graph = new HashMap<>();
        graph.put(0,new Integer[]{8, 1, 5});
        graph.put(1,new Integer[]{0});
        graph.put(5, new Integer[]{0, 8});
        graph.put(8, new Integer[]{0, 5});
        graph.put(2, new Integer[]{3, 4});
        graph.put(3, new Integer[]{2, 4});
        graph.put(4, new Integer[]{3, 2});
        assertEquals(2, FreeCodeCampCourse.connectedComponentsCount(graph));
    }

    @Test
    void largestComponent(){
        Map<Integer,Integer[]> graph = new HashMap<>();
        graph.put(0,new Integer[]{8, 1, 5});
        graph.put(1,new Integer[]{0});
        graph.put(5, new Integer[]{0, 8});
        graph.put(8, new Integer[]{0, 5});
        graph.put(2, new Integer[]{3, 4});
        graph.put(3, new Integer[]{2, 4});
        graph.put(4, new Integer[]{3, 2});
        assertEquals(4, FreeCodeCampCourse.largestComponent(graph));
    }

    @Test
    void testShortestPath(){

        Character[][] edges = new Character[][]{
                new Character[]{'w', 'x'},
                new Character[]{'x', 'y'},
                new Character[]{'z', 'y'},
                new Character[]{'z', 'v'},
                new Character[]{'w', 'v'}};
        assertEquals(2, FreeCodeCampCourse.shortestPath(edges,'w', 'z'));
    }
    
    @Test 
    void testIslandCount1(){
        char[][] grid1 = new char[][]{
                new char[]{'W', 'L', 'W', 'W', 'W'},
                new char[]{'W', 'L', 'W', 'W', 'W'},
                new char[]{'W', 'W', 'W', 'L', 'W'},
                new char[]{'W', 'W', 'L', 'L', 'W'},
                new char[]{'L', 'W', 'W', 'L', 'L'},
                new char[]{'L', 'L', 'W', 'W', 'W'},
        };
        assertEquals(3, FreeCodeCampCourse.islandCount(grid1));

    }

    @Test
    void testIslandCount2(){
        char[][] grid2 = new char[][]{
                new char[]{'L', 'W', 'W', 'L', 'W'},
                new char[]{'L', 'W', 'W', 'L', 'L'},
                new char[]{'W', 'L', 'W', 'L', 'W'},
                new char[]{'W', 'W', 'W', 'W', 'W'},
                new char[]{'W', 'W', 'L', 'L', 'L'}
        };
        assertEquals(4, FreeCodeCampCourse.islandCount(grid2));

    }

    @Test
    void testIslandCount3(){
        char[][] grid3 = new char[][]{
                new char[]{'L', 'L', 'L'},
                new char[]{'L', 'L', 'L'},
                new char[]{'L', 'L', 'L'}
        };
        assertEquals(1, FreeCodeCampCourse.islandCount(grid3));
    }

    @Test
    void testIslandCount4(){

        char[][] grid4 = new char[][]{
                new char[]{'W', 'W'},
                new char[]{'W', 'W'},
                new char[]{'W', 'W'}
        };
        assertEquals(0, FreeCodeCampCourse.islandCount(grid4));
    }

}