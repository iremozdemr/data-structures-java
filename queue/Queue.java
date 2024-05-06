public class Queue<E> implements QueueInterface<E>{

    private int front; // Index of the front element
    private int size; // Current number of elements in the queue
    private int capacity; // Maximum capacity of the queue
    private E[] data; // Array to store queue elements

    // Default constructor with default capacity 25
    public Queue(){
        front = 0;
        size = 0;
        capacity = 25;
        data = (E[]) new Object[capacity];
    }

    // Constructor with a specified capacity
    public Queue(int capacity){
        front = 0;
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

    // Method to add an element to the queue
    public void enqueue(E element) throws Exception{
        if(size == capacity){
            throw new Exception("queue is full");
        }
        else{
            int index = (front + size) % capacity;
            data[index] = element;
            size++;
        }
    }
    // Explanation for circular queue implementation:
    // 'front' typically represents the starting point of the queue, while 'capacity' represents the length of the array.
    // The operation performed here shifts the 'front' index forward to determine the new starting point, thus creating a circular structure.
    // For instance, by setting 'front' index to the beginning of the queue, when an element is dequeued, 'front' is shifted forward.
    // This ensures that when the queue reaches the last element and needs to wrap around to the beginning (index 0),
    // the 'front' index cycles back to 0, enabling a circular structure without exceeding the queue's capacity.
    // This process optimizes memory utilization for circular queues, allowing continuous utilization of memory in a circular fashion
    // and preventing excessive memory consumption while traversing through the data structure.

    // Method to remove and return the front element from the queue
    public E dequeue(){
        if(isEmpty()){
            return null;
        }
        else{
            E element = data[front];
            data[front] = null;
            front = (front+1)%capacity;
            size--;
            return element;
        }
    }

    // Method to return the front element without removing it
    public E first(){
        if(isEmpty()){
            return null;
        }
        else{
            return data[front];
        }
    }

    public String toString(){
        String string = " ";
        if(isEmpty() == true){
            return string;
        }
        else{
            int index = front;
            for(int i = 0; i<size; i++){
                string = string + data[index] + " ";
                index = (index+1)%capacity;
            }
            return string;
        }
    }

    // Method to clear the queue by setting all elements to null and resetting the size to 0
    public void clear(){
        int index = front;
        for(int i = 0; i<size; i++){
            data[index] = null;
            index = (index+1)%capacity;
        }
        size = 0;
    }
}