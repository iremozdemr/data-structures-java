//getMin() O(1)
//extractMin() O(1)
//decreaseKey() O(logn)
//insert() O(logn)
//delete() O(logn)

package heap;

public class MinHeap{
    private int capacity;
    private int size;
    private int[] array;

    public MinHeap(int capacity){
        this.capacity = capacity;
        size = 0;
        array = new int[capacity];
    }

    private void swap(int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private int parent(int key){
        return (key-1)/2;
    }

    private int left(int key){
        return (key*2) + 1;
    }

    private int right(int key){
        return (key*2) + 2;
    }

    public boolean insert(int key){
        if(size == capacity){
            System.out.println("heap is full");
            return false;
        }
        else{
            array[size] = key;
            size++;

            int index = size-1;
            while(index != 0 && array[index] < array[parent(index)]){
                swap(index,parent(index));
                index = parent(index);
            }
            return true;
        }
    }

    public void decreaseKey(int index,int newKey){
        array[index] = newKey;
        while (index != 0 && array[index] < array[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void increaseKey(int index,int newKey){
        array[index] = newKey;
        minHeapify(index);
    }

    public int getMin(){
        if(size == 0){
            return Integer.MAX_VALUE;
        }
        else{
            return array[0];
        }
    }

    public int extractMin(){
        if(size == 0){
            return Integer.MAX_VALUE;
        }
        else if(size == 1){
            int element = array[0];
            size = 0;
            return element;
        }
        else{
            int element = array[0];
            array[0] = array[size-1];
            size--;
            minHeapify(0);

            return element;
        }
    }

    private void minHeapify(int index) {
        int left = left(index);
        int right = right(index);
        int smallest = index;

        if (left < size && array[left] < array[smallest]) {
            smallest = left;
        }
        if (right < size && array[right] < array[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(smallest, index);
            minHeapify(smallest);
        }
    }

    public void deleteKey(int index) {
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }
}