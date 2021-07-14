package caching.concurrent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    Cache<String,Integer> cache;


    @BeforeEach
    void setUp() {
        cache = new CacheImpl<>(callback -> mockValue());

    }

    @Test
    void getPresent() {
        String key = "getPresent";
        Integer value = 1;
        assertDoesNotThrow(() -> cache.put(key,value));
        assertEquals(value, cache.get(key));
    }

    Integer mockValue(){
        return -1;
    }

    @Test
    void getAbsent() {
        String key = "getAbsent";
        Integer value = mockValue();
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
    void size() {
        String key = "size";
        Integer value = 4;
        cache.put(key,value);
        assertEquals(1,cache.size());
    }

    @Test
    void clear() {
        String key = "put";
        Integer value = 4;
        cache.put(key,value);
        cache.clear();
        assertEquals(0,cache.size());
    }
}