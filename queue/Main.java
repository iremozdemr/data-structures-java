public class Main {
    public static void main(String[] args) {
        // Create a Queue
        Queue<Integer> queue = new Queue<>(5);

        // Test isEmpty and size methods
        System.out.println("Is queue empty: " + queue.isEmpty());
        System.out.println("Queue size: " + queue.size());

        // Test enqueue methods
        try {
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.enqueue(40);
            queue.enqueue(50);
            // Test exceeding capacity
            queue.enqueue(60);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test isEmpty and size methods
        System.out.println("Is queue empty: " + queue.isEmpty());
        System.out.println("Queue size: " + queue.size());

        // Print the queue using the toString method
        System.out.println("Queue elements: " + queue.toString());

        // Test the first method
        System.out.println("First element: " + queue.first());

        // Test dequeue methods
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        // Test the clear method
        queue.clear();
        System.out.println("Is queue empty after clear: " + queue.isEmpty());
        System.out.println("Queue size after clear: " + queue.size());
    }
}