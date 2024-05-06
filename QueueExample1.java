import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample1 {
    public static void main(String[] args) {
        
        //first in first out
        //offer = add
        //poll = remove

        Queue<String> queue1 = new LinkedList<>();

        queue1.offer("karen");
        queue1.offer("chad");
        queue1.add("steve");
        queue1.add("harold");

        System.out.println(queue1);

        System.out.println(queue1.peek());
        //peek methodu exception firlatmiyor

        queue1.poll();
        queue1.remove();
        //poll methodu exception firlatmiyor
        //remove methodu exception firlatiyor

        System.out.println(queue1);


        System.out.println("-----------------------------------");


        Queue<String> queue2 = new ArrayDeque<>();

        queue2.offer("karen");
        queue2.offer("chad");
        queue2.add("steve");
        queue2.add("harold");

        System.out.println(queue2);

        System.out.println(queue2.peek());
        //peek methodu exception firlatmiyor

        queue2.poll();
        queue2.remove();
        //poll methodu exception firlatmiyor
        //remove methodu exception firlatiyor

        System.out.println(queue2);
    }
}
