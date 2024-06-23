package array_based_tree;

public class BinaryTree<E>{
    
    private int capacity;
    private int size;
    private E[] array;

    @SuppressWarnings("unchecked")
    public BinaryTree(int capacity){
        this.capacity = capacity;
        size = 0;
        array = (E[]) new Object[capacity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E root(){
        if(isEmpty()){
            return null;
        }
        else{
            return array[0];
        }
    }

    public E parent(int index) throws Exception{
        if(index<0 || index>=capacity){
            throw new Exception();
        }
        else if(index == 0){
            return null;
        }
        else if(index % 2 == 0){
            int parent = (index-2)/2;
            return array[parent];
        }
        else{
            int parent = (index-1)/2;
            return array[parent];
        }
    }

    public E left(int index) throws Exception{
        if(index<0 || index>=capacity){
            throw new Exception();
        }

        int left = (index*2)+1;

        if(left >= capacity){
            throw new Exception();
        }

        return array[left];
    }

    public E right(int index) throws Exception{
        if(index<0 || index>=capacity){
            throw new Exception();
        }

        int right = (index*2)+2;

        if(right >= capacity){
            throw new Exception();
        }

        return array[right];
    }

    public void add(int index,E element) throws Exception{
        if(index<0 || index>=capacity){
            throw new Exception();
        }
        else{
            array[index] = element;
            size++;
        }
    }

    public E remove(int index) throws Exception{
        if(index<0 || index>=capacity){
            throw new Exception();
        }
        else{
            E element = array[index];
            array[index] = null;
            size--;
            return element;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int nodesInLevel = 1;
        int start = 0;
    
        while (start < capacity) {
            int end = Math.min(start + nodesInLevel, capacity);
            for (int i = start; i < end; i++) {
                if (array[i] != null) {
                    sb.append(array[i]).append("\t");
                } else {
                    sb.append(".\t");
                }
            }
            sb.append("\n");
            start = end;
            nodesInLevel *= 2;
        }
    
        return sb.toString();
    }    
}