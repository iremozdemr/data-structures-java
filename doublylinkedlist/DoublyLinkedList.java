public class DoublyLinkedList<E>{
    private class Node<E>{
        private E data; // data in the node
        private Node<E> prev; // reference to the previous node
        private Node<E> next; // reference to the next node

        // node constructor
        public Node(E data, Node<E> prev, Node<E> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size; // size of the doubly linked list
    private Node<E> head; // reference to the head node
    private Node<E> tail; // reference to the tail node

    // doublylinkedlist constructor
    public DoublyLinkedList(){
        size = 0;
        head = new Node<E>(null,null,null); // initializing head with a dummy node
        tail = new Node<E>(null,null,null); // initializing tail with a dummy node
    }

    // returns the size of the list
    public int size(){
        return size;
    }

    // checks if the list is empty
    public boolean isEmpty(){
        if(size == 0){
            return true; // returns true if the list is empty
        }
        else{
            return false; // returns false if the list is not empty
        }
    }

    // adds a new node with data at the beginning of the list
    public void addFirst(E newData){
        if(isEmpty()){
            Node<E> newNode = new Node<E>(newData,head,tail); // creating a new node
            head.next = newNode; // setting newNode as the first node
            tail.prev = newNode; // setting newNode as the last node
            size++; // increments the size of the list
        }
        else{
            Node<E> newNode = new Node(newData,head,head.next);
            head.next.prev = newNode; // setting newNode as the previous node of the current first node
            head.next = newNode; // setting newNode as the first node
            size++; // increments the size of the list
        }
    }

    // adds a new node with data at the end of the list
    public void addLast(E newData){
        if(isEmpty()){
            Node<E> newNode = new Node<E>(newData,head,tail); // creating a new node
            head.next = newNode; // setting newNode as the first node
            tail.prev = newNode; // setting newNode as the last node
            size++; // increments the size of the list
        }
        else{
            Node<E> newNode = new Node(newData,tail.prev,tail);
            tail.prev.next = newNode; // setting newNode as the next node of the current last node
            tail.prev = newNode; // setting newNode as the last node
            size++; // increments the size of the list
        }
    }

    // removes and returns the data of the first node in the list
    public E removeFirst(){
        if(isEmpty()){
            return null; // returns null if the list is empty
        }
        else{
            E removed = head.next.data; // stores the data of the first node
            head.next = head.next.next; // updates the first node
            head.next.prev = head; // updates the previous node of the new first node
            return removed; // returns the data of the removed node
        }
    }

    // removes and returns the data of the last node in the list
    public E removeLast(){
        if(isEmpty()){
            return null; // returns null if the list is empty
        }
        else{
            E removed = tail.prev.data; // stores the data of the last node
            tail.prev = tail.prev.prev; // updates the last node
            tail.prev.next = tail; // updates the next node of the new last node
            return removed; // returns the data of the removed node
        }
    }

    // returns a string representation of the list
    public String toString(){
        String string = "";
        if(isEmpty()){
            return string; // returns an empty string if the list is empty
        }
        else{
            Node<E> temp = head.next;
            while(temp.next != null){
                string = string + " " + temp.data; // appends data to the string
                temp = temp.next; // moves to the next node
            }
            return string; // returns the string representation of the list
        }
    }
}
