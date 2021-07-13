package caching;

/**
 * Cache record.
 * * Consider these stats:
 *  * Hit count: Number of lookups when get returned a value from the cache
 *  * Miss count: Number of lookups when get returned nothing and we had to make a new lookup and store in the cache
 * */
public class CacheRecord <V> {
    private final V value;

    public CacheRecord(V value) {
        
        this.value = value;
    }

    public V getValue() {
        return value;
    }
}
