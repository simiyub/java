package operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IntermediateOperationTest {
    IntermediateOperation operations;
    Stream<String> simpleStringStream;
    Map<String, String> countriesByContinent;

    @BeforeEach
    void setUp() {
        operations = new IntermediateOperationImpl();
        simpleStringStream = Stream.of("one", "two");

        countriesByContinent = new HashMap<>();
        countriesByContinent.put("Afghanistan","Asia");
        countriesByContinent.put("Albania","Europe");
        countriesByContinent.put("Argentina","South America");
        countriesByContinent.put("Australia","Oceania");
        countriesByContinent.put("Austria","Europe");
        countriesByContinent.put("Bahamas","North America");
        countriesByContinent.put("Bermuda","North America");
        countriesByContinent.put("Cameroon","Africa");
        countriesByContinent.put("Colombia","South America");
        countriesByContinent.put("Cyprus","Asia");
    }

    private boolean isInContinent(String country, String continentWanted){
        return countriesByContinent.get(country).equalsIgnoreCase(continentWanted);
    }

    @Test
    void filter() {



        assertEquals(
                2,
                operations.filter(countriesByContinent.entrySet().stream(), "Asia")
                        .count()
        );
    }

    @Test
    void map() {
        Map<String, String> countriesMapped
                = countriesByContinent.entrySet().stream().collect(Collectors.toMap(Map::entry.);
        assertNotNull(operations.map(countriesByContinent.entrySet().stream()));
    }

    @Test
    void flatMap() {
        assertNotNull(operations.flatMap(simpleStringStream));
    }

    @Test
    void distinct() {
        assertNotNull(operations.distinct(simpleStringStream));
    }

    @Test
    void sorted() {
        assertNotNull(operations.sorted(simpleStringStream));
    }

    @Test
    void peek() {
        assertNotNull(operations.peek(simpleStringStream));
    }

    @Test
    void limit() {
        assertNotNull(operations.limit(simpleStringStream));
    }

    @Test
    void skip() {
        assertNotNull(operations.skip(simpleStringStream));
    }
}