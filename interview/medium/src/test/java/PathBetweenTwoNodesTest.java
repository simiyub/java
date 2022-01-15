import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathBetweenTwoNodesTest {

    @Test
    void testFindPath(){
        String expected ="DAFE";
        String start="D";
        String end = "E";
        assertEquals(expected, new PathBetweenTwoNodesImpl().findPath(start, end));
    }
}