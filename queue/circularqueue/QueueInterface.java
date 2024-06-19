public interface QueueInterface<E>{
    
    int size();

    boolean isEmpty();

    void enqueue(E element);

    E dequeue();
    //queue boşsa null döner

    E first();
    //queue boşsa null döner
}