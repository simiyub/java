package caching.concurrent;

import java.util.concurrent.*;
import java.util.function.Function;


/**
 * In memory implementation of Cache.
 * Currently only supports put and get
 * May support clean function below in future if requested as considered essential.
 * clean
 *
 *  * Eviction count: Number of entries removed
 *  * */

public class CacheImpl <K, V> implements Cache<K,V> {

    private final ConcurrentMap<K, Future<V>> cache = new ConcurrentHashMap<>();
    private final Function<K,V> callback;

    public CacheImpl(Function<K,V> callback) {
        this.callback = callback;
    }



    Future<V> createRecordSafely(final K key, final Callable<V> callable) {

        Future<V> record = cache.get(key);

            if (record == null) {
                final FutureTask<V> task = new FutureTask<>(callable);
                record = cache.putIfAbsent(key, task);
                if(record == null){
                    record = task;
                    task.run();
                }
            }
            return record;
    }

    @Override
    public V get(K key){
        V value = null;
        try {
            Future<V> record = createRecordSafely(key, () ->callback.apply(key));
            value = record.get();
        }
        catch (RuntimeException|InterruptedException|ExecutionException exception) {
            exception.printStackTrace();
        }
        return value;
    }

    @Override
    public void put(final K key, final V value) {
            createRecordSafely(key, () -> value);
    }

    @Override
    public boolean contains(K key) {
        return cache.containsKey(key);
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
