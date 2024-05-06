public class LinkedListStack<E>{

    private SinglyLinkedList<E> list;

    public LinkedListStack(){
        list = new SinglyLinkedList<>();
    }

    public int size(){
        return list.getLength();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(E element){
        list.addLast(element);
    }

    public E pop(){
        E poppedElement = list.removeLast();
        return poppedElement;
    }

    public String toString(){
        return list.toString();
    }
}