package model;

/**
 * This class implements the model.Pair interface to demonstrate how
 * we can use multiple type parameters in a class
 * */
public class PersonAttributes<K, V> implements Pair<K, V>{
    private final K key;
    private final V value;

    public PersonAttributes(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
