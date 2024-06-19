public class Main {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>();

        // enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        // print the queue
        System.out.println("initial queue: " + queue);

        // rotate the queue
        queue.rotate();
        System.out.println("queue after one rotation: " + queue);

        // dequeue an element
        System.out.println("dequeued element: " + queue.dequeue());
        System.out.println("queue after dequeue: " + queue);

        // rotate the queue again
        queue.rotate();
        System.out.println("queue after second rotation: " + queue);

        // check the first element
        System.out.println("first element: " + queue.first());

        // check if the queue is empty
        System.out.println("is queue empty? " + queue.isEmpty());

        // print the size of the queue
        System.out.println("queue size: " + queue.size());
    }
}