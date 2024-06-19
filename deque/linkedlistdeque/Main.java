package deque.linkedlistdeque;

public class Main {
    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();

        // addFirst ve addLast metodlarının test edilmesi
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addFirst(5);
        System.out.println("deque: " + deque);

        // removeFirst ve removeLast metodlarının test edilmesi
        deque.removeFirst();
        deque.removeLast();
        System.out.println("deque after removing first and last elements: " + deque);

        // first ve last metodlarının test edilmesi
        System.out.println("first element: " + deque.first());
        System.out.println("last element: " + deque.last());

        // isEmpty ve size metodlarının test edilmesi
        System.out.println("is deque empty?: " + deque.isEmpty());
        System.out.println("deque size: " + deque.size());
    }
}