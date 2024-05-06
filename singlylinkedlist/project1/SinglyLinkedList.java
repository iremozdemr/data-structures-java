public class SinglyLinkedList<E> implements Cloneable{

    //-----nested node class-----
    private class Node<E>{
        private E data; // data of the node
        private Node<E> next; // reference to the next node

        // node constructor
        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }
    //-----end of the nested node class-----

    private Node<E> head = null; // reference to the head of the list
    private Node<E> tail = null; // reference to the tail of the list
    private int size; // size of the list

    // singlylinkedlist constructor
    public SinglyLinkedList(){
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

    // returns the size of the list
    public int size(){
        return size; // returns the size of the list
    }

    // returns the data of the first node in the list
    public E first(){
        if(isEmpty()){
            return null; // returns null if the list is empty
        }
        else{
            return head.data; // returns the data of the first node
        }
    }

    // returns the data of the last node in the list
    public E last(){
        if(isEmpty()){
            return null; // returns null if the list is empty
        }
        else{
            return tail.data; // returns the data of the last node
        }
    }

    // adds a new node with data at the beginning of the list
    public void addFirst(E newData){
        if(isEmpty()){
            Node<E> newNode = new Node<E>(newData,null);
            head = newNode; // sets the new node as both head and tail
            tail = newNode;
        }
        else{
            Node<E> newNode = new Node<E>(newData,head);
            head = newNode; // sets the new node as the new head
        }
        size++; // increments the size of the list
    }

    // adds a new node with data at the end of the list
    public void addLast(E newData){
        if(isEmpty()){
            Node<E> newNode = new Node<E>(newData,null);
            head = newNode; // sets the new node as both head and tail
            tail = newNode;
        }
        else{
            Node<E> newNode = new Node<E>(newData,null);
            tail.next = newNode; // sets the new node as the next node of the tail
            tail = newNode; // sets the new node as the new tail
        }
        size++; // increments the size of the list
    }

    // removes and returns the data of the first node in the list
    public E removeFirst(){
        if(isEmpty()){
            return null; // returns null if the list is empty
        }
        else{
            E removed = head.data; // stores the data of the first node
            Node<E> newHead = head.next;
            head = null;
            head = newHead; // sets the next node as the new head
            size--; // decrements the size of the list
            return removed; // returns the data of the removed node
        }
    }

    // removes and returns the data of the last node in the list
    public E removeLast(){
        if (isEmpty()) {
            return null;
        }
        else if(size() == 1){
            E removed = head.data;
            head = null;
            size--;
            return removed;
        }
        else{
            Node<E> temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            E removed = temp.next.data;
            temp.next = null;
            size--;
            return removed;
        }
    }

    /* 
    public E removeByIndex(int index){
        E removed = null;
        if(isEmpty()){
            return removed;
        }
        else{
            if(index == 0){
                removed = removeFirst();
            }
            else if(index == size-1){
                removed = removeLast();
            }
            else{
                Node<E> temp = head;
                for(int i = 0; i<size; i++){
                    if(i+1 == index){
                        removed = temp.next.data;
                        temp.next = temp.next.next;
                        size--;
                        return removed;
                    }
                    temp = temp.next;
                }
            }
        }
        return removed;
    }
    */

    // returns a string representation of the list
    public String toString(){
        String string = "";
        if(isEmpty()){
            return string; // returns an empty string if the list is empty
        }
        else{
            Node<E> temp = head;
            while(temp.next != null){
                string = string +  " " + temp.data; // appends data to the string
                temp = temp.next; // moves to the next node
            }
            string = string + " " + tail.data; // appends the last node's data
            return string; // returns the string representation of the list
        }
    }

    public boolean equals(SinglyLinkedList list){
        if(list == null){
            return false;
        }
        if(this.getClass() != list.getClass()){
            return false;
        }
        if(this.size != list.size){
            return false;
        }
        Node<E> temp1 = this.head;
        Node<E> temp2 = list.head;
        while(temp1 != null && temp2 != null){
            if(temp1.data.equals(temp2.data) == false){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public SinglyLinkedList<E> clone() throws CloneNotSupportedException{
        SinglyLinkedList<E> list = (SinglyLinkedList<E>)super.clone();
        if(this.isEmpty() == false){
            Node<E> newHead = new Node<E>(this.head.data,null);
            Node<E> newTail = new Node<E>(this.tail.data,null);
            list.head = newHead;
            list.tail = newTail;
            Node<E> temp1 = head.next;
            Node<E> temp2 = newHead;
            while(temp1 != null){
                Node<E> newNode = new Node<E>(temp1.data,null);
                temp2.next = newNode;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return list;
    }
}