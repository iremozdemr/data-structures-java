//size() O(1)
//isEmpty() O(1)
//enqueue() O(1)
//dequeue() O(1)
//first() O(1)

public class ArrayQueue<E> implements QueueInterface<E>{

    private int f;
    private int size;
    private int capacity;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayQueue(){
        f = 0;
        size = 0;
        capacity = 1000;
        data = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity){
        f = 0;
        size = 0;
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void enqueue(E element){
        if(size == data.length){
            throw new IllegalStateException("queue is full");
        }
        else{
            int index = (f + size) % data.length;
            data[index] = element;
            size++;
        }
    }

    public E dequeue(){
        if(isEmpty()){
            return null;
        }
        else{
            E element = data[f];
            data[f] = null;
            f = (f + 1) % data.length;
            size--;
            return element;
        }
    }

    public E first(){
        if(isEmpty()){
            return null;
        }
        else{
            return data[f];
        }
    }
}