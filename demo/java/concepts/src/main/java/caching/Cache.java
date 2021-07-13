package caching;

/**
 * Consider these before choosing to use caching:
 * - The function to be cached is one of the most frequently called
 * - The value doesn't change regularly
 * - It takes relatively long to run the function
 * - It should be faster to get data from the cache than the data source we intend to cache from
 * - This in memory caching will increase the memory used.
 *   Consider alternative option if your application is memory intensive.

 *
 * Consider these stats:
 * Hit count: Number of look-ups encountered when object found
 * Miss count: Number of look-ups encountered when object not found
 * Load success count: Number of successfully loaded entries
 * Total load time: Total time in loading an element
 * Load exception count: Number of exceptions thrown while loading an entry
 * Eviction count: Number of entries evicted from the cache
 * */

public interface Cache <K,V> {

    /**
     *  * retrieves a value stored in the cache for a given key
     * */
    V get(K key);

    /**
     * stores a new value for a given key
     * */
    void put(K key, V value);

    /**
     * checks if the cache contains an entry for a given key
     * */
    boolean contains(K key);

    /**
     * removes a value for a given key
     * */
    void remove(K key);

    /**
     * removes expired cache entries.
     * */
    void clean();

    /**
     * removes all entries from the cache
     * */
    void clear();

}
