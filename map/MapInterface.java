import java.util.Map.Entry;

public interface MapInterface<K,V>{
    int size();
    //map'te bulunan entry sayısını döner

    boolean isEmpty();

    V get(K key);
    //key değerini içeren entry varsa value'yu döner
    //key değerini içeren entry yoksa null döner
    
    V put(K key, V value);
    //key değerini içeren entry varsa eski value'yu döner
    //key değerini içeren entry yoksa null döner

    V remove(K key);
    //key değerini içeren entry varsa value'yu döner
    //key değerini içeren entry yoksa null döner

    Iterable<Entry<K,V>> entries();
    
    Iterable<K> keys();

    Iterable<V> values();
}