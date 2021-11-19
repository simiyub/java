package real.caching;

public interface Cache<K, V> {

    V get(K key);
}
