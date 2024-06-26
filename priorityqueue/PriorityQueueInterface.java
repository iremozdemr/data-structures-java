public interface PriorityQueueInterface<K,V>{

    int size();

    boolean isEmpty();

    Entry<K,V> insert(K key,V value) throws IllegalArgumentException;

    Entry<K,V> min();
    //pq boşsa null döner

    Entry<K,V> removeMin();
    //pq boşsa null döner
}