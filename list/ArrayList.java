//size() O(1)
//isEmpty() O(1)
//get() O(1)
//set() O(1)
//add() O(n)
//remove() O(n)

public class ArrayList<E> implements ListInterface<E>{

    private int size;
    private int capacity;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayList(){
        size = 0;
        capacity = 1000;
        data = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity){
        size = 0;
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException{
        if(i<0){
            throw new IndexOutOfBoundsException();
        }
        else if(i >= size){
            throw new IndexOutOfBoundsException();
        }
        else{
            return data[i];
        }
    }

    public E set(int i,E element) throws IndexOutOfBoundsException{
        if(i<0){
            throw new IndexOutOfBoundsException();
        }
        else if(i >= size){
            throw new IndexOutOfBoundsException();
        }
        else{
            E result = data[i];
            data[i] = element;
            return result;
        }
    }

    public void add(int i,E element) throws IndexOutOfBoundsException, IllegalStateException{
        if(i<0){
            throw new IndexOutOfBoundsException();
        }
        else if(i >= size){
            throw new IndexOutOfBoundsException();
        }
        else if(size == data.length){
            throw new IllegalStateException();
        }
        else{
            for(int j=size-1; j>=i; j--){
                data[j+1] = data[j];
            }
            data[i] = element;
            size++;
        }
    }

    public E remove(int i) throws IndexOutOfBoundsException{
        if(i<0){
            throw new IndexOutOfBoundsException();
        }
        else if(i >= size){
            throw new IndexOutOfBoundsException();
        }
        else{
            E result = data[i];
            for(int j=i; j<size; j++){
                data[j] = data[j+1];
            }
            data[size-1] = null;
            size--;
            return result;
        }
    }
}