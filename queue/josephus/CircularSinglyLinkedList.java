public class CircularSinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }

    private Node<E> tail = null; // we store tail (but not head)
    private int size = 0;

    public CircularSinglyLinkedList() { } // constructs an initially empty list

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement(); // the head is *after* the tail
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) { // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // link to itself circularly
        } else {
            Node<E> newNode = new Node<>(e, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        addFirst(e); // insert new element at front of list
        tail = tail.getNext(); // now new element becomes the tail
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) return null; // nothing to remove
        Node<E> head = tail.getNext();
        if (head == tail) // must be the only node left
            tail = null; // list becomes empty
        else
            tail.setNext(head.getNext()); // bypass the old head
        size--;
        return head.getElement();
    }

    public void rotate() { // rotate the first element to the back of the list
        if (tail != null) // if empty, do nothing
            tail = tail.getNext(); // the old head becomes the tail
    }

    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = tail.getNext(); // start from the head
        for (int i = 0; i < size; i++) {
            sb.append(current.getElement());
            if (i < size - 1) sb.append(", ");
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}