package deque.arraydeque;

public class ArrayDeque<E> implements DequeInterface<E>{
    
    int size;
    int capacity;
    int front;
    int back;
    E[] data;

    @SuppressWarnings("unchecked")
    public ArrayDeque(int capacity){
        size = 0;
        this.capacity = capacity;
        front = -1;
        back = 0;
        data = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayDeque(){
        size = 0;
        capacity = 1000;
        front = -1;
        back = 0;
        data = (E[]) new Object[capacity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if(isEmpty()){
            return null;
        }
        else{
            return data[front];
        }
    }

    public E last(){
        if(isEmpty()){
            return null;
        }
        else{
            return data[back];
        }
    }

    public void addFirst(E element){
        if(size == data.length){
            throw new IllegalStateException("deque is full");
        }
        else{
            if(isEmpty()){
                front = 0;
                back = 0;
                data[front] = element;
            }
            else if(front == 0){
                front = data.length-1;
                data[front] = element;
            }
            else{
                front--;
                data[front] = element;
            }
            size++;
        }
    }

    public void addLast(E element){
        if(size == data.length){
            throw new IllegalStateException("deque is full");
        }
        else{
            if(isEmpty()){
                front = 0;
                back = 0;
                data[back] = element;
            }
            else if(back == data.length-1){
                back = 0;
                data[back] = element;
            }
            else{
                back++;
                data[back] = element;
            }
            size++;
        }
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        else{
            E element = data[front];
            if(size == 1){
                front = -1;
                back = 0;
            }
            else if(front == data.length-1){
                front = 0;
            }
            else{
                front++;
            }
            size--;
            return element;
        }
    }

    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        else{
            E element = data[back];
            if(size == 1){
                front = -1;
                back = 0;
            }
            else if(back == 0){
                back = data.length-1;
            }
            else{
                back--;
            }
            size--;
            return element;
        }
    }

    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            String string = data[front].toString();
            int index = (front + 1) % data.length;
    
            while (index != (back + 1) % data.length) {
                string += " " + data[index];
                index = (index + 1) % data.length;
            }
    
            return string;
        }
    }    
}