import java.util.Map.Entry;

public interface MapInterface<K,V>{
    int size();
    //returns the number of entries in map

    boolean isEmpty();
    //returns a boolean indicating whether map is empty

    V get(K key);
    //if entry exists returns v
    //if entry does not exist returns null
    
    V put(K key, V value);
    //if map does not have an entry with k, it returns null
    //if map does have an entry with k, it returns old v

    V remove(K key);
    //if entry exists returns v
    //if entry does not exist returns null

    Iterable<Entry<K,V>> entries();
    //Returns an iterable collection containing all the key-value entries in map

    Iterable<K> keys();
    //Returns an iterable collection containing all the keys stored in map

    Iterable<V> values();
    //Returns an iterable collection containing all the values of entries stored in map
    //(with repetition if multiple keys map to the same value)
}