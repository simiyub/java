import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

    @Test
    void search() {
        List<String> expected = List.of("A", "B", "C", "D", "E", "F","G","H", "I", "J","K");


        BreadthFirstSearch.Node nodeB = new BreadthFirstSearch.Node("B");
        BreadthFirstSearch.Node nodeF = new BreadthFirstSearch.Node("F");
        nodeF.children = List.of(new BreadthFirstSearch.Node("I"), new BreadthFirstSearch.Node("J"));
        nodeB.children =  List.of(new BreadthFirstSearch.Node("E"),nodeF);

        BreadthFirstSearch.Node nodeG = new BreadthFirstSearch.Node("G");
        nodeG.children = List.of(new BreadthFirstSearch.Node("K"));

        BreadthFirstSearch.Node nodeD = new BreadthFirstSearch.Node("D");
        nodeD.children = List.of(nodeG, new BreadthFirstSearch.Node("H"));

        BreadthFirstSearch.Node nodeA = new BreadthFirstSearch.Node("A");
        nodeA.children = List.of(nodeB,
                new BreadthFirstSearch.Node("C"),
                nodeD);
        assertEquals(expected,new BreadthFirstSearchImpl().search(nodeA));
    }
}