import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample2 {
    public static void main(String[] args) {

        Queue<Double> queue = new LinkedList<>();
        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);

        System.out.println(queue);

        while(queue.isEmpty() == false){
            System.out.println(queue.poll());
        }


        Queue<Double> priorityQueue1 = new PriorityQueue<>();
        priorityQueue1.offer(3.0);
        priorityQueue1.offer(2.5);
        priorityQueue1.offer(4.0);
        priorityQueue1.offer(1.5);
        priorityQueue1.offer(2.0);

        System.out.println(priorityQueue1);

        while(priorityQueue1.isEmpty() == false){
            System.out.println(priorityQueue1.poll());
        }


        Queue<Double> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue2.offer(3.0);
        priorityQueue2.offer(2.5);
        priorityQueue2.offer(4.0);
        priorityQueue2.offer(1.5);
        priorityQueue2.offer(2.0);

        System.out.println(priorityQueue2);

        while(priorityQueue2.isEmpty() == false){
            System.out.println(priorityQueue2.poll());
        }
    }
}