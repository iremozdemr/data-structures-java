public class SinglyLinkedList<E>{

    private static class Node<E>{

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

        public E getData(){
            return data;
        }

        public void setData(E data){
            this.data = data;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setNext(Node<E> next){
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    @Override
    public String toString() {
        if(isEmpty()){
            return null;
        }
        else if(size == 1){
            return head.data.toString();
        }
        else{
            Node<E> newHead = head;
            String string= "";
            for(int i = 0; i<size; i++){
                string = string + " " + String.valueOf(newHead.data);
                newHead = newHead.next;
            }
            return string.substring(1);
        }
    }

    public E first(){
        if(isEmpty()){
            return null;
        }
        else{
            return head.data;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E deleteByIndex(int index){
        if(isEmpty() || index<0 || index>=size){
            return null;
        }
        else if(index == 0){
            return removeFirst();
        }
        else if(index == size-1){
            return removeLast();
        }
        else{
            Node<E> newHead = head;
            for(int i = 0; i<index-1; i++){
                newHead = newHead.next;
            }
            E removedD = newHead.next.data;
            newHead.next = newHead.next.next;
            size--;
            return removedD; 
        }
    }

    public void addLast(E data){
        if(isEmpty()){
            Node<E> newNode = new Node<E>(data,null);
            head = newNode;
            tail = newNode;
        }
        else if(size == 1){
            Node<E> newNode = new Node<E>(data,null);
            head.next = newNode;
            tail = newNode;
        }
        else{
            Node<E> newNode = new Node<E>(data,null);
            tail.next = newNode;
            tail.next.data = data;
            tail = newNode;
            tail.next = null;
        }
        size++;
    }

    public void addFirst(E data){
        if(isEmpty()){
            Node<E> newNode = new Node<E>(data,null);
            head = newNode;
            tail = newNode;
        }
        else if(size == 1){
            Node<E> secondNode = head;
            Node<E> newNode = new Node<E>(data,secondNode);
            head = newNode;
        }
        else{
            Node<E> newNode = new Node<E>(data,head);
            head = newNode;
        }
        size++;
    }

    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        else if(size == 1){
            E removedD = head.data;
            head = null;
            tail = null;
            size--;
            return removedD;
        }
        else{
            Node<E> newHead = head;
            Node<E> secondNode = null;
            for(int i = 0; i<size-1; i++){
                secondNode = newHead;
                newHead = newHead.next;
            }
            E removedD = secondNode.next.data;
            secondNode.next = null;
            tail = secondNode;
            size--;
            return removedD;
        }
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        else if(size == 1){
            E removedD = head.data;
            head = null;
            tail = null;
            size--;
            return removedD;
        }
        else{
            E removeD = head.data;
            head = head.next;
            size--;
            return removeD;
        }
    }

    public int size(){
        Node<E> temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        return length;
    }
}