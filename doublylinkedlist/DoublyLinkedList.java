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

    // this method returns a new list containing the intersection of elements from the original list and the given list2 
    // it is assumed that both lists are sorted in ascending order 
    // the new list will also be sorted in ascending order
    public DoublyLinkedList<E> findIntersection(DoublyLinkedList<E> list2){
        DoublyLinkedList<E> list1 = this;
        DoublyLinkedList<E> newList = new DoublyLinkedList<>();

        /* 
        if(list1.isEmpty() && list2.isEmpty()){
            return newList;
        }
        else if(list1.isEmpty()){
            return newList;
        }
        else if(list2.isEmpty()){
            return newList;
        }
        */

        if(list1.isEmpty() || list2.isEmpty()){
            return newList;
        }
        else{
            Node<E> temp = head.next;
            while(temp != tail){
                if(list2.contains(temp.data)){
                    newList.addLast(temp.data);
                }
                temp = temp.next;
            }
            return newList;
        }
    }

    // this method checks if the list contains a node with the specified data
    // it returns true if such a node is found, otherwise it returns false
    // !!!!!!!use equals to compare data
    public boolean contains(E data){
        if (isEmpty()){
            return false;
        }
        else{
            boolean result = false;
            Node<E> temp = head.next;
            while(temp != tail){
                if(temp.data.equals(data)){
                    result = true;
                }
                temp = temp.next;
            }
            return result;
        }
    }

    public void rotate(int rotateCount){
        if (isEmpty() || size==1 || rotateCount==0) {
            return;
        }
        else{
            if(rotateCount > 0){
                for(int i=0; i<rotateCount; i++){
                    Node<E> newFirst = tail.prev;
                    Node<E> newLast = tail.prev.prev;

                    Node<E> newSecond = head.next;

                    newLast.next = tail;
                    tail.prev = newLast;

                    newFirst.next = newSecond;
                    newSecond.prev = newFirst;

                    head.next = newFirst;
                    newFirst.prev = head;
                }
            }
            else{
                rotateCount = Math.abs(rotateCount);
                for(int i=0; i<rotateCount; i++){
                    Node<E> newFirst = head.next.next;
                    Node<E> newLast = head.next;

                    Node<E> newSecondLast = tail.prev;

                    head.next = newFirst;
                    newFirst.prev = head;

                    newSecondLast.next = newLast;
                    newLast.prev = newSecondLast;
                    newLast.next = tail;
                    tail.prev = newLast;
                }
            }
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
