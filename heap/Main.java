package heap;

public class Main {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(11);
        heap.insert(3);
        heap.insert(2);
        heap.deleteKey(1);
        heap.insert(15);
        heap.insert(5);
        heap.insert(4);
        heap.insert(45);

        System.out.println(heap.extractMin());
        System.out.println(heap.getMin());

        heap.decreaseKey(2,1);
        System.out.println(heap.getMin());
    }
}