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

    public int findSize(){
        if(head == null){
            return 0;
        }
        else if(head.next == null){
            return 1;
        }
        else{
            int count = 1;
            Node<E> temp = head;
            while(temp.next != null){
                temp = temp.next;
                count++;
            }
            return count;
        }
    }

    public int findSizeRecursive(){
        return helper(head);
    }

    private int helper(Node<E> node){
        if(node == null){
            return 0;
        }
        else{
            return helper(node.next)+1;
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

    //time complexity: O(1)
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

    public void swapNodes(E data1,E data2){
        boolean data1Found = false;
        boolean data2Found = false;

        Node<E> node1 = null;
        Node<E> node2 = null;
        Node<E> node1prev = null;
        Node<E> node2prev = null;
        Node<E> node1next = null;
        Node<E> node2next = null;

        if(data1 == data2){
            return;
        }
        else if(size <= 1){
            return;
        }
        else{
            if(head.data == data1){
                data1Found = true;
                node1 = head;
                node1next = head.next;
            }
            else if(head.data == data2){
                data2Found = true;
                node2 = head;
                node2next = head.next;
            }

            Node<E> temp = head;
            while(temp.next != null){
                if(temp.next.data == data1 && temp.next.next.data == data2){
                    data1Found = true;
                    data2Found = true;

                    node1prev = temp;
                    node1 = temp.next;
                    node1next = temp.next.next;

                    node2prev = temp.next;
                    node2 = temp.next.next;
                    node2next = temp.next.next.next;

                    node1prev.next = node2;
                    node2.next = node1;
                    node1.next = node2next;
                    return;
                }
                if(temp.next.data == data1){
                    data1Found = true;
                    node1prev = temp;
                    node1 = temp.next;
                    node1next = temp.next.next;
                }
                if(temp.next.data == data2){
                    data2Found = true;
                    node2prev = temp;
                    node2 = temp.next;
                    node2next = temp.next.next;
                }
                temp = temp.next;
            } 
            if(head.data == data1 && data2Found && node1.next == node2){
                head = node2;
                node1.next = node2next;
                node2.next = node1;
                return;
            }
            if(head.data == data2 && data1Found && node2.next == node1){
                head = node1;
                node2.next = node1next;
                node1.next = node2;
                return;
            }
            if(head.data == data1 && data2Found){
                head = node2;
                node2.next = node1next;

                node2prev.next = node1;
                node1.next = node2next;
            }
            else if(head.data == data2 && data1Found){
                head = node1;
                node1.next = node2next;

                node1prev.next = node2;
                node2.next = node1next;
            }  
            else if(data1Found && data2Found){
                if(node1.next.data == node2.data){
                    node1.next = node2next;
                    node2.next = node1;
                    node1prev.next = node2;
                    node2prev.next = node1;
                }
                else{
                    node1.next = node2next;
                    node2.next = node1next;
                    node1prev.next = node2;
                    node2prev.next = node1;
                }
            }
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
        SinglyLinkedList<Integer> myList1 = new SinglyLinkedList<>();

        myList1.addLast(1);
        myList1.addLast(2);
        myList1.addLast(3);
        myList1.addLast(4);

        System.out.println("list: " + myList1);

        SinglyLinkedList<Integer>.Node<Integer> node = myList1.head.next.next;
        myList1.insertAfter(node,11);

        System.out.println("list: " + myList1);
    }
}