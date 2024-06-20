//size() O(1)
//isEmpty() O(1)
//first() O(1)
//last() O(1)
//before() O(1)
//after() O(1)
//addFirst() O(1)
//addLast() O(1)
//addBefore() O(1)
//addAfter() O(1)
//set() O(1)
//remove() O(1)

//space usage = O(n)

package positionallist;

public class PositionalList<E> implements PositionalListInterface<E>{

    @SuppressWarnings("hiding")
    private class Node<E> implements Position<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element,Node<E> prev,Node<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }
        
        public String toString(){
            return element.toString();
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public PositionalList(){
        head = new Node<E>(null,null,null);
        tail = new Node<E>(null,null, null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<E> first() {
        if(isEmpty()){
            return null;
        }
        else{
            return (Position<E>) head.next;
        }
    }

    @Override
    public Position<E> last() {
        if(isEmpty()){
            return null;
        }
        else{
            return (Position<E>) tail.prev;
        }
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException{
        if(p == first()){
            return null;
        }
        else{
            Node<E> node = (Node<E>)p;
            return node.prev;
        }
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException{
        if(p == last()){
            return null;
        }
        else{
            Node<E> node = (Node<E>)p;
            return node.next;
        }
    }

    @Override
    public Position<E> addFirst(E element) {
        size++;
        if(isEmpty()){
            Node<E> newNode = new Node<E>(element,head,tail);
            head.next = newNode;
            tail.prev = newNode;
            return (Position<E>) newNode;
        }
        else{
            Node<E> newNode = new Node<E>(element,head,head.next);
            head.next.prev = newNode;
            head.next = newNode;
            return (Position<E>) newNode;
        }
    }

    @Override
    public Position<E> addLast(E element) {
        size++;
        if(isEmpty()){
            Node<E> newNode = new Node<E>(element,head,tail);
            head.next = newNode;
            tail.prev = newNode;
            return (Position<E>) newNode;
        }
        else{
            Node<E> newNode = new Node<E>(element,tail.prev,tail);
            tail.prev.next = newNode;
            tail.prev = newNode;
            return (Position<E>) newNode;
        }
    }

    @Override
    public Position<E> addBefore(Position<E> p, E element) throws IllegalArgumentException{
        if(isEmpty()){
            return null;
        }
        else{
            Node<E> current = (Node<E>) p;
            Node<E> newNode = new Node<E>(element,null,null);
            current.prev.next = newNode;
            newNode.prev = current.prev;
            current.prev = newNode;
            newNode.next = current;
            return (Position<E>) newNode;
        }
    }

    @Override
    public Position<E> addAfter(Position<E> p, E element) throws IllegalArgumentException{
        Node<E> current = (Node<E>) p;
        if(isEmpty()){
            return null;
        }
        else if(current == tail){
            Node<E> newNode = new Node<E>(element,current,null);
            current.next = newNode;
            tail = newNode;
            return (Position<E>) newNode;
        }
        else{
            Node<E> newNode = new Node<E>(element,current,current.next);
            current.next.prev = newNode;
            current.next = newNode;
            return (Position<E>) newNode;
        }
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        E old = null;
        if(isEmpty()){
            return old;
        }
        else{
            Node<E> node = (Node<E>) p;
            Node<E> current = head;
            while(current != tail.next){
                if(current == node){
                    old = current.element;
                    current.element = e;
                    break;
                }
                current = current.next;
            }
            return old;
        }
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException{
        Node<E> node = (Node<E>) p;
        if(isEmpty()){
            return null;
        }
        else if(node == tail.prev){
            size--;
            E removed = node.element;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            return removed;
        }
        else{
            E removed = null;
            Node<E> current = head.next;
            while(current != tail){
                if(node == current){
                    size--;
                    removed = node.element;
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current = null;
                    break;
                }
                current = current.next;
            }
            return removed;
        }
    }

    public String toString(){
        String string = "";
        if(isEmpty()){
            return string;
        }
        else{
            Node<E> current = head.next;
            while(current.next != null){
                string = string + " "  + current.element;
                current = current.next;
            }
            return string.substring(1);
        }
    }
}