package caching;

public class CacheImpl <K, V> implements Cache<K,V> {
    @Override
    public V get(K key) {
throw new UnsupportedOperationException();
    }

    @Override
    public void put(K key, V value) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean contains(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clean() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
