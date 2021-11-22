package caching;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


/**
 * In memory implementation of Cache.
 * Currently only supports put and get
 *  * */

public class CacheImpl <K, V> implements Cache<K,V> {

    private final Map<K,CacheRecord<V>> cache;
    private Function<K,V> callback;

    public CacheImpl() {
        cache = new HashMap<>();
    }

    public CacheImpl(Function<K,V> callback) {
        this.callback = callback;
        cache = new HashMap<>();
    }



    CacheRecord<V> createRecordSafely(K key){

        try{
            V value = callback.apply(key);
            return new CacheRecord<>(value);
        }
        catch (RuntimeException exception){
            exception.printStackTrace();
        }
        return null;
    }

    Function<K,CacheRecord<V>> createRecord = this::createRecordSafely;

    @Override
    public V get(K key) {
        return cache.computeIfAbsent(key, createRecord).getValue();
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, new CacheRecord<>(value));

    }

    @Override
    public boolean contains(K key) {
        return cache.containsKey(key);
    }

    @Override
    public V remove(K key) {
        return cache.containsKey(key) ? cache.remove(key).getValue() : null;
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public int size() {
        return cache.size();
    }
}
