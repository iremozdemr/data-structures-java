public interface CircularQueueInterface<E> extends QueueInterface<E>{

    int size();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E first();
    
    void rotate();
    //rotates the front element of the queue to the back of the queue.
    //this does nothing if the queue is empty
}