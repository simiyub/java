package model;

public class PeopleType <K,V> implements Pair<K,V> {
    private final K typeName;
    private final V type;
    public PeopleType(K type, V personType) {
        typeName = type;
        this.type = personType;

    }

    @Override
    public K getKey() {
        return typeName;
    }

    @Override
    public V getValue() {
        return type;
    }
}
