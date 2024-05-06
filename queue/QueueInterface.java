public interface QueueInterface<E>{
    
    int size();
    boolean isEmpty();
    void enqueue(E element) throws Exception;
    E dequeue();
    E first();
    String toString();
    void clear();
}
