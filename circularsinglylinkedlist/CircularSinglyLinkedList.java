public class CircularSinglyLinkedList<E>{
    private class Node<E>{
        private E data; // data of the node
        private Node<E> next; // reference to the next node

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> tail = null; // reference to the tail of the list
    private int size; // size of the list

    public boolean isEmpty(){ // checks if the list is empty
        if(size == 0){
            return true; // returns true if the list is empty
        }
        else{
            return false; // returns false if the list is not empty
        }
    }

    public int size(){ // returns the size of the list
        return size;
    }

    public E first(){ // returns the data of the first node in the list
        if(isEmpty()){
            return null; // returns null if the list is empty
        }
        else{
            return tail.next.data; // returns the data of the first node
        }
    }

    public E last(){ // returns the data of the last node in the list
        if(isEmpty()){
            return null; // returns null if the list is empty
        }
        else{
            return tail.data; // returns the data of the last node
        }
    }

    public void rotate(){ // rotates the list by moving the tail to the next node
        if(isEmpty() == false){
            tail = tail.next;
        }
    }

    public void addFirst(E newData){ // adds a new node with data at the beginning of the list
        if(isEmpty()){
            Node<E> newNode = new Node<E>(newData,null);
            tail = newNode; // sets the new node as both tail and head
            tail.next = tail;
        }
        else{
            Node<E> newNode = new Node<E>(newData,tail.next);
            tail.next = newNode; // sets the new node as the first node
        }
        size++; // increments the size of the list
    }

    public void addLast(E newData){ // adds a new node with data at the end of the list
        if(isEmpty()){
            Node<E> newNode = new Node<E>(newData,null);
            tail = newNode; // sets the new node as both tail and head
            tail.next = tail;
        }
        else{
            Node<E> newNode = new Node<E>(newData,tail.next);
            tail.next = newNode; // sets the new node as the next node of the current tail
            tail = newNode; // sets the new node as the new tail
        }
        size++; // increments the size of the list
    }

    public E removeFirst(){ // removes and returns the data of the first node in the list
        if(isEmpty()){
            return null; // returns null if the list is empty
        }
        else{
            E removed = tail.next.data;
            tail.next = tail.next.next; // sets the next node as the new first node
            size--; // decrements the size of the list
            return removed; // returns the data of the removed node
        }
    }

    public E removeLast(){ // removes and returns the data of the last node in the list
        if(isEmpty()){
            return null; // returns null if the list is empty
        }
        else if(size == 1){
            E removed = tail.data;
            tail = null; // removes the only node in the list
            size--; // decrements the size of the list
            return removed; // returns the data of the removed node
        }
        else{
            E removed = tail.data;
            Node<E> temp = tail.next;
            while(temp.next != tail){
                temp = temp.next;
            }
            temp.next = tail.next; // sets the previous node of tail as the new last node
            tail = temp; // sets the current node as the new tail
            size--; // decrements the size of the list
            return removed; // returns the data of the removed node
        }
    }

    public String toString(){ // returns a string representation of the list
        String string = "";
        if(isEmpty()){
            return string; // returns an empty string if the list is empty
        }
        else{
            string = string + " " + tail.next.data;
            Node<E> temp = tail.next.next;
            while(temp != tail.next){
                string = string + " " + temp.data; // appends data to the string
                temp = temp.next; // moves to the next node
            }
            return string; // returns the string representation of the list
        }
    }
}