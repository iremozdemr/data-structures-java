public class CircularQueue<E>{

    CircularSinglyLinkedList<E> list;

    public CircularQueue(){
        list = new CircularSinglyLinkedList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E element) {
        list.addLast(element);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public E first() {
        return list.first();
    }

    public void rotate() {
        list.rotate();
    }

    public String toString(){
        return list.toString();
    }
    
}