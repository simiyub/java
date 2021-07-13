package caching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    Cache<String,Integer> cache;


    @BeforeEach
    void setUp() {
        cache = new CacheImpl <>();

    }

    @Test
    void get() {
        String key = "one";
        Integer value = 1;
        assertEquals(value, cache.get(key));
    }

    @Test
    void put() {
        String key = "put";
        Integer value = 2;
        assertDoesNotThrow(() -> cache.put(key,value));
        assertEquals(value, cache.get(key));
    }

    @Test
    void contains() {

        String key = "contains";
        Integer value = 3;
        cache.put(key,value);
        assertTrue(cache.contains(key));
    }

    @Test
    void remove() {
        String key = "remove";
        Integer value = 4;
        cache.remove(key);
        assertFalse(cache.contains(key));
    }

 /**
  * To be implemented: checks cleaning works.
  * */
    @Test
    void clean() {
        String key = "put";
        Integer value = 5;
        assertDoesNotThrow(() ->cache.clean());
    }

    /**
     * To be implemented: checks we can clear the cache.
     * */
    @Test
    void clear() {
        String key = "put";
        Integer value = 6;
        assertDoesNotThrow(() -> cache.clear());
    }
}