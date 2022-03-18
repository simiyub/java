package graphs;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FreeCodeCampCourseTest {

    @Test
    void depthFirstSearch() {
        Node a = new Node('a', new char[]{'b', 'c'});
        Map<Character, Character[]> graph = new HashMap<>();
        graph.put('a',new Character[]{'b', 'c'});
        graph.put('b', new Character[]{'d'});
        graph.put('c', new Character[]{'e'});
        graph.put('d', new Character[]{'f'});
        graph.put('e', null);
        graph.put('f', null);
//        assertArrayEquals(new Character[]{'a', 'c','e', 'b', 'd', 'f'}, FreeCodeCampCourse.depthFirstSearchIterative(graph, 'a'));
        assertArrayEquals(new Character[]{'a', 'c','e', 'b', 'd', 'f'}, FreeCodeCampCourse.depthFirstSearchRecursive(graph, 'a'));
    }
}