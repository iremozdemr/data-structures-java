public class ArrayList<E> implements List<E>{
    private int capacity;
    private int size;
    private Object[] array;

    public ArrayList(){
        capacity = 16;
        size = 0;
        array = new Object[capacity];
    }

    public ArrayList(int capacity){
        this.capacity = capacity;
        size = 0;
        array = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if(index > size-1){
            throw new IndexOutOfBoundsException();
        }
        else if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        else{
            return (E)array[index];
        }
    }

    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException {
        if(index > size-1){
            throw new IndexOutOfBoundsException();
        }
        else if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        else{
            E old = (E)array[index];
            array[index] = element;
            return old;
        }
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException, IllegalStateException{
        if(index > size){
            throw new IndexOutOfBoundsException();
        }
        else if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        else if(size == capacity){
            throw new IllegalStateException();
        }
        else{
            if(index == size){
                array[index] = element;
            }
            else{
                for(int i = size-1; i>index; i--){
                    array[i+1] = array[i];
                }
                array[index] = element;
                size++;
            }
        }
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if(index > size-1){
            throw new IndexOutOfBoundsException();
        }
        else if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        else{
            E removed = (E) array[index];
            if(index == size-1){
                array[index] = null;
            }
            else{
                for(int i = index; i<size-1; i++){
                    array[i] = array[i+1];
                }
                array[size-1] = null;
            }
            size--;
            return removed;
        }
    }
}