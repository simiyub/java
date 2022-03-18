package graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FreeCodeCampCourseTest {
    private Map<Character, Character[]> graph;
    @BeforeEach
    void setUp() {
        Node a = new Node('a', new char[]{'b', 'c'});
         graph= new HashMap<>();
        graph.put('a',new Character[]{'b', 'c'});
        graph.put('b', new Character[]{'d'});
        graph.put('c', new Character[]{'e'});
        graph.put('d', new Character[]{'f'});
        graph.put('e', null);
        graph.put('f', null);
    }

    @Test
    void testDepthFirstSearchIterative() {
        assertArrayEquals(new Character[]{'a', 'c','e', 'b', 'd', 'f'}, FreeCodeCampCourse.depthFirstSearchIterative(graph, 'a'));
    }

    @Test
    void testDepthFirstSearchRecursive() {
        assertArrayEquals(new Character[]{'a', 'b', 'd', 'f', 'c','e'}, FreeCodeCampCourse.depthFirstSearchRecursive(graph, 'a'));
    }

    @Test
    void testBreadthFirstSearch() {

        assertArrayEquals(new Character[]{'a', 'b','c', 'd', 'e', 'f'}, FreeCodeCampCourse.breadthFirstSearch(graph, 'a'));
    }
}