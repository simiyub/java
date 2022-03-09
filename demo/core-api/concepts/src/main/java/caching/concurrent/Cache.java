package caching.concurrent;

/**
 * Consider these before choosing to use caching:
 * - The function to be cached is one of the most frequently called
 * - The value doesn't change regularly
 * - It takes relatively long to run the function
 * - It should be faster to get data from the cache than the data source we intend to cache from
 * - This in memory caching will increase the memory used.
 *   Consider alternative option if your application is memory intensive.

 *
 * Future enhancement for consideration:
 * Clean: updating the cache with new data
 * Necessary stats:
 * > Total load time: How long it took to put
 * > Eviction count: Number of entries removed
 * > Load success count: Number of times we successfully loaded data to the cache
 * > Load exception count: Number of exceptions thrown in put
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
     * would check if the cache contains an entry for a given key
     * */
    boolean contains(K key);

    /**
     * removes all entries from the cache
     * */
    void clear();

    /**
     * Provide the count of records, should be handy when we implement clean
     * */
    int  size();

}
