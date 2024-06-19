public class LinkedListQueue<E> implements QueueInterface<E>{

    private SinglyLinkedList<E> list;

    public LinkedListQueue(){
        list = new SinglyLinkedList<>();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        if(list.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public void enqueue(E element){
        list.addLast(element);
    }

    public E dequeue(){
        E element = list.removeFirst();
        return element;
    }

    public E first(){
        return list.first();
    }
}