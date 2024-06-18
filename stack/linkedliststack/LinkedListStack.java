public class LinkedListStack<E> implements StackInterface<E>{

    private SinglyLinkedList<E> list;

    public LinkedListStack(){
        list = new SinglyLinkedList<>();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(E element){
        list.addFirst(element);
    }

    public E pop(){
        E poppedElement = list.removeFirst();
        return poppedElement;
    }

    public E top() {
        return list.first();
    }

    public String toString(){
        return list.toString();
    }
}