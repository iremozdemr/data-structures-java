public class SinglyLinkedList<E>{
    private class Node<E>{
        E data;
        Node<E> next;

        public Node(E data,Node<E> next){
            this.data = data;
            this.next = next;
        }

        /* 
        public Node(E data){
            this.data = data;
            next = null;
        }
        */
    }

    private int size;
    private Node<E> head;

    public SinglyLinkedList(){
        size = 0;
        head = null;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public E first(){
        if(isEmpty()){
            return null;
        }
        else{
            return head.data;
        }
    }

    public E last(){
        if(isEmpty()){
            return null;
        }
        else{
            Node<E> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            return temp.data;
        }
    }

    public void addFirst(E newData){
        Node<E> newNode = new Node<E>(newData,null);
        newNode.next = head;
        head = newNode;
        size++;
    }

    //time complexity: O(n)
    //tail eklenirse time complexity: O(1)
    //auxiliary space: O(1)
    public void addLast(E newData){
        Node<E> newNode = new Node<E>(newData,null);
        if(isEmpty()){
            head = newNode;
        }
        else{
            Node<E> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        else{
            E removed = head.data;
            head = head.next;
            size--;
            return removed;
        }
    }

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

    public E removeByIndex(int index){
        if (isEmpty() || index<0 || index>=size){
            return null;
        }
        else if(size == 1 || index == 0){
            E removed = removeFirst();
            return removed;
        }
        else{
            Node<E> temp = head;
            for(int i=0; i<index-1; i++){
                temp = temp.next;
            }
            E removed = temp.next.data;
            Node<E> newNext = temp.next.next;
            temp.next = newNext;
            size--;
            return removed;
        }
    }

    //time complexity: O(1)
    //auxiliary space: O(1)
    public void insertAfter(Node<E> previous,E newData){
        if(previous == null){
            System.out.println("the given previous node cannot be null");
            return;
        }
        else if(isEmpty()){
            System.out.println("the linkedlist is empty");
        }
        else{
            Node<E> newNode = new Node<E>(newData,null);
            Node<E> newNext = previous.next;
            previous.next = newNode;
            newNode.next = newNext;
            size++;
        }
    }

    public String toString(){
        String string = "";
        Node<E> temp = head;
        while(temp != null){
            string = string + " " + temp.data.toString();
            temp = temp.next;
        }
        return string;
    }

    //test code for insertAfter()
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();

        //qdd elements to the list if it's empty
        myList.addLast(1);
        myList.addLast(2);
        myList.addLast(3);
        myList.addLast(4);

        //print the current state of the list
        System.out.println("list: " + myList);

        //perform insertion after a node
        //get the node pointing to 3
        SinglyLinkedList<Integer>.Node<Integer> node = myList.head.next.next;
        myList.insertAfter(node,11);

        //print the results
        System.out.println("new list: " + myList);
    }
}