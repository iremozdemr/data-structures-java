package deque.linkedlistdeque;

public class LinkedListDeque<E>{

    public DoublyLinkedList<E> list;

    public LinkedListDeque(){
        list = new DoublyLinkedList<>();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public E first(){
        return list.first();
    }

    public E last(){
        return list.last();
    }

    public void addFirst(E element){
        list.addFirst(element);
    }

    public void addLast(E element){
        list.addLast(element);
    }

    public E removeFirst(){
        return list.removeFirst();
    }

    public E removeLast(){
        return list.removeLast();
    }

    public String toString(){
        return list.toString();
    }
}