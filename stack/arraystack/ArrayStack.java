//size() O(1)
//isEmpty() O(1)
//top() O(1)
//push() O(1)
//pop() O(1)

//the space usage is O(N)
//N = size of the array

public class ArrayStack<E> implements StackInterface<E>{

    private int capacity;
    private int t;
    //top element'in indexi
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayStack(){
        t = -1;
        capacity = 1000;
        data = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity){
        t = -1;
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return t+1;
    }

    public boolean isEmpty() {
        if(t == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public E top() {
        if(isEmpty()){
            return null;
        }
        else{
            return data[t];
        }
    }

    public void push(E element) {
        if(capacity == size()){
            throw new IllegalStateException("stack is full");
        }
        else{
            t++;
            data[t] = element;
        }
    }

    public E pop() {
        if(isEmpty()){
            return null;
        }
        else{
            E element = data[t];
            data[t] = null;
            t--;
            return element;
        }
    }
}