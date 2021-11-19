
/**
 * A hash table organizes data
 * so you can quickly look up values for a given key.
*           Average	    Worst Case
 * space	O(n)O(n)	O(n)O(n)
 * insert	O(1)O(1)	O(n)O(n)
 * lookup	O(1)O(1)	O(n)O(n)
 * delete	O(1)O(1)	O(n)O(n)
* **/

public class HashTableDemo<K,V> {
    private final HashEntry<K,V>[] entries;

    HashTableDemo(int size){
        entries = new HashEntry[size];

    }

    private static class HashEntry<K,V>{
        private final K key;
        private final V value;
        private HashEntry<K,V> next;

        HashEntry(K k, V v){
            this.key = k;
            this.value = v;
            this.next = null;

        }

    }
    public boolean put(K key, V value){
        final int index = entryHash(key);
        HashEntry<K,V> entry = new HashEntry(index,value);
        if(entries[index] == null){
            entries[index] = entry;
        }
        else{
            handleCollision(index,entry);
        }
        return true;
    }

    public V get(K key){
        HashEntry<K,V> found = entries[entryHash(key)];
        return (found !=null) ? found.value :null;

    }

    private void handleCollision(int index, HashEntry<K,V> addEntry) {
        HashEntry<K,V> checkEntry = entries[index];
        while ( checkEntry.next != null){
            checkEntry = checkEntry.next;
        }
        checkEntry.next = addEntry;
    }

    private int entryHash(K key) {
        return Math.abs(key.hashCode()%entries.length);
    }

}
