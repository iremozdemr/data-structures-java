public class Stack<E> implements StackInterface<E>{

    private int top;
    private int capacity;
    private E[] data;

    public Stack(){
        new Stack(25);
    }

    public Stack(int capacity){
        this.top = -1;
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
    }

    public int size(){
        int size = top+1;
        return size;
    }

    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public E top(){
        if(isEmpty()){
            return null;
        }
        else{
            E topElement = data[top];
            return topElement;
        }
    }

    public void push(E element){
        if(size() == capacity){
            try {
                throw new Exception("stack is full");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            data[top+1] = element;
            top++;
        }
    }

    public E pop(){
        if(isEmpty()){
            return null;
        }
        else{
            E topElement = top();
            data[top] = null;
            top--;
            return topElement;
        }
    }

    public void reverse(Stack<E> stack){
        Stack<E> buffer = new Stack<>(stack.size());
        int index = stack.top+1;
        for(int i = 0; i<index; i++){
            E element = stack.pop();
            buffer.push(element);
        }
        stack.data = buffer.data;
        stack.top = index-1;
    }

    public String toString(){
        String string = "";
        if(isEmpty()){
            return string;
        }
        else{
            for(int i = 0; i<top+1; i++){
                string = string + data[i] + " ";
            }
            return string;
        }
    }
}