public class CircularQueue<E> implements CircularQueueInterface<E>{

    CircularSinglyLinkedList<E> list;

    public CircularQueue(){
        list = new CircularSinglyLinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public void rotate() {
        list.rotate();
    }

    public String toString(){
        return list.toString();
    }
    
}